package com.karios.core.domain.dto;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class MessageDTO {

	private String message;
	private Date messageDate;
	private Integer userId;
	private Integer chatId;
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Date getMessageDate() {
		return messageDate;
	}
	public void setMessageDate(Date messageDate) {
		this.messageDate = messageDate;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getChatId() {
		return chatId;
	}
	public void setChatId(Integer chatId) {
		this.chatId = chatId;
	}
	
	
	
}
