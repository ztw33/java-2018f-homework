package com.homework2;

import java.util.Random;

public class CalabashBrothers {

    public static final int MAX_CALABASH_BROTHERS_COUNT = 7;
    private CalabashBoy[] calabashBoyArray = new CalabashBoy[MAX_CALABASH_BROTHERS_COUNT];

    public CalabashBrothers() {
        int[] randomArray = createRandomArray();
        for (int i = 0; i < MAX_CALABASH_BROTHERS_COUNT; i++) {
            calabashBoyArray[i] = CalabashBoy.values()[randomArray[i] - 1];
        }
    }

    private int[] createRandomArray() {
        int[] randomArray = new int[MAX_CALABASH_BROTHERS_COUNT];
        Random rand = new Random();
        for (int i = 0; i < randomArray.length; i++) {
            int randomNumber = rand.nextInt(MAX_CALABASH_BROTHERS_COUNT) + 1;
            boolean newNumberFlag;
            do {
                newNumberFlag = false;
                for (int j = 0; j < i; j++) {
                    if (randomNumber == randomArray[j]) {
                        randomNumber = rand.nextInt(MAX_CALABASH_BROTHERS_COUNT) + 1;
                        newNumberFlag = true;
                    }
                }
            } while (newNumberFlag);

            randomArray[i] = randomNumber;
        }

        return randomArray;
    }

    public void swapCalabashBoy(int i, int j) {

        if (i < 0 || i > MAX_CALABASH_BROTHERS_COUNT - 1 || j < 0 || j > MAX_CALABASH_BROTHERS_COUNT - 1) {
            System.out.println("ERROR IN swapCalabashBoy()");
        }
        System.out.print("" + calabashBoyArray[i].getName() + i + " -> " + j + " && ");
        System.out.println("" + calabashBoyArray[j].getName() + j + " -> " + i);

        CalabashBoy temp = calabashBoyArray[i];
        calabashBoyArray[i] = calabashBoyArray[j];
        calabashBoyArray[j] = temp;
    }

    public void swapCalabashBoyWithoutOutput(int i, int j) {

        if (i < 0 || i > MAX_CALABASH_BROTHERS_COUNT - 1 || j < 0 || j > MAX_CALABASH_BROTHERS_COUNT - 1) {
            System.out.println("ERROR IN swapCalabashBoy()");
        }

        CalabashBoy temp = calabashBoyArray[i];
        calabashBoyArray[i] = calabashBoyArray[j];
        calabashBoyArray[j] = temp;
    }

    public int compareCalabashBoy(int i, int j) {

        return calabashBoyArray[i].getRank() - calabashBoyArray[j].getRank();
    }

    public void printAllCalabashBoys() {
        for (int i = 0; i < calabashBoyArray.length; i++) {
            System.out.print(calabashBoyArray[i].getColor() + "(" + calabashBoyArray[i].getRank() + ")");
            if (i != calabashBoyArray.length - 1) {
                System.out.print(" -> ");
            }
        }
        System.out.println();
    }
}
