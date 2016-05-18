package com.askhmer.model.dto;

import java.util.Date;

/**
 * 
 * @author soklundy
 *
 */
public class ChatRoom {
	
	private int roomId;
	private String roomName;
	private Date chatRoomDate;
	private Date chatRoomTime;
	private String desricption;
	private int counterMemeber;
	
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
	 * @return the chatRoomDate
	 */
	public Date getChatRoomDate() {
		return chatRoomDate;
	}
	
	/**
	 * @param chatRoomDate the chatRoomDate to set
	 */
	public void setChatRoomDate(Date chatRoomDate) {
		this.chatRoomDate = chatRoomDate;
	}
	
	/**
	 * @return the chatRoomTime
	 */
	public Date getChatRoomTime() {
		return chatRoomTime;
	}
	
	/**
	 * @param chatRoomTime the chatRoomTime to set
	 */
	public void setChatRoomTime(Date chatRoomTime) {
		this.chatRoomTime = chatRoomTime;
	}
	
	/**
	 * @return the desricption
	 */
	public String getDesricption() {
		return desricption;
	}
	
	/**
	 * @param desricption the desricption to set
	 */
	public void setDesricption(String desricption) {
		this.desricption = desricption;
	}
	
	/**
	 * @return the counterMemeber
	 */
	public int getCounterMemeber() {
		return counterMemeber;
	}
	
	/**
	 * @param counterMemeber the counterMemeber to set
	 */
	public void setCounterMemeber(int counterMemeber) {
		this.counterMemeber = counterMemeber;
	}
}
