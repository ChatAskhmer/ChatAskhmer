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

import com.askhmer.model.dto.MessageDto;
import com.askhmer.model.repositories.MessageDao;


@Repository
public class MessageDaoImpl implements MessageDao{
	
	@Autowired
	private DataSource dataSource;
	Connection cnn;

	@Override
	public List<MessageDto> listMessage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addMessage(MessageDto messageDto) {
		final String SQLADDFRIEND = "INSERT INTO tbl_chat_msg(room_id, user_id, message) VALUES(?,?,?)"; 
		try {
			cnn = dataSource.getConnection(); 
			PreparedStatement ps = cnn.prepareStatement(SQLADDFRIEND);
			ps.setInt(1, messageDto.getRoomId());
			ps.setInt(2, messageDto.getUserId());
			ps.setString(3, messageDto.getMessage());
			if (ps.executeUpdate() > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean deleteMessage(MessageDto messageDto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<MessageDto> listMessageByRoomId(int room_id) {
		List<MessageDto> msg = new ArrayList<MessageDto>();
		ResultSet rs = null;
		MessageDto dto = null;
		
		String sql = "SELECT m.msg_id, m.message, m.msg_date, m.msg_time, u.user_id, u.user_name, u.user_photo "
					+"FROM tbl_chat_msg m "
					+"INNER JOIN tbl_user u ON u.user_id = m.user_id "
					+"WHERE m.room_id = ?";
		try {
			cnn = dataSource.getConnection();
			PreparedStatement ps = cnn.prepareStatement(sql);
			ps.setInt(1, room_id);
			
			rs = ps.executeQuery();
			
			while(rs.next()){
				dto = new MessageDto();
				dto.setMsgId(rs.getInt("msg_id"));
				dto.setMessage(rs.getString("message"));
				dto.setMsgDate(rs.getDate("msg_date"));
				dto.setMsgTime(rs.getTime("msg_time"));
				dto.setUserId(rs.getInt("user_id"));
				dto.setUserName(rs.getString("user_name"));
				dto.setUserProfile(rs.getString("user_photo"));
				
				msg.add(dto);
			}
			return msg;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
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
