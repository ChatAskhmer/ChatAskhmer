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

import com.askhmer.model.dto.ChatHistoryDto;
import com.askhmer.model.repositories.ChatHistoryDao;

@Repository
public class ChatHistoryDaoimpl implements ChatHistoryDao {
	
	
	
	@Autowired
	private DataSource dataSource;
	Connection cnn;
	
	

	@Override
	public List<ChatHistoryDto> listChatRoom() {
		List<ChatHistoryDto> friend = new ArrayList<ChatHistoryDto>();
		ChatHistoryDto dto = null;
		ResultSet rs = null;
		System.err.println("error");
		try{
			String sql = "SELECT DISTINCT r.room_id,r.room_name FROM tbl_user u INNER JOIN tbl_chat_member m ON m.user_id = u.user_id INNER JOIN tbl_chat_room r ON r.room_id = m.room_id ";
			cnn = dataSource.getConnection();
			PreparedStatement ps = cnn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				dto = new ChatHistoryDto();
				dto.setRoomId(rs.getInt("room_id"));
				dto.setRoomName(rs.getString("room_name"));
				friend.add(dto);
			}
			return friend;
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


}
