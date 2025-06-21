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

# 05-vision

图片识别

# 06-memroy

记忆

# 07-prompt

提示词拼接

# 08-json

json格式输出

# 09-function

函数调用

# 10-embedding-qdrant

qdrant向量库创建集合、插入数据、查询数据

# 11-embedding-classify

基于向量实现文本分类

# 12-websearch

基于Tavily实现搜索

# 13-rag

基于txt和word实现rag流程



