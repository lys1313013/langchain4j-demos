package com.lys.ai.service;

import dev.langchain4j.model.output.structured.Description;
import dev.langchain4j.service.UserMessage;
import lombok.Data;

import java.time.LocalDate;

public interface PersonExtractor {

    @UserMessage("从“{{it}}”中提取关于一个人的信息")
    Person extractPerson(String text);

    @Data
    class Person {
        @Description("人名") // 增加字段描述，让大模型更理解字段含义
        private String name;
        private LocalDate birthDate;
    }
}

