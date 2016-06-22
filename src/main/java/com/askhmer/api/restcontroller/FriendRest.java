package com.askhmer.api.restcontroller;


import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.askhmer.model.dto.FriendDto;
import com.askhmer.model.dto.UserDto;
import com.askhmer.model.repositories.FriendDao;
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
	
	@Autowired
	FriendDao friendDao;
	
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
	
	@RequestMapping(value="/unfriend", method= RequestMethod.POST, headers="Accept=application/json")
	public ResponseEntity<Map<String,Object>> unFriend(@RequestBody FriendDto friendDto){
		Map<String, Object> map  = new HashMap<String, Object>();
		try {
			if(friend.unFriend(friendDto)==true){
				map.put("MESSAGE","UNFRIEND HAS BEEN REQUESTED.");
				map.put("STATUS", HttpStatus.OK.value());
			}else{
				map.put("MESSAGE","UNFRIEND HAS BEEN FAILS.");
				map.put("STATUS", HttpStatus.NOT_FOUND.value());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
	}
	
	@RequestMapping(value="listfriendById/{user_id}", method = RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> listFriendById(@PathVariable("user_id") int user_id){
		Map<String, Object> map = new HashMap<String, Object>();
		List<UserDto> lst = friend.listFriendById(user_id);
		if ( !lst.isEmpty() ) {
			map.put("STATUS", HttpStatus.FOUND.value());
			map.put("MESSAGE", "FRIEND LIST FOUND!" );
			map.put("DATA", lst);
			return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
		}
		map.put("STATUS", HttpStatus.NOT_FOUND.value());
		map.put("MESSAGE", "FRIEND LIST NOT FOUND!" );
		map.put("DATA", lst);
		return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
	}
	


	@RequestMapping(value="listfriendidbyid/{user_id}", method = RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> listFriendIdById(@PathVariable("user_id") int user_id){
		List<Integer> lst =  friend.listFriendIdById(user_id);
		Map<String, Object> map = new HashMap<String,Object>();
		if ( lst != null) {
			map.put("STATUS", HttpStatus.FOUND.value());
			map.put("MESSAGE", "FRIEND LIST ID FOUND!" );
			map.put("DATA", lst);
			return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
		}
		map.put("STATUS", HttpStatus.NOT_FOUND.value());
		map.put("MESSAGE", "FRIEND LIST ID NOT FOUND!");
		map.put("DATA", "");
		return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
	}
	
	
	

	
	@RequestMapping(value="viewfriendById/{user_id}", method = RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> viewFriendById(@PathVariable("user_id") int user_id){
		UserDto friendDTO = friend.viewfriendById(user_id);
		Map<String, Object> map = new HashMap<String,Object>();
		if ( friendDTO != null) {
			map.put("STATUS", HttpStatus.FOUND.value());
			map.put("MESSAGE", "FRIEND ID "+user_id+" FOUND!");
			map.put("DATA", friendDTO);
			return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
		}
		map.put("STATUS", HttpStatus.NOT_FOUND.value());
		map.put("MESSAGE", "FRIEND ID "+user_id+" NOT FOUND!");
		map.put("DATA", "");
		return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
	}
	
	
	
	/*
	 * search Friend
	 * we want to search the course in friend
	 */
	@RequestMapping(value="/searchfriend/{searchkey}/{user_id}", method= RequestMethod.GET, headers= "Accept=application/json")
	public ResponseEntity<Map<String, Object>> searchFriend(@PathVariable("searchkey") String key,
			          @PathVariable("user_id") int user_id
			 
//					,@RequestParam(value ="page", required = false, defaultValue = "1") int page,
//					@RequestParam(value ="item" , required = false , defaultValue = "10") int item
			){
		Map<String, Object> map= new HashMap<String, Object>();
		try{
//			Pagination pagin = new Pagination();
//			pagin.setItem(item);
//			pagin.setPage(page);
//			pagin.setTotalCount(playlistservice.countSearchPlayList(key));
//			pagin.setTotalPages(pagin.totalPages());
			
			
//			ArrayList<UserDto> dto= playlistservice.searchPlayList(key, pagin);
			ArrayList<UserDto> dto= friend.searchFriend(key,user_id);
			if(!dto.isEmpty()){
				map.put("STATUS", true);
				map.put("MESSAGE", "RECORD FOUND");
				map.put("RES_DATA", dto);
				//map.put("PAGINATION", pagin);
			}else{
				map.put("STATUS", false);
				map.put("MESSAGE", "RECORD NOT FOUND!");
			}
		}catch(Exception e){
			map.put("STATUS", false);
			map.put("MESSAGE", "ERROR OCCURRING!");
		}
		return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
		
	}
	
	

	
}
