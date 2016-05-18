package com.askhmer.model.dto;

import java.util.Date;

/**
 * 
 * @author soklundy
 *
 */
public class ChatMemberDto {
	
	private int memId;
	private int roomId;
	private int userId;
	private Date memDate;
	private Date memTime;
	
	/**
	 * @return the memId
	 */
	public int getMemId() {
		return memId;
	}
	
	/**
	 * @param memId the memId to set
	 */
	public void setMemId(int memId) {
		this.memId = memId;
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
	 * @return the memDate
	 */
	public Date getMemDate() {
		return memDate;
	}
	
	/**
	 * @param memDate the memDate to set
	 */
	public void setMemDate(Date memDate) {
		this.memDate = memDate;
	}
	
	/**
	 * @return the memTime
	 */
	public Date getMemTime() {
		return memTime;
	}
	
	/**
	 * @param memTime the memTime to set
	 */
	public void setMemTime(Date memTime) {
		this.memTime = memTime;
	}
}
