package com.lys.ai.service;

import dev.langchain4j.agent.tool.P;
import dev.langchain4j.agent.tool.Tool;
import lombok.extern.slf4j.Slf4j;

/**
 * 类功能描述
 *
 * @author Lys
 * @date 2025/06/21 17:31
 */
@Slf4j
public class WeatherTool {

    @Tool("获取天气")
    public String getWeather(@P("城市名称") String city) {
        log.info("获取天气：{}", city);
        if ("北京".equals(city)) {
            return "20摄氏度，晴天" + city;
        } else {
            return "30摄氏度，雨天" + city;
        }
    }
}
