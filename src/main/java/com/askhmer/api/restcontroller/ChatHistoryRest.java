package com.askhmer.api.restcontroller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.askhmer.model.dto.ChatHistoryDto;
import com.askhmer.model.repositories.ChatHistoryDao;
import com.askhmer.servicesImpl.ChatHistoryServiceImpl;

@RestController
@RequestMapping(value="/api/chathistory")
public class ChatHistoryRest {
	
	
	
	@Autowired
	private ChatHistoryServiceImpl chatHistoryServiceImpl;
	
	
	@Autowired
	private ChatHistoryDao chatHistoryDao;
	
	
	@RequestMapping(value="/listchatroom", method = RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> listchatroom(){
		Map<String, Object> map = new HashMap<String, Object>();
		List<ChatHistoryDto> lst = chatHistoryServiceImpl.listChatRoom();
		if ( !lst.isEmpty() ) {
			map.put("STATUS", HttpStatus.FOUND.value());
			map.put("MESSAGE", "CHAT ROOM LIST FOUND!" );
			map.put("DATA", lst);
			return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
		}
		map.put("STATUS", HttpStatus.NOT_FOUND.value());
		map.put("MESSAGE", "CHAT ROOM LIST NOT FOUND!" );
		map.put("DATA", lst);
		return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
	}

}
