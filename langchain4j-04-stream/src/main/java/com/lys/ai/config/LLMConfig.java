package com.lys.ai.config;

import com.lys.ai.service.Assistant;
import dev.langchain4j.model.chat.StreamingChatModel;
import dev.langchain4j.model.openai.OpenAiStreamingChatModel;
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
    public StreamingChatModel streamingChatLanguageModel(){
        return OpenAiStreamingChatModel.builder()
                .apiKey(System.getenv("DASHSCOPE_API_KEY"))
                .modelName("qwen-turbo")
                .baseUrl("https://dashscope.aliyuncs.com/compatible-mode/v1")
                .build();
    }

    @Bean
    public Assistant assistant(StreamingChatModel streamingChatModel){
        return AiServices.create(Assistant.class, streamingChatModel);
    }
}
