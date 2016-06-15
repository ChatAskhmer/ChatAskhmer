package com.askhmer.model.repositoriesImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.askhmer.model.dto.UserDto;
import com.askhmer.model.repositories.UserDao;
import com.mysql.jdbc.Statement;

/***
 * 
 * @author soklundy
 *
 */
@Repository
public class UserDaoImpl implements UserDao{
	
	@Autowired
	private DataSource dataSource;
	Connection cnn;

	@Override
	public int register(UserDto userDto) {
		final String SQLINSERTUSER = "INSERT INTO tbl_user"
				+ "(user_name,gender,user_no,user_photo,user_email,user_password,user_hometown,"
				+ "user_current_city,user_phone_num,facebook_id,user_access_token)"
				+ "values(?,?,?,?,?,?,?,?,?,?,?);";
		
		try (Connection cnn = dataSource.getConnection(); PreparedStatement ps = cnn.prepareStatement(SQLINSERTUSER,Statement.RETURN_GENERATED_KEYS);) {
			ps.setString(1, userDto.getUserName());
			ps.setString(2, userDto.getGender());
			ps.setString(3, userDto.getUserNo());
			ps.setString(4, userDto.getUserPhoto());
			ps.setString(5, userDto.getUserEmail());
			ps.setString(6, userDto.getUserPassword());
			ps.setString(7, userDto.getUserHometown());
			ps.setString(8, userDto.getUserCurrentCity());
			ps.setString(9, userDto.getUserPhoneNum());
			ps.setString(10, userDto.getFacebookId());
			ps.setString(11, userDto.getUserAccessToken());
			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return 0;
	}

	@Override
	public int checkHasUser(String facebookIdOrPhone) {
		final String SQLCHECKUSER = "select user_id from tbl_user where user_phone_num = ? or facebook_id = ?"; 
		try (Connection cnn = dataSource.getConnection(); PreparedStatement ps = cnn.prepareStatement(SQLCHECKUSER);) {
			ps.setString(1, facebookIdOrPhone);
			ps.setString(2, facebookIdOrPhone);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return rs.getInt("user_id");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return 0;
	}
	
	@Override
	public boolean updateUser(UserDto userDto) {
		
		final String SQLUPDATEUSER = "UPDATE tbl_user SET user_name = ?,user_no =?, user_photo = ?, user_email = ?,user_current_city =?,user_phone_num =? ,user_hometown = ?  WHERE user_id = ?";
		try (Connection cnn = dataSource.getConnection(); PreparedStatement ps = cnn.prepareStatement(SQLUPDATEUSER);) {
			ps.setString(1, userDto.getUserName());
//			ps.setString(2, userDto.getGender());
			ps.setString(2, userDto.getUserNo());
			ps.setString(3, userDto.getUserPhoto());
			ps.setString(4, userDto.getUserEmail());
//			ps.setString(6, userDto.getUserPassword());
			ps.setString(5, userDto.getUserCurrentCity());
			ps.setString(6, userDto.getUserPhoneNum());
			ps.setString(7, userDto.getUserHometown());
//			ps.setString(10, userDto.getFacebookId());
//			ps.setString(11, userDto.getUserAccessToken());
			ps.setInt(8, userDto.getUserId());
			if (ps.executeUpdate() > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	
	}

	@Override
	public UserDto viewUserById(int user_id) {
		try {

			cnn = dataSource.getConnection();
			String sql = "SELECT user_id, user_name, gender, user_no, user_photo,user_email,user_hometown,user_current_city,user_phone_num FROM tbl_user WHERE user_id=?";
			PreparedStatement ps = cnn.prepareStatement(sql);
			ps.setInt(1, user_id);
			ResultSet rs = ps.executeQuery();
			UserDto dto = null;
			if (rs.next()) {
				dto = new UserDto();
				dto.setUserId(rs.getInt("user_id"));
				dto.setUserName(rs.getString("user_name"));
				dto.setGender(rs.getString("gender"));
				dto.setUserNo(rs.getString("user_no"));
				dto.setUserPhoto(rs.getString("user_photo"));
				dto.setUserEmail(rs.getString("user_email"));
				dto.setUserHometown(rs.getString("user_hometown"));
				dto.setUserCurrentCity(rs.getString("user_current_city"));
				dto.setUserPhoneNum(rs.getString("user_phone_num"));
				return dto;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				cnn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	

	@Override
	public List<UserDto> searchUserByUserNoOrName(String searchUserNoOrName) {
		final String SQLSEARCHUSERID = "select * from tbl_user where user_id = ? or LCASE(user_name) like LCASE(?)";
		List<UserDto> users = new ArrayList<UserDto>();
		try (Connection cnn = dataSource.getConnection(); PreparedStatement ps = cnn.prepareStatement(SQLSEARCHUSERID);) {
			ps.setString(1, searchUserNoOrName);
			ps.setString(2, "%" + searchUserNoOrName + "%");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				UserDto userDto = new UserDto();
				userDto.setUserId(rs.getInt("user_id"));
				userDto.setUserName(rs.getString("user_name"));
				userDto.setGender(rs.getString("gender"));
				userDto.setUserNo(rs.getString("user_no"));
				userDto.setUserPhoto(rs.getString("user_photo"));
				userDto.setUserEmail(rs.getString("user_email"));
				userDto.setUserPassword(rs.getString("user_password"));
				userDto.setUserHometown(rs.getString("user_hometown"));
				userDto.setUserCurrentCity(rs.getString("user_current_city"));
				userDto.setUserPhoneNum(rs.getString("user_phone_num"));
				userDto.setFacebookId(rs.getString("facebook_id"));
				userDto.setUserAccessToken(rs.getString("user_access_token"));
				users.add(userDto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}

}
