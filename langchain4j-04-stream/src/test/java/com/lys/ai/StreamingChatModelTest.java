package com.lys.ai;

import dev.langchain4j.model.chat.StreamingChatModel;
import dev.langchain4j.model.chat.response.ChatResponse;
import dev.langchain4j.model.chat.response.StreamingChatResponseHandler;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.CountDownLatch;

/**
 * 类功能描述
 *
 * @author Lys
 * @date 2025/06/20 23:40
 */
@SpringBootTest
public class StreamingChatModelTest {
    @Resource
    private StreamingChatModel streamingChatModel;

    @Test
    void chat() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        streamingChatModel.chat("你好！北京有什么好玩的地方？", new StreamingChatResponseHandler() {
            @Override
            public void onPartialResponse(String token) {
                System.out.print(token);
            }

            @Override
            public void onCompleteResponse(ChatResponse chatResponse) {
                System.out.println();
                System.out.println("对话完成");
                countDownLatch.countDown();
            }

            @Override
            public void onError(Throwable throwable) {

            }
        });
        countDownLatch.await();
    }
}
