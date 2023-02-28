package tinkoff.academy.rancher.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfiguration {
    @Value("${server.port}")
    private int port;

    @Bean
    WebClient webClient() {
        return WebClient.create("http://localhost:" + port);
    }
}
