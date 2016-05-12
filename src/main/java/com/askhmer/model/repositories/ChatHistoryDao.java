package com.askhmer.model.repositories;

import java.util.List;

import com.askhmer.model.dto.ChatHistoryDto;
import com.askhmer.model.dto.UserDto;

public interface ChatHistoryDao {
	
	public List<ChatHistoryDto> listChatRoom();

}
