package com.askhmer.services;

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
	
}
