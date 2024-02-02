package org.example.conrollers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.awt.*;
import java.util.List;
import java.util.Objects;

@Controller
public class MessageController {
 private MessageService messageService;
 private ObjectMapper objectMapper;

    @Autowired
    public MessageController(MessageService messageService, ObjectMapper objectMapper) {
        this.messageService = messageService;
        this.objectMapper = objectMapper;
    }

    @GetMapping(path = "/messages",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String getMessages(){
        String result;
        try {
            result = objectMapper.writeValueAsString(messageService.getMessages());
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    @PostMapping("/messages")
    public String postMessage(@RequestBody String message){
        if (message == null || message.isEmpty()) {
            return "show_error";
        }
        messageService.putMessage(message);
        return "show_accepted";
    }

}
//Создайте простое веб-приложение, которое принимает POST-запрос с
// текстом и добавляет этот текст в список. В ответ на POST запрос
// приложение отправляет представление с текстом «Ваше сообщение принято».
// По GET-запросу приложение возвращает список всех сообщений в виде JSON.