# myRetail REST Application 

## Requirements
* Java 8
* Apache Maven 3.5.0 or higher

## How to Run

- Clone the project
- Build the project  
```
mvn clean install
```
- Run the application
```
java -jar target/myretail-0.0.1-SNAPSHOT.jar
```
- Make sure your redis-server is up and running
- Use swagger UI http://localhost:8080/myretail/swagger-ui.html
- Run /myretail/price/defaults API to set the default price details

## Using docker

- Build the project  
```
mvn clean install
```
- Run using docker-compose
```
docker-compose up --build 
```