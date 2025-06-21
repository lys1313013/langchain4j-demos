package com.lys.ai;

import dev.langchain4j.data.embedding.Embedding;
import dev.langchain4j.data.segment.TextSegment;
import dev.langchain4j.model.embedding.EmbeddingModel;
import dev.langchain4j.model.output.Response;
import dev.langchain4j.store.embedding.EmbeddingSearchRequest;
import dev.langchain4j.store.embedding.EmbeddingSearchResult;
import dev.langchain4j.store.embedding.EmbeddingStore;
import io.qdrant.client.QdrantClient;
import io.qdrant.client.grpc.Collections;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static dev.langchain4j.store.embedding.filter.MetadataFilterBuilder.metadataKey;

/**
 * 类功能描述
 *
 * @author Lys
 * @date 2025/06/21 18:03
 */
@SpringBootTest
public class QdrantTest {

    @Resource
    private EmbeddingModel embeddingModel;

    @Resource
    private QdrantClient qdrantClient;

    @Resource
    private EmbeddingStore<TextSegment> embeddingStore;

    /**
     * 创建Qdrant集合
     */
    @Test
    void createCollectionTest() {
        var vectorParams = Collections.VectorParams.newBuilder()
                .setDistance(Collections.Distance.Cosine)
                .setSize(1024)
                .build();
        qdrantClient.createCollectionAsync("test", vectorParams);
    }

    /**
     * 测试文本向量化
     */
    @Test
    void textEmbeddingTest() {
        Response<Embedding> embeddingResponse = embeddingModel.embed("测试文本，文本向量化");
        System.out.println(embeddingResponse);
    }

    @Test
    void saveTest() {
        TextSegment segment1 = TextSegment.from("深度学习导论：涵盖神经网络、CNN、RNN和强化学习");
        segment1.metadata().put("title", "深度学习实战");
        segment1.metadata().put("author", "张三");
        Embedding embedding1 = embeddingModel.embed(segment1).content();
        embeddingStore.add(embedding1, segment1);

        TextSegment segment2 = TextSegment.from("Python编程从入门到精通：数据科学、Web开发和自动化");
        segment2.metadata().put("title", "Python高级编程");
        segment2.metadata().put("author", "李四");
        Embedding embedding2 = embeddingModel.embed(segment2).content();
        embeddingStore.add(embedding2, segment2);
    }

    /**
     * 测试基本向量搜索功能
     * 验证系统能否通过语义相似度查询找到最相关的文本片段
     */
    @Test
    void searchTest() {
        Embedding queryEmbedding = embeddingModel.embed("我想学习神经网络和自然语言处理技术").content();
        EmbeddingSearchRequest embeddingSearchRequest = EmbeddingSearchRequest.builder()
                .queryEmbedding(queryEmbedding)
                .maxResults(1)
                .build();
        EmbeddingSearchResult<TextSegment> searchResult = embeddingStore.search(embeddingSearchRequest);
        System.out.println(searchResult.matches().get(0).embedded().text());
    }

    /**
     * 测试元数据过滤
     */
    @Test
    void metafileTest() {
        Embedding queryEmbedding = embeddingModel.embed("我想学习神经网络和自然语言处理技术").content();
        EmbeddingSearchRequest embeddingSearchRequest = EmbeddingSearchRequest.builder()
                .queryEmbedding(queryEmbedding)
                .filter(metadataKey("author").isEqualTo("张三"))
                .maxResults(1)
                .build();

        EmbeddingSearchResult<TextSegment> searchResult = embeddingStore.search(embeddingSearchRequest);

        System.out.println(searchResult.matches().get(0).embedded().text());
    }
}
