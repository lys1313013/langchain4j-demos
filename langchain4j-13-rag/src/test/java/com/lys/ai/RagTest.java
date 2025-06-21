package com.lys.ai;

import com.lys.ai.service.Assistant;
import dev.langchain4j.data.document.Document;
import dev.langchain4j.data.document.DocumentLoader;
import dev.langchain4j.data.document.loader.FileSystemDocumentLoader;
import dev.langchain4j.data.document.parser.TextDocumentParser;
import dev.langchain4j.data.document.source.ClassPathSource;
import dev.langchain4j.data.document.splitter.DocumentByCharacterSplitter;
import dev.langchain4j.data.segment.TextSegment;
import dev.langchain4j.store.embedding.EmbeddingStoreIngestor;
import dev.langchain4j.store.embedding.inmemory.InMemoryEmbeddingStore;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.ResourceLoader;

import java.io.IOException;
import java.util.List;

/**
 * 类功能描述
 *
 * @author Lys
 * @date 2025/06/21 21:46
 */
@SpringBootTest
public class RagTest {
    @Resource
    private Assistant assistant;

    @Autowired
    InMemoryEmbeddingStore<TextSegment> embeddingStore;

    /**
     * 测试txt读取并使用
     */
    @Test
    void txtTest() {
        Document document = DocumentLoader.load(ClassPathSource.from("test.txt"), new TextDocumentParser());
        EmbeddingStoreIngestor.ingest(document, embeddingStore);

        String chat = assistant.chat("合同的金额是多少");
        System.out.println(chat);
    }

    /**
     * 测试word读取并使用
     */
    @Test
    void wordTest() throws IOException {
        ResourceLoader resourceLoader = new DefaultResourceLoader();
        org.springframework.core.io.Resource resource = resourceLoader.getResource("classpath:test.docx");
        Document document = FileSystemDocumentLoader.loadDocument(resource.getFile().toPath());
        EmbeddingStoreIngestor.ingest(document, embeddingStore);

        String chat = assistant.chat("合同的金额是多少");
        System.out.println(chat);
    }

    /**
     * 测试文档分割
     */
    @Test
    void wordSplitTest() throws IOException {
        ResourceLoader resourceLoader = new DefaultResourceLoader();
        org.springframework.core.io.Resource resource = resourceLoader.getResource("classpath:test.docx");
        Document document = FileSystemDocumentLoader.loadDocument(resource.getFile().toPath());
        EmbeddingStoreIngestor.ingest(document, embeddingStore);

        List<TextSegment> split = new DocumentByCharacterSplitter(100, 0).split(document);
        for (int i = 0; i < split.size(); i++) {

            System.out.println("分片" +  i + "：");
            System.out.println(split.get(i).text());
        }
    }
}
