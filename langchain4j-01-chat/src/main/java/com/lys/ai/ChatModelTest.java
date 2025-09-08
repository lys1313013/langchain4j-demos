package com.lys.ai;

import dev.langchain4j.model.openai.OpenAiChatModel;

/**
 * 类功能描述
 *
 * @author Lys
 * @date 2025/9/8
 */
public class ChatModelTest {
    public static void main(String[] args) {
        OpenAiChatModel chatModel = longcatChatModel();
        String response = chatModel.chat("你好");
        System.out.println(response);
    }

    /**
     * 阿里百炼大模型
     * 模型列表：https://help.aliyun.com/zh/model-studio/models
     */
    public static OpenAiChatModel bailianChatModel() {
        return OpenAiChatModel.builder()
                .apiKey(System.getenv("DASHSCOPE_API_KEY"))
                .modelName("qwen-turbo")
                .baseUrl("https://dashscope.aliyuncs.com/compatible-mode/v1")
                .build();
    }

    /**
     * 美团LongChat模型
     * 文档：https://longcat.chat/platform/docs/zh/APIDocs.html
     */
    public static OpenAiChatModel longcatChatModel() {
        return OpenAiChatModel.builder()
                .apiKey(System.getenv("LONGCAT_API_KEY"))
                .modelName("LongCat-Flash-Chat")
                .baseUrl("https://api.longcat.chat/openai/v1/")
                .build();
    }
}
