package com.lys.ai.config;

import dev.langchain4j.classification.EmbeddingModelTextClassifier;
import dev.langchain4j.classification.TextClassifier;
import dev.langchain4j.model.embedding.EmbeddingModel;
import dev.langchain4j.model.openai.OpenAiEmbeddingModel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.lys.ai.config.CustomerServiceCategory.*;

/**
 * 类功能描述
 *
 * @author Lys
 * @date 2025/06/21 19:12
 */
@Configuration
public class LLMConfig {

    @Bean
    public EmbeddingModel embeddingModel() {
        return OpenAiEmbeddingModel.builder()
                .apiKey(System.getenv("DASHSCOPE_KEY"))
                .modelName("text-embedding-v3")
                .baseUrl("https://dashscope.aliyuncs.com/compatible-mode/v1")
                .build();
    }

    @Bean
    public TextClassifier<CustomerServiceCategory> textClassifier(EmbeddingModel embeddingModel) {
        Map<CustomerServiceCategory, List<String>> examples = new HashMap<>();
        examples.put(BILLING_AND_PAYMENTS, List.of(
                "我可以用PayPal支付吗？",
                "你们接受比特币吗？",
                "可以通过电汇支付吗？",
                "我尝试付款时总是收到错误信息。",
                "我的卡被扣了两次费，能帮忙解决吗？",
                "为什么我的付款被拒绝了？",
                "如何申请退款？",
                "我什么时候能收到退款？",
                "如果我取消订阅，可以退款吗？",
                "能给我发送上笔订单的发票吗？"
        ));
        examples.put(TECHNICAL_SUPPORT, List.of(
                "应用每次打开都会崩溃。",
                "我无法保存设置中的更改。",
                "为什么搜索功能不能用？",
                "安装程序卡在50%。",
                "我一直收到‘安装失败’的信息。",
                "如何在Mac上安装这个？",
                "我无法连接到服务器。",
                "为什么我总是断线？",
                "我的Wi-Fi能用，但你们的应用说没有网络连接。",
                "为什么应用这么慢？"
        ));
        examples.put(ACCOUNT_MANAGEMENT, List.of(
                "我忘记密码了，如何重置？",
                "我没有收到密码重置邮件。",
                "有没有办法在应用内更改密码？",
                "如何设置双重验证？",
                "我手机丢了，现在怎么登录？",
                "为什么我收不到双重验证码？",
                "我的账户被锁定了，该怎么办？",
                "登录尝试次数有限制吗？",
                "我无缘无故被锁定了，能帮忙吗？",
                "如何更改我的邮箱地址？"
        ));
        examples.put(PRODUCT_INFORMATION, List.of(
                "‘同步’功能是做什么的？",
                "隐私模式是如何工作的？",
                "能解释一下实时追踪功能吗？",
                "新款式什么时候有货？",
                "这款有中号吗？",
                "你们会很快补货已售罄的商品吗？",
                "1.0版和2.0版有什么区别？",
                "专业版值得多花钱吗？",
                "旧版本支持新更新吗？",
                "这个产品兼容iOS吗？"
        ));
        examples.put(ORDER_STATUS, List.of(
                "我的订单现在在哪里？",
                "能给我一个追踪号码吗？",
                "我怎么知道我的订单已经发货了？",
                "我可以更改运输方式吗？",
                "你们提供次日达快递吗？",
                "可以从门店自提吗？",
                "我的订单什么时候能到？",
                "为什么我的配送延迟了？",
                "我可以指定一个配送日期吗？",
                "已经过了配送日期，我的订单在哪里？"
        ));
        examples.put(RETURNS_AND_EXCHANGES, List.of(
                "你们的退货政策是什么？",
                "退货运费免费吗？",
                "退货需要原包装吗？",
                "如何获得退货标签？",
                "退货需要打电话给客服吗？",
                "需要RMA号码（退件授权号）吗？",
                "我需要换一个不同的尺码。",
                "我可以换货礼品吗？",
                "换货流程需要多长时间？",
                "我的商品送达时损坏了，该怎么办？"
        ));
        examples.put(FEEDBACK_AND_COMPLAINTS, List.of(
                "材料质量不像广告宣传的那样。",
                "产品用了一周就坏了。",
                "洗了一次颜色就褪了。",
                "客服代表对我态度粗鲁。",
                "我电话等了30分钟，这让人无法接受。",
                "你们的客服快速解决了我的问题，谢谢！",
                "你们的网站很难浏览。",
                "应用总是崩溃，令人沮丧。",
                "结账流程令人困惑。",
                "你们应该提供聊天功能以获得更快的帮助。"
        ));
        return new EmbeddingModelTextClassifier<>(embeddingModel, examples);
    }
}
