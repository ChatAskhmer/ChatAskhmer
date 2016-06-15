package com.askhmer.servicesImpl;

import java.util.List;

import com.askhmer.model.dto.MessageDto;

/***
 * 
 * @author Longdy
 *
 */
public interface MessageService {

	/***
	 * @return List
	 */
	public boolean deleteMessage(int user_id, int msg_id);
	
	/***
	 * @param MessageDto
	 * @return boolean
	 */
	public boolean addMessage(MessageDto messageDto);
	
	/***
	 * 
	 * @param room_id
	 * @return List
	 */
	public List<MessageDto> listMessageByRoomId(int room_id, int user_id);
	
	/**
	 * 
	 * @return
	 */
	public List<MessageDto> checkHistoryChat(int appUserId, int chatToId);
	
	/**
	 * method use when chat personal first time 
	 * @param userId
	 * @param chatToUserId
	 * @param message
	 * @return
	 */
	public boolean addFirstMsgPersonalChat(int userId, int chatToUserId, String message);
	
	/**
	 * 
	 * @param roomName
	 * @param userId
	 * @return
	 */
	public int createGroupChat(String roomName, List<Integer> userId);
}
