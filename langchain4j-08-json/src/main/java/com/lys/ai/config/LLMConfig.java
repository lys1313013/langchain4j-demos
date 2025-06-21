package com.lys.ai.config;

import com.lys.ai.service.NumberExtractor;
import com.lys.ai.service.PersonExtractor;
import com.lys.ai.service.SentimentAnalyzer;
import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.service.AiServices;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 类功能描述
 *
 * @author Lys
 * @date 2025/06/21 16:16
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
                .build();
    }

    @Bean
    public NumberExtractor numberExtractor(ChatModel chatModel) {
        return AiServices.create(NumberExtractor.class, chatModel);
    }

    @Bean
    public SentimentAnalyzer sentimentAnalyzer(ChatModel chatModel) {
        return AiServices.create(SentimentAnalyzer.class, chatModel);
    }

    @Bean
    public PersonExtractor personExtractor(ChatModel chatModel) {
        return AiServices.create(PersonExtractor.class, chatModel);
    }
}
