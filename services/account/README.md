# Spring Boot Starter

Basic application with a REST Server and Client. 

The following commands are run in the project root

### Build:

#### Windows:
`gradlew.bat build docker`

#### Linux/macOS:
`./gradlew build docker`



### Run with Docker:
`docker run -p 8080:8080 iwoom/spring-boot-starter`

### Run without Docker:

#### Windows:
`gradlew.bat bootRun`

#### Linux/macOS:
`./gradlew bootRun`

### Endpoints:
`localhost:8080/api/teams/{long id}`  I recommend using `10`