package ru.job4j.weather.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.job4j.weather.model.Weather;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
@Slf4j
public class WeatherService {

    private final Map<Integer, Weather> weathers = new ConcurrentHashMap<>();

    {
        weathers.put(1, new Weather(1, "Msc", 20));
        weathers.put(2, new Weather(2, "SPb", 10));
        weathers.put(3, new Weather(3, "Bryansk", 15));
        weathers.put(4, new Weather(4, "Smolensk", 10));
        weathers.put(5, new Weather(5, "Tomsk", 15));
        weathers.put(6, new Weather(6, "Minsk", 15));
    }

    public Mono<Weather> findById(Integer id) {
        log.info("Find by id = " + id);
        return Mono.justOrEmpty(weathers.get(id));
    }

    public Flux<Weather> all() {
        return Flux.fromIterable(weathers.values());
    }

    public Flux<Weather> hottest() {
        log.info("Start Service Hottest");
        Flux<Weather> data = Flux.fromIterable(weathers.values());
        Mono<Weather> maxTemperatureWeather = data.reduce((weather1, weather2) ->
                weather1.getTemperature() > weather2.getTemperature() ? weather1 : weather2);
        log.info("Finish Service Hottest");
        return maxTemperatureWeather.flux();
    }

    public Flux<Weather> cityGreatThen(int t) {
        Flux<Weather> data = Flux.fromIterable(weathers.values());
        return data.filter(weather -> weather.getTemperature() > t);
    }
}