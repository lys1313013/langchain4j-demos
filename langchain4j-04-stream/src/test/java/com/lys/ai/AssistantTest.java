package com.lys.ai;

import com.lys.ai.service.Assistant;
import dev.langchain4j.model.chat.response.ChatResponse;
import dev.langchain4j.service.TokenStream;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.CountDownLatch;

/**
 * 类功能描述
 *
 * @author Lys
 * @date 2025/06/20 23:31
 */
@SpringBootTest
public class AssistantTest {
    @Resource
    private Assistant assistant;

    @Test
    void stream() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        TokenStream tokenStream = assistant.chatStream("你好！北京有什么好玩的地方？");
        tokenStream.onPartialResponse(System.out::print)
                .onCompleteResponse((ChatResponse completeResponse) -> {
                    System.out.println();
                    System.out.println("对话完成");
                    countDownLatch.countDown();
                })
                .onError(Throwable::printStackTrace)
                .start();
        countDownLatch.await();
    }
}
