package com.lys.ai;

import com.lys.ai.service.NumberExtractor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 类功能描述
 *
 * @author Lys
 * @date 2025/06/21 17:11
 */
@SpringBootTest
public class numberTest {
    @Autowired
    private NumberExtractor numberExtractor;

    @Test
    void numberExtractor() {
        int days = numberExtractor.extractInt("我今天要请五天假");

        System.out.println(days);
    }
}
