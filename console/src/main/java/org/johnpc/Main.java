package org.johnpc;

import org.johnpc.config.GameConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Created By JohnPC
 */

public class Main {
    private final static Logger log = LoggerFactory.getLogger(Main.class);
    public static void main(String[] args){
        log.info("Guess the number game!");

        //Creating context(container)
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(GameConfig.class);
        context.close();
    }
}
