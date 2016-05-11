package com.askhmer.model.dto;

import org.joda.time.DateTime;

public class UserDto {
	
	private int userId;
	private String userName;
	private String gender;
	private String userNo;
	private String userPhoto;
	private String userEmail;
	private String userPassword;
	private String userHometown;
	private String userCurrentCity;
	private String userPhoneNum;
	private String userAccessToken;
	private DateTime userRigisDate;
	private boolean status;
	
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
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}
	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}
	/**
	 * @return the userNo
	 */
	public String getUserNo() {
		return userNo;
	}
	/**
	 * @param userNo the userNo to set
	 */
	public void setUserNo(String userNo) {
		this.userNo = userNo;
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
	 * @return the userEmail
	 */
	public String getUserEmail() {
		return userEmail;
	}
	/**
	 * @param userEmail the userEmail to set
	 */
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	/**
	 * @return the userPassword
	 */
	public String getUserPassword() {
		return userPassword;
	}
	/**
	 * @param userPassword the userPassword to set
	 */
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	/**
	 * @return the userHometown
	 */
	public String getUserHometown() {
		return userHometown;
	}
	/**
	 * @param userHometown the userHometown to set
	 */
	public void setUserHometown(String userHometown) {
		this.userHometown = userHometown;
	}
	/**
	 * @return the userCurrentCity
	 */
	public String getUserCurrentCity() {
		return userCurrentCity;
	}
	/**
	 * @param userCurrentCity the userCurrentCity to set
	 */
	public void setUserCurrentCity(String userCurrentCity) {
		this.userCurrentCity = userCurrentCity;
	}
	/**
	 * @return the userPhoneNum
	 */
	public String getUserPhoneNum() {
		return userPhoneNum;
	}
	/**
	 * @param userPhoneNum the userPhoneNum to set
	 */
	public void setUserPhoneNum(String userPhoneNum) {
		this.userPhoneNum = userPhoneNum;
	}
	/**
	 * @return the userAccessToken
	 */
	public String getUserAccessToken() {
		return userAccessToken;
	}
	/**
	 * @param userAccessToken the userAccessToken to set
	 */
	public void setUserAccessToken(String userAccessToken) {
		this.userAccessToken = userAccessToken;
	}
	/**
	 * @return the userRigisDate
	 */
	public DateTime getUserRigisDate() {
		return userRigisDate;
	}
	/**
	 * @param userRigisDate the userRigisDate to set
	 */
	public void setUserRigisDate(DateTime userRigisDate) {
		this.userRigisDate = userRigisDate;
	}
	/**
	 * @return the status
	 */
	public boolean isStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	/**
	 * @param userName
	 * @param gender
	 * @param userNo
	 * @param userPhoto
	 * @param userEmail
	 * @param userPassword
	 * @param userHometown
	 * @param userCurrentCity
	 * @param userPhoneNum
	 * @param userAccessToken
	 * @param userRigisDate
	 * @param status
	 */
	public UserDto(String userName, String gender, String userNo, String userPhoto, String userEmail,
			String userPassword, String userHometown, String userCurrentCity, String userPhoneNum,
			String userAccessToken, DateTime userRigisDate, boolean status) {
		this.userName = userName;
		this.gender = gender;
		this.userNo = userNo;
		this.userPhoto = userPhoto;
		this.userEmail = userEmail;
		this.userPassword = userPassword;
		this.userHometown = userHometown;
		this.userCurrentCity = userCurrentCity;
		this.userPhoneNum = userPhoneNum;
		this.userAccessToken = userAccessToken;
		this.userRigisDate = userRigisDate;
		this.status = status;
	}
	/**
	 * 
	 */
	public UserDto() {
		
	}
	
}
