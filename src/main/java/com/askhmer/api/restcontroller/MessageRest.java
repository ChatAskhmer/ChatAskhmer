package com.askhmer.api.restcontroller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.askhmer.model.dto.MessageDto;
import com.askhmer.model.repositories.MessageDao;
import com.askhmer.services.MessageService;

/***
 * 
 * @author Longdy
 *
 */

@RestController
@RequestMapping(value="/api/message")
public class MessageRest {

	
	@Autowired
	private MessageService messageSvervice;
	
	@Autowired
	private MessageDao messagedao;
	
	@RequestMapping(value="/add", method= RequestMethod.POST, headers="Accept=application/json")
	public ResponseEntity<Map<String, Object>> addMessage(@RequestBody MessageDto messageDto){
		Map<String, Object> map  = new HashMap<String, Object>();
		try {
			if(messageSvervice.addMessage(messageDto)==true){
				map.put("MESSAGE","ADD MESSAGE HAS BEEN REQUESTED.");
				map.put("STATUS", HttpStatus.OK.value());
			}else{
				map.put("MESSAGE","ADD MESSAGE HAS BEEN FAILS.");
				map.put("STATUS", HttpStatus.NOT_FOUND.value());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
	}
	
	@RequestMapping(value="/list_message_by_roomId/{room_id}", method = RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> listMessageByRoomId(@PathVariable("room_id") int room_id){
		List<MessageDto> liMsg = messagedao.listMessageByRoomId(room_id);
		Map<String, Object> map = new HashMap<String, Object>();
		if ( !liMsg.isEmpty() ) {
			map.put("STATUS", HttpStatus.FOUND.value());
			map.put("MESSAGE", "Message LIST FOUND!" );
			map.put("DATA", liMsg);
			return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
		}
		map.put("STATUS", HttpStatus.NOT_FOUND.value());
		map.put("MESSAGE", "Message LIST NOT FOUND!" );
		map.put("DATA", liMsg);
		
		return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
	}
}
