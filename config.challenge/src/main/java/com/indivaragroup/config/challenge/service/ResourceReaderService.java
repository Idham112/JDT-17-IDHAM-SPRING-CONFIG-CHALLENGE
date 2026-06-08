package com.indivaragroup.config.challenge.service;

import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Service
public class ResourceReaderService {
    private final ResourceLoader resourceLoader;

    public ResourceReaderService(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    public String readBanner() throws IOException {
        Resource resource = resourceLoader.getResource("classpath:banner.txt");
        String content = resource.getContentAsString(StandardCharsets.UTF_8);
        return content;
    }
}
