package com.askhmer.model.repositoriesImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.askhmer.model.dto.ProfileUserDTO;
import com.askhmer.model.repositories.ProfileUserDAO;

@Repository
public class ProfileUserDAOImpl implements ProfileUserDAO{
	
	private final String SQL_READ_BRIEF = "SELECT `user_id`," + 
											"`user_no`," +
											"`facebook_id`," +
											"`user_name`," +
											"`user_photo`," +
											"`user_regis_date` FROM `tbl_user`" + 
											"WHERE `facebook_id` = ? OR `user_phone_num` = ? OR `user_email` = ?";
	
	private final String SQL_READ_DETAIL = "SELECT `user_id`," +
											"`facebook_id`," +
											"`user_name`," +
											"`user_no`," +
											"`user_photo`," + 
											"`user_phone_num`," + 
											"`user_email`," +
											"`user_current_city`," + 
											"`user_hometown`," +
											"`user_regis_date` FROM `tbl_user` WHERE `user_id` = ?";
	
	private final String SQL_MODIFIED_PROFILE = "UPDATE `tbl_user` SET `user_name` = ?, " +
																		"`user_no` = ?, " + 
																		"`user_phone_num` = ?," + 
																		"`user_current_city` = ?," + 
																		"`user_hometown` = ? WHERE `user_id` = ?";
	
	private final String SQL_READ_PASSWORD = "SELECT `user_id`, `user_email` FROM `tbl_user` WHERE `user_id` = ?";
	
	private final String SQL_VALID_AUTH = "SELECT `user_id` FROM `tbl_user` WHERE 	`user_email` = ? AND " + 
																				"`user_password` = ? AND " +
																				"`user_id` = ?";
	
	private final String SQL_MODIFIED_AUTH_EMAIL = "UPDATE `tbl_user` SET `user_email` = ?, `user_password` = ? WHERE `user_id` = ?";
	
	private final String SQL_MODIFED_IMAGE = "UPDATE `tbl_user` SET `user_photo` = ? WHERE `user_id` = ?";
	
	private List<ProfileUserDTO> lstProfileUser = null;
	private JdbcTemplate jdbcTemplate = null;

	@Autowired
	DataSource dataSource;
	
	//FOR Fragment Four Display Image and Some Text
	@Override
	public List<ProfileUserDTO> getBriefUserInfoRepository(final ProfileUserDTO profileUser) {
		jdbcTemplate = new JdbcTemplate(dataSource); 
		lstProfileUser = jdbcTemplate.query(SQL_READ_BRIEF, new PreparedStatementSetter() {			
			@Override
			public void setValues(PreparedStatement prepared) throws SQLException {
				prepared.setString(1, profileUser.getFacebook_id());
				prepared.setString(2, profileUser.getUser_phone_num());
				prepared.setString(3, profileUser.getUser_email());
			}
		}, new RowMapper<ProfileUserDTO>() {
			@Override
			public ProfileUserDTO mapRow(ResultSet result, int rowNum) throws SQLException {
				ProfileUserDTO profileUserData = new ProfileUserDTO();
					profileUserData.setUser_id(result.getString("user_id"));
					profileUserData.setUser_no(result.getString("user_no"));
					profileUserData.setFacebook_id(result.getString("facebook_id"));
					profileUserData.setUser_name(result.getString("user_name"));
					profileUserData.setUser_photo(result.getString("user_photo"));
					profileUserData.setUser_regis_date(result.getString("user_regis_date"));
				return profileUserData;
			}
		}); 
		return lstProfileUser;
	}
	
	//For Profile Detail Information
	@Override
	public List<ProfileUserDTO> getDetailUserInfoRepository(final int user_id) {
		jdbcTemplate = new JdbcTemplate(dataSource); 
		lstProfileUser = jdbcTemplate.query(SQL_READ_DETAIL, new PreparedStatementSetter() {			
			@Override
			public void setValues(PreparedStatement prepared) throws SQLException {
				prepared.setInt(1, user_id);
			}
		}, new RowMapper<ProfileUserDTO>() {
			@Override
			public ProfileUserDTO mapRow(ResultSet result, int rowNum) throws SQLException {
				ProfileUserDTO profileUserData = new ProfileUserDTO();
					profileUserData.setUser_id(result.getString("user_id"));
					profileUserData.setFacebook_id(result.getString("facebook_id"));
					profileUserData.setUser_name(result.getString("user_name"));
					profileUserData.setUser_no(result.getString("user_no"));
					profileUserData.setUser_photo(result.getString("user_photo"));
					profileUserData.setUser_phone_num(result.getString("user_phone_num"));
					profileUserData.setUser_email(result.getString("user_email"));
					profileUserData.setUser_current_city(result.getString("user_current_city"));
					profileUserData.setUser_hometown(result.getString("user_hometown"));
					profileUserData.setUser_regis_date(result.getString("user_regis_date"));
				return profileUserData;
			}
		});
		return lstProfileUser;
	}

	//Modified Profile Detail Information
	@Override
	public List<ProfileUserDTO> modifiedUserInfoRepository(final int user_id, final ProfileUserDTO profileUser) {
		jdbcTemplate = new JdbcTemplate(dataSource);
		int isUpdated  = jdbcTemplate.update(SQL_MODIFIED_PROFILE, 	new Object[] {
																			profileUser.getUser_name(),
																			profileUser.getUser_no(), 
																			profileUser.getUser_phone_num(),
																			profileUser.getUser_current_city(), 
																			profileUser.getUser_hometown(), 
																			user_id
																		});
		if(isUpdated <= 0) System.out.println("No updated"); 
		getDetailUserInfoRepository(user_id);
		return lstProfileUser;
	}
	
	//Get information email and password
	@Override
	public List<ProfileUserDTO> getCurrentPasswordRepository(final int user_id) {
		jdbcTemplate = new JdbcTemplate(dataSource);
		lstProfileUser = jdbcTemplate.query(SQL_READ_PASSWORD, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement prepared) throws SQLException {
				prepared.setInt(1, user_id);
			}
		}, new RowMapper<ProfileUserDTO>() {
			@Override
			public ProfileUserDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
				ProfileUserDTO profileUserData = new ProfileUserDTO();
				profileUserData.setUser_id(rs.getString("user_id"));
				profileUserData.setUser_email(rs.getString("user_email"));
				return profileUserData;
			}
		});
		return lstProfileUser;
	}
	
	//Check correct email and password
	@Override
	public boolean isValidAuth(final int user_id, final ProfileUserDTO profileUser) {
		jdbcTemplate = new JdbcTemplate(dataSource);
		boolean isGetData = jdbcTemplate.query(SQL_VALID_AUTH, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement prepared) throws SQLException {
				prepared.setString(1, profileUser.getUser_email());
				prepared.setString(2, profileUser.getUser_password());
				prepared.setInt(3, user_id);
			}
		}, new ResultSetExtractor<Boolean>() {
			@Override
			public Boolean extractData(ResultSet rs) throws SQLException, DataAccessException {
				boolean result = rs.next();
				return result;
			}
		});
		return isGetData;
	}

	//Update Password and Email
	@Override
	public List<ProfileUserDTO> modifiedCurrentPasswordRepository(int user_id, ProfileUserDTO profileUser) {
		jdbcTemplate = new JdbcTemplate(dataSource);
		int isUpdated = jdbcTemplate.update(SQL_MODIFIED_AUTH_EMAIL, new Object[] { 
																					profileUser.getUser_email(),
																					profileUser.getUser_password(),
																					user_id
																				});
		if(isUpdated <= 0) System.out.println("No updated");
		getCurrentPasswordRepository(user_id);
		return lstProfileUser;
	}

	// Update Photo
	@Override
	public List<ProfileUserDTO> modifiedPhotoRepository(int user_id, String photo) {
		jdbcTemplate = new JdbcTemplate(dataSource);
		int isUpdated = jdbcTemplate.update(SQL_MODIFED_IMAGE, new Object[] {
																		photo,
																		user_id
																		
																		});
		if(isUpdated <= 0) System.out.println("No updated");
		getPhotoInfo(user_id);
		return lstProfileUser;
	}
	
	// Get photo info
	public List<ProfileUserDTO> getPhotoInfo(final int user_id){
		final String sql = "SELECT user_id, user_photo FROM tbl_user WHERE user_id = ?";
		jdbcTemplate = new JdbcTemplate(dataSource);
		lstProfileUser = jdbcTemplate.query(sql, new PreparedStatementSetter() {			
			@Override
			public void setValues(PreparedStatement prepared) throws SQLException {
				prepared.setInt(1, user_id);
			}
		}, new RowMapper<ProfileUserDTO>() {
			@Override
			public ProfileUserDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
				ProfileUserDTO profileUserData = new ProfileUserDTO();
				profileUserData.setUser_id(rs.getString("user_id"));
				profileUserData.setUser_photo(rs.getString("user_photo"));
				return profileUserData;
			}
		});
		return lstProfileUser;
	}
}
