# ptmplace

Маркетплейс пассажирских перевозок

Для начала нужно собрать с помощью gradle:

```./gradlew build```

Можно собрать без запуска тестов:

```./gradlew build -x test```

Затем запустить с помощью docker compose:

```docker compose up --build```

По умолчанию фронтенд будет запущен на порту 3001, чтобы открыть введите http://localhost:3001