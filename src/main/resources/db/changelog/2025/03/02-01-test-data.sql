--liquibase formatted sql

--changeset CityTestData:1740909272-1
--preconditions onFail:CONTINUE onError:CONTINUE
--precondition-sql-check expectedResult:0 SELECT COUNT(*) FROM CITIES

insert into CITIES (ID, NAME)
VALUES
    ( 1, 'Пермь' ),
    ( 2, 'Москва' ),
    ( 3, 'Санкт-Петербург' ),
    ( 4, 'Тюмень' ),
    ( 5, 'Екатеринбург' ),
    ( 6, 'Киров' ),
    ( 7, 'Ижевск' ),
    ( 8, 'Серов' ),
    ( 9, 'Ханты-Мансийск' ),
    ( 10, 'Нижний Новгород' );

--rollback delete from CITIES;

--changeset RouteTestData:1740909202-1
--preconditions onFail:CONTINUE onError:CONTINUE
--precondition-sql-check expectedResult:0 SELECT COUNT(*) FROM ROUTES

insert into ROUTES (ID, MODE, DEPARTURE_CITY_ID, ARRIVAL_CITY_ID, DEPARTURE, ARRIVAL) VALUES
                                                                                          ( 1, 1, 1, 2, NOW(), DATEADD(DAY, 1, NOW()) ),
                                                                                          ( 2, 2, 1, 2, NOW(), DATEADD(DAY, 1, NOW()) ),
                                                                                          ( 3, 0, 1, 2, NOW(), DATEADD(DAY, 1, NOW()) ),
                                                                                          ( 4, 1, 2, 1, NOW(), DATEADD(DAY, 1, NOW()) ),
                                                                                          ( 5, 1, 2, 3, NOW(), DATEADD(DAY, 2, NOW()) ),
                                                                                          ( 6, 1, 2, 4, NOW(), DATEADD(DAY, 3, NOW()) ),
                                                                                          ( 7, 1, 2, 5, NOW(), DATEADD(DAY, 2, NOW()) ),
                                                                                          ( 8, 1, 2, 6, NOW(), DATEADD(DAY, 3, NOW()) ),
                                                                                          ( 9, 1, 2, 7, NOW(), DATEADD(DAY, 1, NOW()) ),
                                                                                          ( 10, 1, 2, 8, NOW(), DATEADD(DAY, 1, NOW()) ),
                                                                                          ( 11, 1, 2, 9, NOW(), DATEADD(DAY, 4, NOW()) ),
                                                                                          ( 12, 1, 2, 10, NOW(), DATEADD(DAY, 1, NOW()) ),
                                                                                          ( 13, 2, 2, 1, NOW(), DATEADD(DAY, 1, NOW()) ),
                                                                                          ( 14, 2, 2, 3, NOW(), DATEADD(DAY, 5, NOW()) ),
                                                                                          ( 15, 2, 2, 4, NOW(), DATEADD(DAY, 1, NOW()) ),
                                                                                          ( 16, 2, 2, 5, NOW(), DATEADD(DAY, 1, NOW()) ),
                                                                                          ( 17, 2, 2, 6, NOW(), DATEADD(DAY, 1, NOW()) ),
                                                                                          ( 18, 2, 2, 7, NOW(), DATEADD(DAY, 4, NOW()) ),
                                                                                          ( 19, 2, 2, 8, NOW(), DATEADD(DAY, 1, NOW()) ),
                                                                                          ( 20, 2, 2, 9, NOW(), DATEADD(DAY, 1, NOW()) ),
                                                                                          ( 21, 2, 2, 10, NOW(), DATEADD(DAY, 1, NOW()) ),
                                                                                          ( 22, 0, 2, 1, NOW(), DATEADD(DAY, 1, NOW()) ),
                                                                                          ( 23, 0, 2, 3, NOW(), DATEADD(DAY, 1, NOW()) ),
                                                                                          ( 24, 0, 2, 4, NOW(), DATEADD(DAY, 1, NOW()) ),
                                                                                          ( 25, 0, 2, 5, NOW(), DATEADD(DAY, 1, NOW()) ),
                                                                                          ( 26, 0, 2, 6, NOW(), DATEADD(DAY, 1, NOW()) ),
                                                                                          ( 27, 0, 2, 7, NOW(), DATEADD(DAY, 1, NOW()) ),
                                                                                          ( 28, 0, 2, 8, NOW(), DATEADD(DAY, 1, NOW()) ),
                                                                                          ( 29, 0, 2, 9, NOW(), DATEADD(DAY, 1, NOW()) ),
                                                                                          ( 30, 0, 2, 10, NOW(), DATEADD(DAY, 1, NOW()) ),
                                                                                          ( 31, 1, 1, 2, DATEADD(DAY, 1, NOW()), DATEADD(DAY, 2, NOW()) ),
                                                                                          ( 32, 1, 3, 2, DATEADD(DAY, 1, NOW()), DATEADD(DAY, 2, NOW()) ),
                                                                                          ( 33, 1, 4, 2, DATEADD(DAY, 1, NOW()), DATEADD(DAY, 2, NOW()) ),
                                                                                          ( 34, 1, 5, 2, DATEADD(DAY, 1, NOW()), DATEADD(DAY, 2, NOW()) ),
                                                                                          ( 35, 1, 6, 2, DATEADD(DAY, 1, NOW()), DATEADD(DAY, 2, NOW()) ),
                                                                                          ( 36, 1, 7, 2, DATEADD(DAY, 1, NOW()), DATEADD(DAY, 2, NOW()) ),
                                                                                          ( 37, 1, 8, 2, DATEADD(DAY, 1, NOW()), DATEADD(DAY, 2, NOW()) ),
                                                                                          ( 38, 1, 9, 2, DATEADD(DAY, 1, NOW()), DATEADD(DAY, 2, NOW()) ),
                                                                                          ( 39, 1, 10, 2, DATEADD(DAY, 1, NOW()), DATEADD(DAY, 2, NOW()) ),
                                                                                          ( 40, 0, 1, 2, DATEADD(DAY, 1, NOW()), DATEADD(DAY, 2, NOW()) ),
                                                                                          ( 41, 0, 3, 2, DATEADD(DAY, 1, NOW()), DATEADD(DAY, 2, NOW()) ),
                                                                                          ( 42, 0, 4, 2, DATEADD(DAY, 1, NOW()), DATEADD(DAY, 2, NOW()) ),
                                                                                          ( 43, 0, 5, 2, DATEADD(DAY, 1, NOW()), DATEADD(DAY, 2, NOW()) ),
                                                                                          ( 44, 0, 6, 2, DATEADD(DAY, 1, NOW()), DATEADD(DAY, 2, NOW()) ),
                                                                                          ( 45, 0, 7, 2, DATEADD(DAY, 1, NOW()), DATEADD(DAY, 2, NOW()) ),
                                                                                          ( 46, 0, 8, 2, DATEADD(DAY, 1, NOW()), DATEADD(DAY, 2, NOW()) ),
                                                                                          ( 47, 0, 9, 2, DATEADD(DAY, 1, NOW()), DATEADD(DAY, 2, NOW()) ),
                                                                                          ( 48, 0, 10, 2, DATEADD(DAY, 1, NOW()), DATEADD(DAY, 2, NOW()) );

--rollback delete from ROUTES;