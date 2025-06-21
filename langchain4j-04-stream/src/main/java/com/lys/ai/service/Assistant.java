package com.lys.ai.service;

import dev.langchain4j.service.TokenStream;
import reactor.core.publisher.Flux;

/**
 * 类功能描述
 *
 * @author Lys
 * @date 2025/06/20 23:25
 */
public interface Assistant {

    /**
     * 流式对话
     *
     * @param message 消息
     */
    Flux<String> chat(String message);

    /**
     * 流式对话
     *
     * @param message 消息
     */
    TokenStream chatStream(String message);
}
