package com.askhmer.model.repositoriesImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.askhmer.model.dto.ChatMemberDto;
import com.askhmer.model.repositories.ChatMemberDao;
import com.mysql.jdbc.Statement;

/**
 * 
 * @author soklundy
 *
 */
@Repository
public class ChatMemberDaoImpl implements ChatMemberDao{
	
	@Autowired
	private DataSource dataSource;

	@Override
	public boolean addChatMember(int roomId, int UserId) {
		final String SQLINSERTROOMMEMBER = "INSERT INTO tbl_chat_member(room_id, user_id) values(?,?);";

		try (Connection cnn = dataSource.getConnection();
				PreparedStatement ps = cnn.prepareStatement(SQLINSERTROOMMEMBER);) {
			ps.setInt(1, roomId);
			ps.setInt(2, UserId);
			if (ps.executeUpdate() > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}
}
