package org.skvortsov.config;

import org.skvortsov.main.GuessCount;
import org.skvortsov.main.MaxNumber;
import org.skvortsov.main.MinNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = "org.skvortsov")
@PropertySource("classpath:config/game.properties")
public class GameConfig {

    @Value("${game.minNumber:0}")
    private int minNumber;

    @Value("${game.maxNumber:50}")
    private int maxNumber;

    @Value("${game.guessCount:5}")
    private int guessCount;

    @Bean
    @MinNumber
    public int minNumber() {
        return minNumber;
    }

    @Bean
    @MaxNumber
    public int maxNumber() {
        return maxNumber;
    }

    @Bean
    @GuessCount
    public int guessCount() {
        return guessCount;
    }
}
