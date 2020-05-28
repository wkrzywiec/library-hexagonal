package io.wkrzywiec.hexagonal.library;

import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

public class LibraryHexagonalConfig {

    @Bean
    RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
