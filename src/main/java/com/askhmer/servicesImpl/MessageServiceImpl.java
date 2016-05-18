package com.askhmer.servicesImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.askhmer.model.dto.MessageDto;
import com.askhmer.model.repositories.ChatHistoryDao;
import com.askhmer.model.repositories.ChatMemberDao;
import com.askhmer.model.repositories.ChatRoomDao;
import com.askhmer.model.repositories.MessageDao;
import com.askhmer.services.MessageService;



@Service
public class MessageServiceImpl implements MessageService{

	@Autowired
	private MessageDao messageDao;
	
	@Autowired
	private ChatHistoryDao chatHistoryDao;
	
	@Autowired
	private ChatMemberDao chatMemberDao;
	
	@Autowired
	private ChatRoomDao chatRoomDao;
	
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
	public List<MessageDto> checkHistoryChat(int appUserId, int chatToId) {
		int roomId = chatHistoryDao.checkChatRoom(appUserId, chatToId);
		if(roomId > 0) {
			return messageDao.listMessageByRoomId(roomId, appUserId);
		}
		return new ArrayList<MessageDto>();	
	}

	@Override
	public boolean deleteMessage(int user_id, int msg_id) {
		// TODO Auto-generated method stub
		return messageDao.deleteMessage(user_id, msg_id);
	}

	@Override
	public boolean addFirstMsgPersonalChat(int userId, int chatToUserId, String message) {
		int[] userIdArr = {userId,chatToUserId};
	
		int returnRoomId = chatRoomDao.addChatRoom("", "personal chat");
		
		if(returnRoomId > 0) {
			for (int i : userIdArr) {
				chatMemberDao.addChatMember(returnRoomId, i);
			}
		}
		return messageDao.addMessage(new MessageDto(returnRoomId, userId, message));
	}
}
