# "Inside" interview, August 2022

REST service, 

Лапынин Андрей.

## Run

1. Download docker desktop for your OS

   ```
   https://www.docker.com/products/docker-desktop
   ```

2. Run command from root of this project in terminal

   ```bash
    docker-compose up -d
   ```

3. You can check running containers with command

   ```bash
   docker ps
   ```   
4. API located at

    ```
    http://localhost:8081
    ```
5. To stop all services use

   ```bash
   docker-compose stop
   ```         

## Тестовое задание
Функционал для пользователя:
- проверка по БД имени пользователя и пароля, генерация токена
- сохранение сообщения в БД при валидном токене
- получение последних 10 сообщений из БД при валидном токене

## Эндпоинты (инструкцию по запуску см. выше):
* **POST** /auth
* **GET**  /message

## curl c тестовыми данными (инструкцию по запуску см. выше):
```
curl --header "Content-Type: application/json" --request POST --data "{\"name\": \"tester\", \"password\": \"123\"}" http://localhost:8081/auth
```
```
curl --header "Content-Type: application/json" --header "Authorization: Bearer_eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0ZXN0ZXIiLCJpYXQiOjE2NjAwNjIyODQsImV4cCI6MTY2MDE0ODY4NH0.0xdr_a9LWSm6eCJ-sO7HQp59-laeSY4dDEhrHqvAmuA" --request GET --data "{\"name\": \"1\", \"message\": \"curl message\"}" http://localhost:8081/message
```
```
curl --header "Content-Type: application/json" --header "Authorization: Bearer_eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0ZXN0ZXIiLCJpYXQiOjE2NjAwNjIyODQsImV4cCI6MTY2MDE0ODY4NH0.0xdr_a9LWSm6eCJ-sO7HQp59-laeSY4dDEhrHqvAmuA" --request GET --data "{\"name\": \"1\", \"message\": \"history 10\"}" http://localhost:8081/message
```
