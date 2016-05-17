package com.askhmer.services;

import java.util.List;

import com.askhmer.model.dto.ChatHistoryDto;

public interface ChatHistoryService {
	
	
	/***
	 * 
	 * @return
	 */
	 public List<ChatHistoryDto> listChatRoom(int user_id);
	 
	 /***
	  * 
	  * @param user_id
	  * @return
	  */
	 public int checkChatRoom(int user_id,int id);

}
