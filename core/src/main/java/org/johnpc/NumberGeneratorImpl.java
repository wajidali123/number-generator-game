package org.johnpc;

import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * @Created By JohnPC
 */

@Component
public class NumberGeneratorImpl implements NumberGenerator {

    private final int maxNumber;

    private final int minNumber;



    // == fields ==
    private final Random random = new Random();

    public NumberGeneratorImpl(@MaxNumber int maxNumber, @MinNumber int minNumber) {
        this.maxNumber = maxNumber;
        this.minNumber = minNumber;
    }

    // == Public Methods
    @Override
    public int next() {

        return random.nextInt(maxNumber - minNumber) + minNumber;
    }

    @Override
    public int getMaxNumber() {
        return maxNumber;
    }

    @Override
    public int getMinNumber() {
        return minNumber;
    }
}
