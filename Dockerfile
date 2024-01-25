FROM openjdk
WORKDIR weather_reactive
ADD target/weather_reactive-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT java -jar app.jar
