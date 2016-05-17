package com.askhmer.model.dto;

public class ChatHistoryDto {
	
	
	private int userId;
	private String userName;
	private String userPhoto;
	private int roomId;
	private String roomName;
	
	
	
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
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
	 * @return the roomId
	 */
	public int getRoomId() {
		return roomId;
	}
	/**
	 * @param roomId the roomId to set
	 */
	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}
	/**
	 * @return the roomName
	 */
	public String getRoomName() {
		return roomName;
	}
	/**
	 * @param roomName the roomName to set
	 */
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	/**
	 * @param userId
	 * @param userName
	 * @param userPhoto
	 * @param roomId
	 * @param roomName
	 */
	public ChatHistoryDto(int userId, String userName, String userPhoto, int roomId, String roomName) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPhoto = userPhoto;
		this.roomId = roomId;
		this.roomName = roomName;
	}
	/**
	 * 
	 */
	public ChatHistoryDto() {
		super();
	}
	
	
	
	
	
	
	

}
