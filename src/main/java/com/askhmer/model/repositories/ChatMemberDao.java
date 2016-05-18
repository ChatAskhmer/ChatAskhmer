package com.askhmer.model.repositories;

/**
 * 
 * @author soklundy
 *
 */
public interface ChatMemberDao {
	
	/**
	 * 
	 * @param roomId
	 * @param UserId
	 * @return
	 */
	public boolean addChatMember(int roomId, int UserId);
}
