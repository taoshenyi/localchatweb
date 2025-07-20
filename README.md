# LocalChatWeb

A minimal Spring Boot application simulating a local ChatGPT web interface.

## Requirements
- Java 1.8+
- Maven 3.5+

## Running
```bash
mvn spring-boot:run
```

Then open `http://localhost:8080` in the browser.

The default implementation simply echoes your message. Integrate the real
ChatGPT API by implementing `ChatGptClient#requestChatCompletion` and setting
`chatgpt.api-key` in `application.properties`.
