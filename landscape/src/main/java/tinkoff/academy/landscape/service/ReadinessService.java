package tinkoff.academy.landscape.service;

import org.springframework.stereotype.Service;

@Service
public class ReadinessService {
    private volatile boolean readinessState;

    public ReadinessService() {
        readinessState = false;
    }


    /**
     * Меняет состоние готовности сервиса на true
     */
    public void changeReadinessStateToTrue() {
        readinessState = true;
    }

    /**
     * Возвращает состояние готовности сервиса
     * @return true, если сервис готов, и false, если не готов
     */
    public boolean isServiceReady() {
        return readinessState;
    }
}
