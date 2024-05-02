package com.ss.service;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class ApiService {

    private final WebClient webClient;

    public ApiService(WebClient.Builder webClientBuilder, @Value("${second.project.base.url}") String baseUrl) {
        this.webClient = webClientBuilder.baseUrl(baseUrl).build();
    }

    public Mono<String> fetchDataFromApi() {
        return this.webClient.get()
                .uri("/student")
                .retrieve()
                .bodyToMono(String.class)
                .onErrorResume(error -> {
                    // Handle connection errors gracefully
                    System.err.println("Error fetching data from API: " + error.getMessage());
                    return Mono.just("Error occurred while fetching data from API");
                });
    }
}


