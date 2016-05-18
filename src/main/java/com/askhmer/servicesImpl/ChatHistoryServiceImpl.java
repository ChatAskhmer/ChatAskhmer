package com.askhmer.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.askhmer.model.dto.ChatHistoryDto;
import com.askhmer.model.dto.DelChatMsgDto;
import com.askhmer.model.repositories.ChatHistoryDao;
import com.askhmer.services.ChatHistoryService;

@Repository
public class ChatHistoryServiceImpl implements ChatHistoryService{
	
	
	
	@Autowired
	private ChatHistoryDao chatHistoryDao;
	
	/***
	 * 
	 */
	@Override
	public List<ChatHistoryDto> listChatRoom(int user_id) {
		// TODO Auto-generated method stub
		return chatHistoryDao.listChatRoom(user_id);
	}

	
	@Override
	public int checkChatRoom(int user_id,int id) {
		return chatHistoryDao.checkChatRoom(user_id, id);
	}


	@Override
	public boolean addDelChatMsg(DelChatMsgDto delChatMsgDto) {
		
		return chatHistoryDao.addDelChatMsg(delChatMsgDto);
	}


}
