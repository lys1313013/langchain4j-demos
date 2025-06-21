package com.lys.ai.config;

import com.lys.ai.service.Assistant;
import com.lys.ai.service.WeatherTool;
import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.service.AiServices;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 类功能描述
 *
 * @author Lys
 * @date 2025/06/20 22:42
 */
@Configuration
public class LLMConfig {
    @Bean
    public ChatModel chatModel() {
        return OpenAiChatModel.builder()
                .apiKey(System.getenv("DASHSCOPE_API_KEY"))
                .modelName("qwen-turbo")
                .baseUrl("https://dashscope.aliyuncs.com/compatible-mode/v1")
                .logRequests(true)
                .logResponses(true)
                .build();
    }

    @Bean
    public Assistant aiService(ChatModel chatModel) {
        return AiServices.builder(Assistant.class)
                .chatModel(chatModel)
                .tools(new WeatherTool())
                .build();
    }

}
