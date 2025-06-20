package com.lys.ai;

import com.lys.ai.service.Assistant;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 测试assistant使用
 *
 * @author Lys
 * @date 2025/06/20 23:12
 */
@SpringBootTest
public class AiServiceTest {
    @Resource
    private Assistant assistant;

    @Test
    void chat() {
        String generate = assistant.chat("你好");
        System.out.println(generate);
    }
}
