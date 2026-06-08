package com.indivaragroup.config.challenge.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Locale;

@SpringBootTest
public class GreetingMessageServiceTest {

    @Autowired
    private GreetingMessageService greetingMessageService;

    @Test
    void englishTest() {
        String greeting = greetingMessageService.getGreeting(Locale.ENGLISH);
        String status = greetingMessageService.getStatus(Locale.ENGLISH);

        assertThat(greeting).contains("Welcome to Indivara Mini Store located in Jakarta");
        assertThat(status).isEqualTo("Store is currently active");
    }

    @Test
    void shouldReturnIndonesianGreetingAndStatus() {
        Locale indo = new Locale("id");
        String greeting = greetingMessageService.getGreeting(indo);
        String status = greetingMessageService.getStatus(indo);

        assertThat(greeting).contains("Selamat datang di Indivara Mini Store yang berlokasi di Jakarta");
        assertThat(status).isEqualTo("Toko sedang aktif");
    }
}
