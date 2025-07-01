package com.lys.ai;

import com.lys.ai.service.Assistant;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 类功能描述
 *
 * @author Lys
 * @date 2025/06/25 12:43
 */
@SpringBootTest
public class RedisMemoryStoreTest {

    @Resource
    private Assistant assistant;

    @Test
    void chat() {
        String generate = assistant.chat("1", "你好");
        System.out.println(generate);
    }
}
