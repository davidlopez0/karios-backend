package com.karios.core.domain.model;

public class UserChat {

	private Integer userChatId;
    private Integer chatId;
    private Integer userId;
    private Chat chat;
    private User userChat;

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

    public Chat getChat() {
        return chat;
    }

    public void setChat(Chat chat) {
        this.chat = chat;
    }

    public User getUserChat() {
        return userChat;
    }

    public void setUserChat(User userChat) {
        this.userChat = userChat;
    }
	
}
