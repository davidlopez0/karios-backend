package com.karios.core.domain.model;

import java.util.Date;

public class Message {

	private Integer messageId;
    private String message;
    private Date messageDate;
    private Integer userId;
    private Integer chatId;
    private User userMessage;
    private Chat chatMessage;

    public Integer getMessageId() {
        return messageId;
    }

    public void setMessageId(Integer messageId) {
        this.messageId = messageId;
    }

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

    public User getUserMessage() {
        return userMessage;
    }

    public void setUserMessage(User userMessage) {
        this.userMessage = userMessage;
    }

    public Chat getChatMessage() {
        return chatMessage;
    }

    public void setChatMessage(Chat chatMessage) {
        this.chatMessage = chatMessage;
    }
	
}
