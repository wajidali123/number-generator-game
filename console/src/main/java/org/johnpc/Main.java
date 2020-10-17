package org.johnpc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.security.MessageDigest;

/**
 * @Created By JohnPC
 */


public class Main {
    private final static Logger log = LoggerFactory.getLogger(Main.class);
    public static void main(String[] args){
        log.info("Guess the number game!");

        //Creating context(container)
        ConfigurableApplicationContext context
                = new AnnotationConfigApplicationContext(AppConfig.class);

        // Get the game bean from context
        NumberGenerator numberGenerator = context.getBean(NumberGenerator.class);

        int number = numberGenerator.next();
        log.info("number = {}", number);

        // Get the message generator bean from context
        MessageGenerator messageGenerator = context.getBean(MessageGeneratorImpl.class);
        log.info("getMainMessage {}", messageGenerator.getMainMessage());
        log.info("getResultMessage {}", messageGenerator.getResultMessage());

        context.close();
    }
}
