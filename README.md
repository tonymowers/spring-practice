# Spring Boot Practice

A repository for practicing with spring boot

## To Run

```
mvn spring-boot:run
```

To use the application open your web browser to  [localhost:8080](http://localhost:8080)


## To Build Docker Image to Local Registry

```
mvn compile com.google.cloud.tools:jib-maven-plugin:2.0.0:dockerBuild -Dimage=spring-practice
```

## To Run Docker Image from Local Registry

```
docker run -p 8080:8080 spring-practice
```

## To Build Docker Image and Publish to Docker Hub

The following will publish to docker hub using the maven project version as the image tag:
```
mvn clean compile jib:build
```

The following will public to docker hub using both the maven project version and 'latest' as the image tags:
```
mvn clean compile jib:build -Djib.to.tags=latest
```