# Задание номер 3. Проект AOPDemo на Spring Boot
Этот проект представляет собой пример приложения на Spring Boot,
использующего аспектно-ориентированное программирование (AOP) для логирования стандартных CRUD операций на примере REST API пользователей и заказов.
## Описание
### Приложение разработано с использованием следующих технологий:

- Spring Boot: для создания веб-приложения и облегчения настройки Spring-приложений.
- Spring Web: для разработки веб-контроллеров и обработки HTTP-запросов.
- Spring Data JPA: для работы с базой данных и управления объектами Java как сущностями.
- Lombok: для автоматической генерации методов, уменьшая шаблонный код.
- Spring AOP: для реализации аспектов, таких как логирование, без прямого изменения кода сервисов.
- 
## Запуск
### Для запуска проекта необходимо выполнить следующие шаги:

- Установите Docker, если они еще не установлены на вашем компьютере.
- Склонируйте репозиторий с проектом на свой локальный компьютер.
- Перейдите в корневую директорию проекта.
- Запустите контейнеры с помощью команды docker-compose up.
- После успешного запуска контейнеров проект будет доступен по адресу http://localhost:8080.
- Проект не имеет UI интерфейса, используйте POSTMAN или другие методы тестирования REST API.

## Работа с системой
### Controller
Проект реализует стандартные CRUD операции для сущностей пользователей и заказов через REST API.

- **Создание пользователя**: `POST /users`
- **Получение всех пользователей**: `GET /users`
- **Получение пользователя по ID**: `GET /users/{id}`
- **Обновление пользователя**: `PUT /users/{id}`
- **Удаление пользователя**: `DELETE /users/{id}`


## Методы AOP:

- serviceLayerExecution(): Этот метод является точкой среза, определяющей все методы в пакете com.nickz.aopdemo.service. Он используется для определения мест, где будут применяться аспекты.

- logBeforeMethod(): Этот метод выполняется перед вызовом каждого метода, соответствующего точке среза serviceLayerExecution(). Он записывает в лог информацию о вызываемом методе и его аргументах перед их выполнением.

- logAfterReturning(): Этот метод выполняется после успешного возврата из метода, соответствующего точке среза serviceLayerExecution(). Он записывает в лог информацию о вызываемом методе и возвращаемом значении.

- logAfterThrowing(): Этот метод выполняется в случае возникновения исключения внутри метода, соответствующего точке среза serviceLayerExecution(). Он записывает в лог информацию о вызываемом методе и сообщение об ошибке.

- logAfterMethod(): Этот метод выполняется после завершения выполнения каждого метода, соответствующего точке среза serviceLayerExecution(). Он записывает в лог информацию о вызываемом методе после его завершения.

### Эти примеры AOP иллюстрируют, как аспекты могут добавлять полезные функции, такие как логирование и мониторинг, без изменения основного кода приложения.


## Дополнительная информация
Проект использует PostgreSQL в качестве базы данных. Для управления зависимостями и сборки проекта используется Maven. Код написан на Java с использованием принципов ООП и внедрения зависимостей через Spring Framework.