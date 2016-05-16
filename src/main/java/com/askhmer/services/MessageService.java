package com.askhmer.services;

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
	public List<MessageDto> listMessage();
	
	/***
	 * @param MessageDto
	 * @return boolean
	 */
	public boolean addMessage(MessageDto messageDto);
}
