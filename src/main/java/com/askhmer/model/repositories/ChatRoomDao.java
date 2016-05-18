package com.askhmer.model.repositories;

/**
 * 
 * @author soklundy
 *
 */
public interface ChatRoomDao {
	
	/**
	 * 
	 * @param roomName
	 * @param desricption
	 * @return
	 */
	public int addChatRoom(String roomName, String desricption);

}
