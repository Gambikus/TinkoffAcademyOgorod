package tinkoff.academy.handyman.service;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class SystemStatusService {

    private final WebClient webClient;

    public Map<String, String> GetReadiness() {
        return webClient
                .get()
                .uri("/system/readiness")
                .retrieve()
                .bodyToMono(Map.class)
                .block();
    }

    public Map<String, String> GetVersion() {
        return (Map)webClient
                .get()
                .uri("actuator/info")
                .retrieve()
                .bodyToMono(Map.class)
                .block()
                .get("build");
    }
}

