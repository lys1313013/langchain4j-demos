package com.lys.ai;

import com.lys.ai.config.CustomerServiceCategory;
import dev.langchain4j.classification.TextClassifier;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 类功能描述
 *
 * @author Lys
 * @date 2025/06/21 19:29
 */
@SpringBootTest
public class ClassifyTest {
    @Resource
    private TextClassifier<CustomerServiceCategory> textClassifier;

    @Test
    void classifyTest() {
        System.out.println(textClassifier.classify("我的快递在哪里？"));
        System.out.println(textClassifier.classify("如何退货？"));
    }
}
