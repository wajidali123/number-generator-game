package org.johnpc;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @Created By JohnPC
 */
@Slf4j
@Getter
@Component
public class GameImpl implements Game {

    // == constants ==
    //private static final Logger log = LoggerFactory.getLogger(GameImpl.class);

    // == fields ==
    @Getter(AccessLevel.NONE)
    private final NumberGenerator numberGenerator;
    private final int guessCount;

    @Autowired
    public GameImpl(NumberGenerator numberGenerator, @GuessCount int guessCount) {
        this.numberGenerator = numberGenerator;
        this.guessCount = guessCount;
    }

    private int number;
    @Setter
    private int guess;

    private int smallest;
    private int biggest;
    private int remainingGuesses;
    private boolean validNumberRange = true;

//    Init Method
    @PostConstruct
    @Override
    public void reset() {
        smallest = numberGenerator.getMinNumber();
        guess = numberGenerator.getMinNumber();
        remainingGuesses = guessCount;
        biggest = numberGenerator.getMaxNumber();
        number = numberGenerator.next();
        log.info("The Number is {}", number);
    }

    @PreDestroy
    public void preDestroy() {
        log.info("In the game pre Destroy Method");
    }
    @Override
    public void check() {
        checkValidNumberRange();
        if(validNumberRange){
            if (guess > number){
                biggest = guess -1;
            }
            if (guess < number){
                smallest = guess + 1;
            }
        }
        remainingGuesses--;
    }

    @Override
    public boolean isValidNumberRange() {
        return validNumberRange;
    }

    @Override
    public boolean isGameOwn() {
        return guess == number;
    }

    @Override
    public boolean isGameLoss() {
        return !isGameOwn() && remainingGuesses <= 0;
    }

    // This is the private method to check the validNumberRange
    private void checkValidNumberRange() {
        validNumberRange = (guess >= smallest && (guess <= biggest));
    }
}
