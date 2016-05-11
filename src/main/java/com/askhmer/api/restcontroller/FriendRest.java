package com.askhmer.api.restcontroller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.askhmer.model.dto.FriendDto;
import com.askhmer.services.FriendService;

/***
 * 
 * @author soklundy
 *
 */

@RestController
@RequestMapping(value="/api/friend")
public class FriendRest {
	
	@Autowired
	private FriendService friend;
	
	@RequestMapping(value="/add", method= RequestMethod.POST, headers="Accept=application/json")
	public ResponseEntity<Map<String,Object>> addUser(@RequestBody FriendDto friendDto){
		Map<String, Object> map  = new HashMap<String, Object>();
		try {
			if(friend.addFriend(friendDto)==true){
				map.put("MESSAGE","ADD FRIEND HAS BEEN REQUESTED.");
				map.put("STATUS", HttpStatus.OK.value());
			}else{
				map.put("MESSAGE","ADD FRIEND HAS BEEN FAILS.");
				map.put("STATUS", HttpStatus.NOT_FOUND.value());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
	}
	
}
