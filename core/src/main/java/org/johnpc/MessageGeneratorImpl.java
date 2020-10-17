package org.johnpc;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @Created By JohnPC
 */
@Slf4j
@Component
public class MessageGeneratorImpl implements MessageGenerator {
    //private static final Logger log = LoggerFactory.getLogger(MessageGeneratorImpl.class);

    private Game game;
/*    private int guessCount = 10;*/

    public MessageGeneratorImpl(Game game) {
        this.game = game;
    }

    @PostConstruct
    public void init(){
        log.info("Game value {}:", game );

    }

    @Override
    public String getMainMessage() {
        return "Number is between " + game.getSmallest() + " and " + game.getBiggest() + ". Cam you guess it?";
    }

    @Override
    public String getResultMessage() {
        if(game.isGameOwn()) {
            return "You guessed it! The number was :" + game.getNumber();
        }
        else if(game.isGameLoss()) {
            return "You Lost. The number was : " +game.getNumber();
        }
        else if(!game.isValidNumberRange()) {
            return "Invalid Number range!";
        }
        else if(game.getRemainingGuesses() == game.getGuessCount()){
            return "What is your first guess?";
        }
        else {
            String direction = "Lower";
            if(game.getGuess() < game.getNumber()) {
                direction = "Higher";
            }
            return direction + "! You have "+ game.getRemainingGuesses() + " guess's left";

        }
    }
}
