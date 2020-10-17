package org.johnpc;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Random;

/**
 * @Created By JohnPC
 */

public class NumberGeneratorImpl implements NumberGenerator {

    @Autowired
    @MaxNumber
    private int maxNumber;
    // == fields ==
    private final Random random = new Random();

    // == Public Methods
    @Override
    public int next() {

        return random.nextInt(maxNumber);
    }

    @Override
    public int getMaxNumber() {
        return maxNumber;
    }
}
