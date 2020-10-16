package org.johnpc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Created By JohnPC
 */


public class GameImpl implements Game {

    // == constants ==
    private static final Logger log = LoggerFactory.getLogger(GameImpl.class);

    // == fields ==
    private NumberGenerator numberGenerator;
    private int guessCount=10;
    private int number;
    private int guess;
    private int smallest;
    private int biggest;
    private int remainingGuesses;
    private boolean validNumberRange = true;

    // == Constructor Based Dependency Injection ==

    //public GameImpl(NumberGenerator numberGenerator) {
      //  this.numberGenerator = numberGenerator;
    //}

    // == Setter based Dependency Injection ==


    public void setNumberGenerator(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    @Override
    public void reset() {
        smallest = 0;
        guess = 0;
        remainingGuesses = 0;
        biggest = numberGenerator.getMaxNumber();
        number = numberGenerator.next();
        log.info("The Number is {}", number);
    }

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
