package com.lys.ai;

import com.lys.ai.service.Assistant;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * 类功能描述
 *
 * @author Lys
 * @date 2025/06/21 20:59
 */
@SpringBootTest
public class WebSearchTest {
    @Resource
    private Assistant assistant;

    @Test
    void searchTest() {
        // 获取当前日期
        LocalDate currentDate = LocalDate.now();
        // 定义日期格式
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        // 将日期格式化为字符串
        String formattedDate = currentDate.format(formatter);

        String message = String.format("今天%s上证指数是多少？", formattedDate);
        String chat = assistant.chat(message);

        System.out.println(chat);
    }
}
