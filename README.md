# spring-boot-docker

[Runing Spring Boot application in Docker]

## Requirements
- Maven 3
- Java 8
- Docker 1.13.0+

## build application

```
mvn clean package dockerfile:build
```

## Runing with Docker Compose

```
docker-compose up
```

## Access test

- http://localhost:8080/db/pool/name
- http://localhost:8080/db/pool/size
