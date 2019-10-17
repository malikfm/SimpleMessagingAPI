# SimpleMessagingAPI
Create API for:
- Sending a message. Just send one parameter string for message. After sending should be get response.
- Collect messages that has been sent out API can get all previously sent messages.
- Display messages in real time. API should be long live connection to retrieve messages after send at realtime.

## Prerequisites
- Spring Boot with dependencies: Spring Web and WebSocket
- CSS Bootstrap
- jQuery
- SockJs Client
- STOMP WebSocket

I use WebJars to import client-side web libraries.

## Built With
[Maven](https://maven.apache.org) - Dependency Management

## Deployment and Testing
Generate jar package
```
mvn install
```
Run the program
```
java -jar {your-jar-package-name}.jar
```
Point your browser at localhost:8080. Type a message on textarea. After you click "Send" it will appear below "Message Streaming". Click "Show all messages" to view all previously sent messages.
