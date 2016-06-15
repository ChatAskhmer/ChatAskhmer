package com.askhmer.servicesImpl;

import com.askhmer.model.dto.FriendDto;
import com.askhmer.model.dto.UserDto;

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

}
