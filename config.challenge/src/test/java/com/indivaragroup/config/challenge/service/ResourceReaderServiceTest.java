package com.indivaragroup.config.challenge.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class ResourceReaderServiceTest {
    @Autowired
    private ResourceReaderService resourceReaderService;

    @Test
    void readBannerTest() throws IOException {
        String banner = resourceReaderService.readBanner();

        assertThat(banner).isNotNull();
        assertThat(banner).isEqualTo("========================== INDIVARA MINI STORE ==========================");
    }
}
