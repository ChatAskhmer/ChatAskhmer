package com.askhmer.api.restcontroller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.askhmer.model.dto.UserDto;
import com.askhmer.services.UserServices;

/**
 * 
 * @author soklundy
 *
 */
@RestController
@RequestMapping(value="/api/user")
public class UserRest {

	@Autowired
	private UserServices user;
	
	@RequestMapping(value="/add", method= RequestMethod.POST, headers="Accept=application/json")
	public ResponseEntity<Map<String,Object>> addUser(@RequestBody UserDto userDto){
		Map<String, Object> map  = new HashMap<String, Object>();
		int result = user.register(userDto);
		try {
			if(result > 0){
				map.put("MESSAGE_USERID",result);
				map.put("MESSAGE","REGISTER USER HAS BEEN REQUESTED.");
				map.put("STATUS", HttpStatus.OK.value());
			}else{
				map.put("MESSAGE","REGISTER USER HAS BEEN FAILS.");
				map.put("STATUS", HttpStatus.NOT_FOUND.value());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
	}
	
	
	@RequestMapping(value="/adduserwithfb", method= RequestMethod.POST, headers="Accept=application/json")
	public ResponseEntity<Map<String,Object>> addUserWithFb(@RequestBody UserDto userDto){
		Map<String, Object> map  = new HashMap<String, Object>();
		int result = user.registerWithFb(userDto);
		try {
			if(result > 0){
				map.put("MESSAGE_USERID",result);
				map.put("MESSAGE","REGISTER USER HAS BEEN REQUESTED.");
				map.put("STATUS", HttpStatus.OK.value());
			}else{
				map.put("MESSAGE","REGISTER USER HAS BEEN FAILS.");
				map.put("STATUS", HttpStatus.NOT_FOUND.value());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
	}
	
	@RequestMapping(value="/checkUser", method= RequestMethod.POST, headers="Accept=application/json")
	public ResponseEntity<Map<String,Object>> checkUser(@RequestParam String valuesSearch){
		Map<String, Object> map  = new HashMap<String, Object>();
		int result = user.checkHasUser(valuesSearch);
		try {
			if(result > 0){
				map.put("MESSAGE_USERID",result);
				map.put("MESSAGE","SEARCH HAS BEEN REQUESTED.");
				map.put("STATUS", HttpStatus.OK.value());
			}else{
				map.put("MESSAGE_USERID",result);
				map.put("MESSAGE","SEARCH HAS BEEN FAILS.");
				map.put("STATUS", HttpStatus.NOT_FOUND.value());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
	}
	
}
