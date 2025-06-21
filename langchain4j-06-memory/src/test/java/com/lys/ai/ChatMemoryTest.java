package com.lys.ai;

import com.lys.ai.service.Assistant;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 类功能描述
 *
 * @author Lys
 * @date 2025/06/21 16:34
 */
@SpringBootTest
public class ChatMemoryTest {
    @Resource
    private Assistant assistant;


    @Test
    void chat() {
        // 第一次对话
        System.out.println(assistant.chat("我喜欢打羽毛球"));
        // 第二次对话
        System.out.println("--------------------------");
        System.out.println(assistant.chat("我喜欢做什么"));
    }

    @Test
    void chatWithConversationId() {
        // 第1次对话
        System.out.println(assistant.chat(1, "我喜欢打羽毛球"));
        // 第2次对话
        System.out.println("--------------------------");
        System.out.println(assistant.chat(1, "我喜欢做什么"));

        // 不同的会话ID，没有上下文
        System.out.println(assistant.chat(2, "我喜欢做什么"));
    }


}
