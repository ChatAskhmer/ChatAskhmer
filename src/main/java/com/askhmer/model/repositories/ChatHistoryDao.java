package com.askhmer.model.repositories;

import java.util.List;

import com.askhmer.model.dto.ChatHistoryDto;
import com.askhmer.model.dto.DelChatMsgDto;
import com.askhmer.model.dto.FriendDto;
import com.askhmer.model.dto.UserDto;

public interface ChatHistoryDao {
	

	/***
	 * 
	 * @return listchatroom
	 */
	public List<ChatHistoryDto> listChatRoom(int user_id);
	
	/***
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
