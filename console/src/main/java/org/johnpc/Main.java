package org.johnpc;

import lombok.extern.slf4j.Slf4j;
import org.johnpc.config.GameConfig;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Created By JohnPC
 */
@Slf4j
public class Main {
    //private final static Logger log = LoggerFactory.getLogger(Main.class);
    public static void main(String[] args){
        log.info("Guess the number game!");

        //Creating context(container)
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(GameConfig.class);
        context.close();
    }
}
