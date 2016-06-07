package com.askhmer.services;

import java.util.List;

import com.askhmer.model.dto.ChatHistoryDto;
import com.askhmer.model.dto.DelChatMsgDto;

public interface ChatHistoryService {
	
	
	/***
	 * 
	 * @return
	 */
	 public List<ChatHistoryDto> listChatRoom(int user_id);
	 
	 /**
	  * 
	  * @param user_id
	  * @param chatToUserId
	  * @return
	  */
	 public int checkChatRoom(int user_id,int chatToUserId);
	 
	 
	 /***
	  * 
	  * @param chatHistoryDto
	  * @return
	  */
	 public boolean addDelChatMsg(DelChatMsgDto delChatMsgDto);

}
