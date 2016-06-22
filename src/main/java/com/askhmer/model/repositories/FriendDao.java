package com.askhmer.model.repositories;

import java.util.ArrayList;
import java.util.List;

import com.askhmer.model.dto.FriendDto;
import com.askhmer.model.dto.UserDto;

/***
 * 
 * @author soklundy
 *
 */
public interface FriendDao {

	/***
	 * 
	 * @return
	 */
	public List<Integer> listFriendIdById(int user_id);
	
	
	
	/***
	 * 
	 * @param user_id
	 * @return
	 */
	public List<UserDto> listFriendById(int user_id);
	
	
	/***
	 * 
	 * @param id
	 * @return 
	 */
	public UserDto viewfriendById(int user_id);
	
	/***
	 * 
	 * @param friendDto
	 * @return
	 */
	public boolean addFriend(FriendDto friendDto);
	
	/**
	 * 
	 * @param friendDto
	 * @return
	 */
	public boolean unFriend(FriendDto friendDto);
	
	
	/**
	 * search fri
	 */
	public ArrayList<UserDto> searchFriend(String kesearch,int user_id);
}
