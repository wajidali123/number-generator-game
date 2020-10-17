package org.johnpc;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Scanner;

/**
 * @Created By JohnPC
 */
@Slf4j
@Component
public class ConsoleNumberGuess {
    /* Constants */
    //private static final Logger log = LoggerFactory.getLogger(ConsoleNumberGuess.class);

    private final Game game;
    private final MessageGenerator messageGenerator;

    public ConsoleNumberGuess(Game game, MessageGenerator messageGenerator) {
        this.game = game;
        this.messageGenerator = messageGenerator;
    }

    @EventListener(ContextRefreshedEvent.class) //Another ways is to pass ContextRefreshedEvent.class to @EventListner
    public void start() {
        log.info("start() => Container ready for use!");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println(messageGenerator.getMainMessage());
            System.out.println(messageGenerator.getResultMessage());
            int guess = scanner.nextInt();
            scanner.nextLine();
            game.setGuess(guess);
            game.check();

            if(game.isGameOwn() || game.isGameLoss()) {
                System.out.println(messageGenerator.getResultMessage());
                System.out.println("Play again y/n");
                String playAgain = scanner.nextLine().trim();
                if(!playAgain.equalsIgnoreCase("y")){
                    break;
                }
                game.reset();
            }
        }
    }
}

