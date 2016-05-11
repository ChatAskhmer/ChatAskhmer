package com.askhmer.services;

import com.askhmer.model.dto.FriendDto;

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

}
