package tinkoff.academy.landscape.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tinkoff.academy.landscape.dto.ExploreResponse;
import tinkoff.academy.landscape.service.ExploreService;

import java.util.List;

@RestController
@RequestMapping("/explore")
@RequiredArgsConstructor
public class ExploreController {
    private final ExploreService exploreService;

    @GetMapping
    public List<ExploreResponse> exploreServices() {
        return exploreService.exploreAllServices();
    }
}
