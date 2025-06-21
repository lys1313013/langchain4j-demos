package com.lys.ai;

import dev.langchain4j.data.message.ImageContent;
import dev.langchain4j.data.message.TextContent;
import dev.langchain4j.data.message.UserMessage;
import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.model.chat.response.ChatResponse;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;

/**
 * 类功能描述
 *
 * @author Lys
 * @date 2025/06/21 16:18
 */
@SpringBootTest
public class ImageTest {
    @Resource
    private ChatModel chatModel;

    @Test
    void testImageRecognition() throws IOException {
        // 1. 读取resource下的image.png文件
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("img.png");
        // 2. 转换为byte数组
        byte[] imageBytes = inputStream.readAllBytes();
        // 3. 编码为Base64字符串
        String base64Image = Base64.getEncoder().encodeToString(imageBytes);

        UserMessage userMessage = UserMessage.from(TextContent.from("这个图片描述了什么？"),
                ImageContent.from(base64Image, "image/png"));

        ChatResponse response = chatModel.chat(userMessage);
        System.out.println(response.aiMessage().text());
    }
}
