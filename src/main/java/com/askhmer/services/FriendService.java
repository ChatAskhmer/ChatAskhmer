package com.askhmer.services;

import com.askhmer.model.dto.FriendDto;
import com.askhmer.model.dto.UserDto;

import java.util.ArrayList;
import java.util.List;



/***
 * 
 * @author soklundy
 *
 */
public interface FriendService {
	
	/***
	 * 
	 * @param friendDto
	 * @return
	 */
	public boolean addFriend(FriendDto friendDto);
	
	/***
	 * 
	 * @return list friend
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
     * @return friend by id
     */
	public UserDto viewfriendById(int user_id);
	
	/**
	 * 
	 * @param friendDto
	 * @return
	 */
	public boolean unFriend(FriendDto friendDto);
	
	/**
	 * search fri
	 */

	//public ArrayList<Playlist> searchPlayList(String kesearch, Pagination pagin);
	
	public ArrayList<UserDto> searchFriend(String kesearch, int user_id);
}
