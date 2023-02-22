## HW1

### В ходе выполнения домашнего задания я сделал:
> 1. Создал сервисы с помощью  SpringBoot Initializer (Gradle / Java / Jar / 17)
> 2. Я присвоил порты сервисам:
     >    1. Landscape - 8080
>    2. Rancher - 8082
>    3. Handyman - 8081
> 3. Системные эндпоинты в каждом сервисе *http://localhost:{servicePort}/system/liveness* и *http://localhost:{servicePort}/system/readiness*
     >    1. **/liveness** - возвращает HTTP код 200, если сервис жив
>    2. **/readiness** - возвращает HTTP код 200 и JSON-файл с информацией о сервисе, если сервис готов, иначе код 503 и JSON-файл с причиной недоступности сервиса, для проверки состояние готовности сервиса я слушал событие *ApplicationReadyEvent*
> 4. Эндпоинты Actuator *http://localhost:{servicePort}/actuator/info* и *http://localhost:{servicePort}/metrics*, для такого вида эндпоинтов, я изменил базовый путь для эндпоинтов.
     >    1. **/actuator/info** - возвращает текущую версию сервиса, берущуюся из файла build.gradle
>    2. **/metrics** - предоставляет метрики в формате Prometheus.
> 5. Написал JavaDoc для всех публичных методов, кроме методов в контроллерах. 