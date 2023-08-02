package com.karios.core.infrastructure.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "users_chats")
public class UserChatEntity {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_chat_id")
    private Integer userChatId;
    @Column(name = "chat_id")
    private Integer chatId;
    @Column(name = "user_id")
    private Integer userId;

    @ManyToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private UserEntity userChat;

    @ManyToOne
    @JoinColumn(name = "chat_id", insertable = false, updatable = false)
    private ChatEntity chat;

    public Integer getUserChatId() {
        return userChatId;
    }

    public void setUserChatId(Integer userChatId) {
        this.userChatId = userChatId;
    }

    public Integer getChatId() {
        return chatId;
    }

    public void setChatId(Integer chatId) {
        this.chatId = chatId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public ChatEntity getChat() {
        return chat;
    }

    public void setChat(ChatEntity chat) {
        this.chat = chat;
    }

    public UserEntity getUserChat() {
        return userChat;
    }

    public void setUserChat(UserEntity userChat) {
        this.userChat = userChat;
    }
	
}
