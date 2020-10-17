package org.johnpc.config;

import org.johnpc.GuessCount;
import org.johnpc.MaxNumber;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Created By JohnPC
 */

@Configuration
public class GameConfig {
    /* fields */
    private int maxNumber = 50;
    private int guessCount = 8;

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
