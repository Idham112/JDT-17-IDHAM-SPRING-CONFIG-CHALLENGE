package com.indivaragroup.config.challenge.config;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class StorePropertiesTest {

    @Autowired
    private StoreProperties storeProperties;

    @Test
    void shouldLoadStoreProperties() {
        // Verify that the bean was injected
        assertThat(storeProperties).isNotNull();

        // Verify that the values from application.yml were bound correctly
        assertThat(storeProperties.getName()).isEqualTo("Indivara Mini Store");
        assertThat(storeProperties.getCity()).isEqualTo("Jakarta");
        assertThat(storeProperties.getCurrency()).isEqualTo("IDR");
        assertThat(storeProperties.getMaxDailyOrder()).isEqualTo(100);
        assertThat(storeProperties.getActive()).isTrue();
    }
}
