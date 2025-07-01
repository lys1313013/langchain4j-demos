package com.lys.ai.service;

import dev.langchain4j.data.message.ChatMessage;
import dev.langchain4j.data.message.ChatMessageDeserializer;
import dev.langchain4j.data.message.ChatMessageSerializer;
import dev.langchain4j.store.memory.chat.ChatMemoryStore;
import jakarta.annotation.Resource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 类功能描述
 *
 * @author Lys
 * @date 2025/06/27 23:42
 */
@Service
public class RedisChatMemoryStore implements ChatMemoryStore {

    @Resource
    private RedisTemplate<String,String> redisTemplate;

    @Override
    public List<ChatMessage> getMessages(Object memoryId) {
        String key = getKey(memoryId);
        String message = redisTemplate.opsForValue().get(key);
        if (message == null) {
            return List.of();
        }
        return ChatMessageDeserializer.messagesFromJson(message);
    }

    @Override
    public void updateMessages(Object memoryId, List<ChatMessage> messages) {
        String key = getKey(memoryId);
        String jsonMessage = ChatMessageSerializer.messagesToJson(messages);
        redisTemplate.opsForValue().set(key, jsonMessage);
    }

    @Override
    public void deleteMessages(Object memoryId) {
        String key = getKey(memoryId);
        redisTemplate.delete(key);
    }

    private String getKey(Object memoryId) {
        return "memory:" + memoryId;
    }
}
