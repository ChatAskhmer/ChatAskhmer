package com.askhmer.model.dto;

public class ChatHistoryDto {
	
	
	private int userId;
	private int roomId;
	private String roomName;
	
	
	
	
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
	 * @param roomId
	 * @param roomName
	 */
	public ChatHistoryDto(int userId, int roomId, String roomName) {
		super();
		this.userId = userId;
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
