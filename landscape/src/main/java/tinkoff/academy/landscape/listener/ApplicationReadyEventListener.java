package tinkoff.academy.landscape.listener;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import tinkoff.academy.landscape.service.ReadinessService;

@Component
@RequiredArgsConstructor
public class ApplicationReadyEventListener {

    private final ReadinessService readinessService;


    /**
     * Меняет состояние готовности сервиса на true, когда случается событие ApplicationReadyEvent
     */
    @EventListener(ApplicationReadyEvent.class)
    public void changeReadinessStatus() {
        readinessService.changeReadinessStateToTrue();
    }
}
