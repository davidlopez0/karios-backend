package com.karios.core.domain.model;

import java.util.Date;

public class Chat {

	private Integer chatId;
    private Date chatDate;

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
