package org.johnpc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @Created By JohnPC
 */

public class GameImpl implements Game {

    // == constants ==
    private static final Logger log = LoggerFactory.getLogger(GameImpl.class);

    // == fields ==
    @Autowired
    private NumberGenerator numberGenerator;

    @Autowired
    @GuessCount
    private int guessCount;

    private int number;
    private int guess;
    private int smallest;
    private int biggest;
    private int remainingGuesses;
    private boolean validNumberRange = true;

//    Init Method
    @PostConstruct
    @Override
    public void reset() {
        smallest = 0;
        guess = 0;
        remainingGuesses = guessCount;
        biggest = numberGenerator.getMaxNumber();
        number = numberGenerator.next();
        log.info("The Number is {}", number);
    }

    @PreDestroy
    public void preDestroy() {
        log.info("In the game pre Destroy Method");
    }
    // == Constructor Based Dependency Injection ==

    //public GameImpl(NumberGenerator numberGenerator) {
      //  this.numberGenerator = numberGenerator;
    //}

/*Constructor and setter dependency removed as we are now using annotation based configurations*/
    @Override
    public int getNumber() {
        return number;
    }

    @Override
    public int getGuess() {
        return guess;
    }

    @Override
    public void setGuess(int guess) {
        this.guess = guess;
    }

    @Override
    public int getSmallest() {
        return smallest;
    }

    @Override
    public int getBiggest() {
        return biggest;
    }

    @Override
    public int getRemainingGuesses() {
        return remainingGuesses;
    }

    @Override
    public int getGuessCount() {
        return guessCount;
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
