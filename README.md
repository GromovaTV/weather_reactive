# weather_reactive

Приложение прогноза погоды, работающее в режиме реактивного программирования, 
обрабатывает следующие запросы через своё API.

## Dependencies

* Spring Webflux
* Spring Boot
* Spring Security (JWT for authentication and authorization)
* Docker
* Java 17
* Lombok
* Slf4j
* Swagger
* Maven
* Checkstyle

## REST API:

Показать список всех городов с погодой:

*GET: /all*

Показать температуру выбранного города:

*GET: /get/{id}*

Показать город с самой высокой температурой:

*GET: /hottest*

Показать города, где температура выше заданной:

*GET: /cityGreatThen/{t}*

***

## Accessing the API via Swagger:
http://localhost:8080/swagger-ui/index.html#

## Installation Instructions

### Installing Docker Compose
*1. Download the package:*
````
sudo curl -L "https://github.com/docker/compose/releases/download/1.28.6/docker-compose-$(uname -s)-$(uname -m)" -o
/usr/local/bin/docker-compose
````

*2. Set permissions:*
````
sudo chmod +x /usr/local/bin/docker-compose
````

### Project Setup
*0. Install Maven:*
````
sudo apt-get update
sudo apt-get install maven
````

*1. Clone the project:*
````
git clone https://github.com/GromovaTV/weather_reactive
````

*2. Build the project:*
````
cd weather_reactive
mvn package
````

*3. Build Docker image:*
````
docker build -t weather_reactive .
````

*4. Run the application:*
````
docker-compose up
````