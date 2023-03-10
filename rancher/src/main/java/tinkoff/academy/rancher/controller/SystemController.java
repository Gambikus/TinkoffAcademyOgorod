package tinkoff.academy.rancher.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tinkoff.academy.rancher.service.ReadinessService;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/system")
public class SystemController {
    @GetMapping(value = "/liveness")
    public ResponseEntity<?> getLivenessStatus() {
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/readiness", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, String>> getReadinessStatus() {
        if (ReadinessService.isServiceReady()) {
            return new ResponseEntity<>(
                    Map.of("RancherService", "OK"),
                    HttpStatus.OK
            );
        }
        return new ResponseEntity<>(
                Map.of("reason", "Application context is not initialized yet"),
                HttpStatus.SERVICE_UNAVAILABLE
        );
    }
}
