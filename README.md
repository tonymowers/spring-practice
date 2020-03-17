![](https://github.com/tonymowers/spring-practice/workflows/Test/badge.svg)

# Spring Boot Practice

A repository for practicing with spring boot.

## Run using Maven

```
mvn spring-boot:run
```

To use the application open your web browser to  [localhost:8080](http://localhost:8080)

## Develop Frontend

With the backend already running execute:
```
mvn clean package
./npm start
```

## Building and Running Docker Images

### To Build Docker Image to Local Registry

```
mvn compile jib:dockerBuild -Dimage=spring-practice
```

### To Run Docker Image from Local Registry

```
docker run -p 8080:8080 spring-practice
```

### To Build Docker Image and Publish to Docker Hub

The following will publish to docker hub using the maven project version as the image tag:
```
mvn clean compile jib:build
```

The following will run the docker image from the docker hub repository:
```
docker run -p 8080:8080 tony-mowers/spring-practice:<project.version>
```
for example:
```
docker run -p 8080:8080 tony-mowers/spring-practice:0.4.0-SNAPSHOT
```
or
```
docker run -p 8080:8080 tony-mowers/spring-practice:latest
```

The following will publish to docker hub using both the maven project version and 'latest' as the image tags:
```
mvn clean compile jib:build -Djib.to.tags=latest
```

