package com.askhmer.model.dto;

public class FriendDto {
	
	private int id;
	private int friendId;
	private int userId;
	private boolean isFriend;
	private String userPhoto;
	
	

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
	
	/**
	 * @return the userPhoto
	 */
	public String getUserPhoto() {
		return userPhoto;
	}

	/**
	 * @param userPhoto the userPhoto to set
	 */
	public void setUserPhoto(String userPhoto) {
		this.userPhoto = userPhoto;
	}

	/**
	 * @param id
	 * @param friendId
	 * @param userId
	 * @param isFriend
	 * @param userPhoto
	 */
	public FriendDto(int id, int friendId, int userId, boolean isFriend, String userPhoto) {
		super();
		this.id = id;
		this.friendId = friendId;
		this.userId = userId;
		this.isFriend = isFriend;
		this.userPhoto = userPhoto;
	}

	/**
	 * 
	 */
	public FriendDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
