package com.karios.core.infrastructure.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "messages")
public class MessageEntity {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "message_id")
    private Integer messageId;
    private String message;
    @Column(name = "message_date")
    private Date messageDate;
    @Column(name = "user_id")
    private Integer userId;
    @Column(name = "chat_id")
    private Integer chatId;

    @ManyToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private UserEntity userMessage;

    @ManyToOne
    @JoinColumn(name = "chat_id", insertable = false, updatable = false)
    private ChatEntity chatMessage;

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

    public UserEntity getUserMessage() {
        return userMessage;
    }

    public void setUserMessage(UserEntity userMessage) {
        this.userMessage = userMessage;
    }

    public ChatEntity getChatMessage() {
        return chatMessage;
    }

    public void setChatMessage(ChatEntity chatMessage) {
        this.chatMessage = chatMessage;
    }
	
}
