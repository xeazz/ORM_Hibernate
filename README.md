# Слой DAO c Hibernate
1. Создаем Spring Boot приложение с зависимостями на два стартера — `spring-boot-starter-data-jpa` и `spring-boot-starter-web`.

2. Создать `Entity`, которая соответствует таблице из условий задачи [«Таблица пользователей»](https://github.com/xeazz/MySQL_DDL_DML).

3. Реализовать репозиторий для работы с БД.
   - создать класс и пометьте его аннотацией Repository;
   - инжектировать `EntityManager`;
   - создать метод `getPersonsByCity(String city)`, который будет принимать название города и возвращать ваше `Entity` из базы данных, соответствующие этому `city`.
4. Написать контроллер с методом-обработчиком `GET`-метода запроса с маппингом на endpoint `/persons/by-city`. В query params запроса будет приходить строковый параметр `city`, который надо будет передавать дальше в репозиторий. То есть, метод должен уметь обрабатывать запрос вида `localhost:8080/persons/by-city?city=Moscow`. Контроллер должен будет возвращать всех людей, которых он получит от репозитория.