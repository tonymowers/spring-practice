# Spring Boot Practice

A repository for practicing with spring boot

## To Run

```
mvn spring-boot:run
```

To use the application open your web browser to  [localhost:8080](http://localhost:8080)


## To Build Docker Image

```
mvn compile com.google.cloud.tools:jib-maven-plugin:2.0.0:dockerBuild -Dimage=spring-practice
```

## To Run Docker Image

```
docker run -p 8080:8080 spring-practice
```