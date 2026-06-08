package com.indivaragroup.config.challenge.runner;

import com.indivaragroup.config.challenge.config.StoreProperties;
import com.indivaragroup.config.challenge.service.GreetingMessageService;
import com.indivaragroup.config.challenge.service.ResourceReaderService;
import com.indivaragroup.config.challenge.service.StoreInfoService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class AppRunner implements CommandLineRunner {
    private final StoreInfoService storeInfoService;
    private final ResourceReaderService resourceReaderService;
    private final GreetingMessageService greetingMessageService;
    private final StoreProperties storeProperties;

    public AppRunner(StoreInfoService storeInfoService,
                     ResourceReaderService resourceReaderService,
                     GreetingMessageService greetingMessageService,
                     StoreProperties storeProperties) {
        this.storeInfoService = storeInfoService;
        this.resourceReaderService = resourceReaderService;
        this.greetingMessageService = greetingMessageService;
        this.storeProperties = storeProperties;
    }

    @Override
    public void run(String... args) throws Exception {
        //banner
        System.out.println(resourceReaderService.readBanner());

        //store info
        System.out.println("Store Name      : " + storeProperties.getName());
        System.out.println("Store City      : " + storeProperties.getCity());
        System.out.println("Currency        : " + storeProperties.getCurrency());
        System.out.println("Max Daily Order : " + storeProperties.getMaxDailyOrder());
        System.out.println("Active          : " + storeProperties.getActive());

        // 3. Print Greeting & Status EN
        System.out.println("[EN] " + greetingMessageService.getGreeting(Locale.ENGLISH));
        System.out.println("     " + greetingMessageService.getStatus(Locale.ENGLISH));

        // 4. Print Greeting & Status ID
        Locale id = new Locale("id");
        System.out.println("[ID] " + greetingMessageService.getGreeting(id));
        System.out.println("     " + greetingMessageService.getStatus(id));
    }
}
