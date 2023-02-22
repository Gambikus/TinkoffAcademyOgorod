package tinkoff.academy.landscape.service;

public class ReadinessService {

    private static volatile boolean readinessState = false;

    /**
     * Меняет состоние готовности сервиса на true
     */
    public static void changeReadinessStateToTrue() {
        readinessState = true;
    }

    /**
     * Возвращает состояние готовности сервиса
     * @return true, если сервис готов, и false, если не готов
     */
    public static boolean isServiceReady() {
        return readinessState;
    }
}
