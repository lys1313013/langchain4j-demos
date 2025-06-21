package com.lys.ai;

import com.lys.ai.service.Assistant;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 类功能描述
 *
 * @author Lys
 * @date 2025/06/21 17:36
 */
@SpringBootTest
public class FunctionTest {
    @Resource
    private Assistant assistant;

    @Test
    void functionTest() {
        System.out.println(assistant.chat("北京的天气"));
        System.out.println(assistant.chat("福建的天气"));
    }
}
