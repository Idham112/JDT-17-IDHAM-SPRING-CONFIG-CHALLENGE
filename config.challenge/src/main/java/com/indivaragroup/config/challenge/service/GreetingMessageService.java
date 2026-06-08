package com.indivaragroup.config.challenge.service;

import com.indivaragroup.config.challenge.config.StoreProperties;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class GreetingMessageService {
    private final MessageSource messageSource;
    private final StoreProperties storeProperties;

    public GreetingMessageService(MessageSource messageSource, StoreProperties storeProperties) {
        this.messageSource = messageSource;
        this.storeProperties = storeProperties;
    }

    public String getGreeting(Locale locale) {
        return messageSource.getMessage(
                "store.greeting",
                new Object[]{storeProperties.getName(), storeProperties.getCity()},
                locale
        );
    }

    public String getStatus(Locale locale) {
        String key = storeProperties.getActive() ? "store.status.active" : "store.status.inactive";
        return messageSource.getMessage(key, null, locale);
    }
}
