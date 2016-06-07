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
	public List<UserDto> searchUserByUserNoOrName(String searchUserNoOrName, String IdUserUseApp) {
		final String SQLSEARCHUSERID = "select * from tbl_user where user_id = ? or LCASE(user_name) like LCASE(?) and user_id != ?";
		List<UserDto> users = new ArrayList<UserDto>();
		try (Connection cnn = dataSource.getConnection(); PreparedStatement ps = cnn.prepareStatement(SQLSEARCHUSERID);) {
			ps.setString(1, searchUserNoOrName);
			ps.setString(2, "%" + searchUserNoOrName + "%");
			ps.setString(3, IdUserUseApp);
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
