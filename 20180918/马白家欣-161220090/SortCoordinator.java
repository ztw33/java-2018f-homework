package com.homework2;

import java.util.Random;

public class SortCoordinator implements SortAlgorithm{

    public static void main(String[] args) {

        SortCoordinator sortCoordinator = new SortCoordinator();
        sortCoordinator.bubbleSort();
        sortCoordinator.binaryInsertSort();
    }

    final int MAX_SHUFFLE_COUNT = 1000;
    private CalabashBrothers calabashBrothers = new CalabashBrothers();

    private void shuffleCalabashBrothers()
    {
        Random rand = new Random();

        for(int i = 0; i < MAX_SHUFFLE_COUNT;i++)
        {
            int positionToBeSwapped1 = rand.nextInt(CalabashBrothers.MAX_CALABASH_BROTHERS_COUNT);
            int positionToBeSwapped2 = rand.nextInt(CalabashBrothers.MAX_CALABASH_BROTHERS_COUNT);
            calabashBrothers.swapCalabashBoyWithoutOutput(positionToBeSwapped1, positionToBeSwapped2);
        }
    }


    public void bubbleSort() {
        System.out.println("It's Bubble sort");
        shuffleCalabashBrothers();
        System.out.print("Before sorted: ");
        calabashBrothers.printAllCalabashBoys();
        for (int i = CalabashBrothers.MAX_CALABASH_BROTHERS_COUNT - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (calabashBrothers.compareCalabashBoy(j, j + 1) > 0) {
                    calabashBrothers.swapCalabashBoy(j, j + 1);
                }
            }
        }
        System.out.print("After sorted: ");
        calabashBrothers.printAllCalabashBoys();
        System.out.println();
    }

    public void binaryInsertSort() {
        System.out.println("It's Binary Insert sort");
        shuffleCalabashBrothers();
        System.out.print("Before sorted: ");
        calabashBrothers.printAllCalabashBoys();
        for (int i = 1; i < CalabashBrothers.MAX_CALABASH_BROTHERS_COUNT; i++) {
            int highPosition = i;
            int lowPosition = 0;
            int midPosition;
            while (highPosition >= lowPosition) {
                midPosition = (highPosition + lowPosition) / 2;
                if (calabashBrothers.compareCalabashBoy(midPosition, i) > 0) {
                    highPosition = midPosition - 1;
                } else {
                    lowPosition = midPosition + 1;
                }
            }

            for (int j = i - 1; j >= lowPosition; j--) {
                calabashBrothers.swapCalabashBoy(j, j + 1);
            }
        }
        System.out.print("After sorted: ");
        calabashBrothers.printAllCalabashBoys();
        System.out.println();
    }

}