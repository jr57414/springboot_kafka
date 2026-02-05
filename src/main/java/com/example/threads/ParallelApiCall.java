package com.example.threads;

import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;
import org.springframework.web.reactive.function.client.WebClient;

public class ParallelApiCall {

    public static void main(String[] args) {

        WebClient webClient = WebClient.builder().build();

        // First API
        Mono<String> api1 =
                webClient.get()
                        .uri("https://postman-echo.com/get?foo1=bar1")
                        .retrieve()
                        .bodyToMono(String.class);

        // Second API
        Mono<String> api2 =
                webClient.get()
                        .uri("https://postman-echo.com/get?foo2=bar2")
                        .retrieve()
                        .bodyToMono(String.class);

        // Combine both APIs (runs in parallel)
        Mono<Tuple2<String, String>> combined =
                Mono.zip(api1, api2);

        combined.subscribe(result -> {
            System.out.println("API 1 Response:");
            System.out.println(result.getT1());

            System.out.println("\nAPI 2 Response:");
            System.out.println(result.getT2());
        });

        // Prevent JVM from exiting early
        combined.block();
    }
}
