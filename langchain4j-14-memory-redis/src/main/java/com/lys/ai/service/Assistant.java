package com.lys.ai.service;

import dev.langchain4j.service.MemoryId;
import dev.langchain4j.service.UserMessage;

/**
 * 类功能描述
 *
 * @author Lys
 * @date 2025/06/20 22:57
 */
public interface Assistant {

    /**
     * 对话
     * @param message
     * @return
     */
    String chat(String message);


    /**
     * 对话
     *
     * @param message 消息
     */
    String chat(@MemoryId String conversationId, @UserMessage String message);
}
