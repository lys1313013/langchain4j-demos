package com.lys.ai;

import dev.langchain4j.data.message.UserMessage;
import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.model.chat.response.ChatResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ChatModelTest {
    @Autowired
    private ChatModel chatModel;

    @Test
    void chat() {
        String generate = chatModel.chat("你好");
        System.out.println(generate);
    }

    @Test
    void chatWithUserMessage() {
        UserMessage userMessage = UserMessage.from("你好");
        ChatResponse ChatResponse = chatModel.chat(userMessage);
        System.out.println(ChatResponse.aiMessage().text());
    }

}
