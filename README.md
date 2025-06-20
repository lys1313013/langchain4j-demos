本项目主要为LangChain4j使用示例，参考自https://github.com/pig-mesh/langchain4j-course 项目。









不同场景对应的不同的地址

阿里百炼：https://dashscope.aliyuncs.com/compatible-mode/v1

deepseek: https://api.deepseek.com

Ollama: http://localhost:11434/v1

其中Ollama不需要配置api-key







# 01-chat

通过yml配置文件配置参数，测试ChatModel使用

```yml
langchain4j:
  open-ai:
    chat-model:
      api-key: ${DASHSCOPE_API_KEY:sk-XXXXXXXXXXXXXXXXX}
      model-name: qwen-turbo
      base-url: https://dashscope.aliyuncs.com/compatible-mode/v1
```

# 02-chat-config

通过代码的方式配置ChatModel



# 03-chat-aiservice

aiservice使用

# 04-stream

流式输出