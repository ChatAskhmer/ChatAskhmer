package com.askhmer.model.dto;

public class Friend {
	
	private int id;
	private int friendId;
	private int userId;
	private boolean isFriend;
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * @return the friendId
	 */
	public int getFriendId() {
		return friendId;
	}
	
	/**
	 * @param friendId the friendId to set
	 */
	public void setFriendId(int friendId) {
		this.friendId = friendId;
	}
	
	/**
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}
	
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	/**
	 * @return the isFriend
	 */
	public boolean isFriend() {
		return isFriend;
	}
	
	/**
	 * @param isFriend the isFriend to set
	 */
	public void setFriend(boolean isFriend) {
		this.isFriend = isFriend;
	}
	
	/***
	 * 
	 * @param friendId
	 * @param userId
	 * @param isFriend
	 */
	public Friend(int friendId, int userId, boolean isFriend) {
		this.friendId = friendId;
		this.userId = userId;
		this.isFriend = isFriend;
	}
	
	/***
	 * Dafult Constructor
	 */
	public Friend(){
		
	}
	
}
