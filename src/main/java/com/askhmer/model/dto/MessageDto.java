package com.askhmer.model.dto;

import java.sql.Date;
import java.sql.Time;

public class MessageDto {
	private int msgId;
	private int roomId;
	private int userId;
	private String message;
	private String stickerUrl;
	private Date msgDate;
	private Time msgTime;
	public int getMsgId() {
		return msgId;
	}
	public void setMsgId(int msgId) {
		this.msgId = msgId;
	}
	public int getRoomId() {
		return roomId;
	}
	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getStickerUrl() {
		return stickerUrl;
	}
	public void setStickerUrl(String stickerUrl) {
		this.stickerUrl = stickerUrl;
	}
	public Date getMsgDate() {
		return msgDate;
	}
	public void setMsgDate(Date msgDate) {
		this.msgDate = msgDate;
	}
	public Time getMsgTime() {
		return msgTime;
	}
	public void setMsgTime(Time msgTime) {
		this.msgTime = msgTime;
	}
	
	
	

}
