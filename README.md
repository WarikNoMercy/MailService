# Mail Service

## Описание

Простой почтовый сервис на базе **Spring Boot**, предоставляющий REST API для отправки электронных писем. 

## Установка

### Шаги для запуска

1. Склонируйте репозиторий:
   ```bash
   git clone https://github.com/ваш-проект/mail-service.git
   cd mail-service
2. Настройте SMTP-сервер. Для этого измените файл src/main/resources/application.properties:

   ```bash
   spring.mail.host=smtp.example.com 
    spring.mail.port=587
    spring.mail.username=your_email@example.com
    spring.mail.password=your_password
    spring.mail.properties.mail.smtp.auth=true
    spring.mail.properties.mail.smtp.starttls.enable=true
   
  Замените smtp.example.com, your_email@example.com, и your_password на настройки вашего SMTP-провайдера.
  
3. Соберите и запустите приложение
   ```bash
   mvn spring-boot:run

## Использование

Отправка письма осуществляется через POST-запрос на эндпоинт /send.

### Пример запроса

   ```http
    POST /send HTTP/1.1
    Content-Type: application/json
    
    {
        "reciever": "recipient@example.com",
        "subject": "Привет!",
        "content": "Это тестовое сообщение."
    }
   ```
### Пример успешного ответа

   ```json
   Сообщение успешно отправлено
  ```
### Пример ответа с ошибкой

  ```json
  Ошибка при отправке письма: [описание ошибки]
  ```

