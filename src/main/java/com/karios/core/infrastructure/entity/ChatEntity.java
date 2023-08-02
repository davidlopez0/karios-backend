package com.karios.core.infrastructure.entity;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "chats")
public class ChatEntity {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "chat_id")
    private Integer chatId;
    @Column(name = "chat_date")
    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date chatDate;

    @OneToMany(mappedBy = "chat")
    List<UserChatEntity> userChat;

    @OneToMany(mappedBy = "chatMessage")
    List<MessageEntity> messages;

    public Integer getChatId() {
        return chatId;
    }

    public void setChatId(Integer chatId) {
        this.chatId = chatId;
    }

    public Date getChatDate() {
        return chatDate;
    }

    public void setChatDate(Date chatDate) {
        this.chatDate = chatDate;
    }

}
