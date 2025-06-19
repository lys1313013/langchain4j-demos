package com.lys.ai;

import dev.langchain4j.model.chat.ChatModel;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Langchain4j01ChatApplicationTests {
    @Autowired
    private ChatModel chatModel;

    @Test
    void contextLoads() {
        String generate = chatModel.chat("你好");
        System.out.println(generate);
    }

}
