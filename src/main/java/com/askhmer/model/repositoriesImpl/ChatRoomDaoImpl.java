package com.askhmer.model.repositoriesImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.askhmer.model.dto.ChatRoom;
import com.askhmer.model.repositories.ChatRoomDao;
import com.mysql.jdbc.Statement;

/**
 * 
 * @author soklundy
 *
 */
@Repository
public class ChatRoomDaoImpl implements ChatRoomDao{

	@Autowired
	private DataSource dataSource;
	
	@Override
	public int addChatRoom(String roomName, String desricption) {
		final String SQLINSERTCHATROOM = "INSERT INTO tbl_chat_room(room_name, description) values(?,?);";
		
		try (Connection cnn = dataSource.getConnection(); PreparedStatement ps = cnn.prepareStatement(SQLINSERTCHATROOM,Statement.RETURN_GENERATED_KEYS);) {
			ps.setString(1, roomName);
			ps.setString(2, desricption);
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
}
