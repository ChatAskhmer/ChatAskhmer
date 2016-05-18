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
import com.askhmer.model.dto.DelChatMsgDto;
import com.askhmer.model.repositories.ChatHistoryDao;

@Repository
public class ChatHistoryDaoimpl implements ChatHistoryDao {
	
	
	
	@Autowired
	private DataSource dataSource;
	Connection cnn;
	

	@Override
	public List<ChatHistoryDto> listChatRoom(int user_id) {

		List<ChatHistoryDto> friend = new ArrayList<ChatHistoryDto>();
		ChatHistoryDto dto = null;
		ResultSet rs = null;
		System.err.println("error");
		try {
			String sql ="select u.user_id,u.user_name,u.user_photo,r.room_id,r.room_name "
					+"from tbl_user u INNER JOIN tbl_chat_member m "
					+"on u.user_id = m.user_id "
					+"INNER JOIN tbl_chat_room r on m.room_id = r.room_id "
					+"where r.room_id not in (select room_id from tbl_del_chat_msg where user_id = ?) and "
                    +"m.room_id in (select room_id from tbl_chat_member where user_id = ?) and (u.user_id != ?)";
			cnn = dataSource.getConnection();
			PreparedStatement ps = cnn.prepareStatement(sql);
			ps.setInt(1, user_id);
			ps.setInt(2, user_id);
			ps.setInt(3, user_id);
			rs = ps.executeQuery();

			while (rs.next()) {
				dto = new ChatHistoryDto();
				dto.setUserId(rs.getInt("user_id"));
				dto.setUserName(rs.getString("user_name"));
				dto.setUserPhoto(rs.getString("user_photo"));
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
	
	

	
	@Override
	public int checkChatRoom(int user_id,int id) {
		final String SQLCHECKUSER = "select room_id from tbl_chat_member where room_id in (select room_id from tbl_chat_member where user_id = ?) and user_id = ?"; 
		try (Connection cnn = dataSource.getConnection(); PreparedStatement ps = cnn.prepareStatement(SQLCHECKUSER);) {
			ps.setInt(1, user_id);
			ps.setInt(2, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return rs.getInt("room_id");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return 0;
	}




	@Override
	public boolean addDelChatMsg(DelChatMsgDto delChatMsgDto) {
		final String SQLADDFRIEND = "INSERT INTO tbl_del_chat_msg(user_id,room_id) values(?,?)";
		try (Connection cnn = dataSource.getConnection(); PreparedStatement ps = cnn.prepareStatement(SQLADDFRIEND);) {
			ps.setInt(1, delChatMsgDto.getUserId());
			ps.setInt(2, delChatMsgDto.getRoomId());
			if (ps.executeUpdate() > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}
	
}
