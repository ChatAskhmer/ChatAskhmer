package com.askhmer.services;

import java.util.List;

import com.askhmer.model.dto.UserDto;

/**
 * 
 * @author soklundy
 *
 */
public interface UserServices {
	
	/**
	 * 
	 * @param userDto
	 * @return
	 */
	public int register(UserDto userDto);
	
	/**
	 * 
	 * @param facebookIdOrPhone
	 * @return user id 
	 */
	public int checkHasUser(String facebookIdOrPhone);
	
	

	/***
	 * 
	 * @param userDto
	 * @return
	 */
	public boolean updateUser(UserDto userDto);
	
	
	/***
	 * 
	 * @param user_id
	 * @return
	 */
	public UserDto viewUserById(int user_id);
	
	
	/**
	 * 
	 * @param userDto
	 * @return
	 */
	public int registerWithFb(UserDto userDto);
	
	/**
	 * 
	 * @param searchUserNoOrName
	 * @return
	 */
	public List<UserDto> searchUserByUserNoOrName(String searchUserNoOrName, int userID);
	
}
