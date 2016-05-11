package com.askhmer.model.repositories;

import java.util.List;

import com.askhmer.model.dto.FriendDto;

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
	public List<FriendDto> listFriend();
	
	/***
	 * 
	 * @param friendDto
	 * @return
	 */
	public boolean addFriend(FriendDto friendDto);
}
