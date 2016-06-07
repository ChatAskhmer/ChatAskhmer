package com.askhmer.model.repositories;

import java.util.List;

import com.askhmer.model.dto.UserDto;

/***
 * 
 * @author soklundy
 *
 */
public interface UserDao {
	
	/***
	 * 
	 * @param userDto
	 * @return register success return user id
	 */
	public int register(UserDto userDto);
	
	/**
	 * this function check user is old user or new user, it can check by phone number or facebook id
	 * @param facebookIdOrPhone
	 * @return int; if return 0 equal not exist and if exist return user id
	 */
	public int checkHasUser(String facebookIdOrPhone);
	
	/**
	 * 
	 * @param searchUserNoOrName
	 * @param IdUserUseApp : id user using app 
	 * @return
	 */
	public List<UserDto> searchUserByUserNoOrName(String searchUserNoOrName, String IdUserUseApp);
	
}
