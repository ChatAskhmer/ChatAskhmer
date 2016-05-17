package com.askhmer.model.repositories;

import java.util.List;

import com.askhmer.model.dto.MessageDto;

/***
 * 
 * @author Longdy
 *
 */
public interface MessageDao {
	/***
	 * 
	 * @return List
	 */
	public List<MessageDto> listMessage();
	
	/***
	 * 
	 * @return boolean
	 */
	public boolean addMessage(MessageDto messageDto);
	
	/***
	 * 
	 * @return boolean
	 */
	public boolean deleteMessage(MessageDto messageDto);
	
	/***
	 * 
	 * @param room_id
	 * @return list
	 */
	public List<MessageDto> listMessageByRoomId(int room_id, int user_id);
}
