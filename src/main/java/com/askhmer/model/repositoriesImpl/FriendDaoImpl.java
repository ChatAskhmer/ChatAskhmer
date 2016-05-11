package com.askhmer.model.repositoriesImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.askhmer.model.dto.FriendDto;
import com.askhmer.model.repositories.FriendDao;

@Repository
public class FriendDaoImpl implements FriendDao{

	@Autowired
	private DataSource dataSource;
	
	public List<FriendDto> listFriend() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean addFriend(FriendDto friendDto) {
		final String SQLADDFRIEND = "INSERT INTO tbl_friend(friend_id,user_id) values(?,?)"; 
		try (Connection cnn = dataSource.getConnection(); PreparedStatement ps = cnn.prepareStatement(SQLADDFRIEND);) {
			ps.setInt(1, friendDto.getFriendId());
			ps.setInt(2, friendDto.getUserId());
			if (ps.executeUpdate() > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

}
