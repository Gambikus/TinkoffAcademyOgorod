package tinkoff.academy.handyman.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tinkoff.academy.handyman.response.SystemReadinessResponse;

@RestController
@RequestMapping("/system")
public class SystemController {

    @GetMapping(value = "/liveness")
    public ResponseEntity<?> getLivenessStatus() {
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/readiness", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SystemReadinessResponse> getReadinessStatus() {
        return new ResponseEntity<>(new SystemReadinessResponse("OK"), HttpStatus.OK);
    }
}
