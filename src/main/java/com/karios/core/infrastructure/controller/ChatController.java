package com.karios.core.infrastructure.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.karios.core.application.service.ChatService;
import com.karios.core.application.service.MessageService;
import com.karios.core.application.service.UserChatService;
import com.karios.core.domain.dto.MessageDTO;
import com.karios.core.domain.model.Chat;
import com.karios.core.domain.model.Message;
import com.karios.core.infrastructure.entity.ChatEntity;
import com.karios.core.infrastructure.entity.MessageEntity;
import com.karios.core.infrastructure.mapper.MessageMapper;

@RestController
@RequestMapping("/api/chats")
public class ChatController {

	@Autowired private SimpMessagingTemplate messagingTemplate;
	
	@Autowired private UserChatService userChatService;
	
	@Autowired private MessageService messageService;
	
	@Autowired private MessageMapper messageMapper;
	
    @Autowired
    private ChatService chatService;
    
    @MessageMapping("/chat")
    public void processMessage(@Payload Message message) {
    	
        Message saved = messageService.save(messageMapper.toMessageEntity(message));
    	
        messagingTemplate.convertAndSendToUser(
                String.valueOf(message.getChatId()), "/queue/messages", saved);
    }


    @GetMapping("/")
    public List<Chat> getAll(){
        return chatService.getAll();
    }

    @GetMapping("/id/{id}")
    public Chat getById(@PathVariable Integer id){
        return chatService.getById(id);
    }

    @PostMapping("/create")
    public Chat createChat(@RequestBody ChatEntity chatEntity){
       return chatService.createChat(chatEntity);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Integer id){
        chatService.deleteById(id);
    }
}