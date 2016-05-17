package com.askhmer.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.askhmer.model.dto.MessageDto;
import com.askhmer.model.repositories.MessageDao;
import com.askhmer.services.MessageService;



@Service
public class MessageServiceImpl implements MessageService{

	@Autowired
	private MessageDao messageDao;
	

	@Override
	public boolean addMessage(MessageDto messageDto) {
		// TODO Auto-generated method stub
		return messageDao.addMessage(messageDto);
	}

	@Override
	public List<MessageDto> listMessageByRoomId(int room_id, int user_id) {
		// TODO Auto-generated method stub
		return messageDao.listMessageByRoomId(room_id, user_id);
	}

	@Override
	public boolean deleteMessage(int user_id, int msg_id) {
		// TODO Auto-generated method stub
		return messageDao.deleteMessage(user_id, msg_id);
	}

}
