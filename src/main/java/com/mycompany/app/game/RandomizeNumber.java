package com.mycompany.app.game;

import java.util.Random;

    public class RandomizeNumber {
        public RandomizeNumber() {
        }

        public int numberGenerator(int max) {
            Random randomGenerator = new Random();
            return randomGenerator.nextInt(max);
        }
}
