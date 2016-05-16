package com.askhmer.model.repositoriesImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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


	@Override
	public List<MessageDto> listMessage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addMessage(MessageDto messageDto) {
		final String SQLADDFRIEND = "INSERT INTO tbl_chat_msg(room_id, user_id, message) VALUES(?,?,?)"; 
		try (Connection cnn = dataSource.getConnection(); PreparedStatement ps = cnn.prepareStatement(SQLADDFRIEND);) {
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


}
