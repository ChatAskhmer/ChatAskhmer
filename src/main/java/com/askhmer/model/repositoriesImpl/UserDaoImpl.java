package com.askhmer.model.repositoriesImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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

}
