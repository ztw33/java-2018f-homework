package com.javapr;
import com.CalabashBoys.*;
import com.Matrix.*;
import com.Grandfather.*;
import com.Monster.*;
import java.util.*;
import java.io.*;

import java.util.concurrent.Callable;

public class CalabashBoys_2 {

    public static void main(String[] args){
        dimension Matrix = new dimension();
        Matrix.Init();                            //init matrix
        while (true){
            Calabash Baby = new Calabash();
            Baby.Init();                             //init calabashboys
            //Babys.printb();
            Baby.BubbleSort();                       //sort
            Grandfather Gran = new Grandfather();     //init grandfather
            Scorpion Scor = new Scorpion();           //init scorpion
            Snake Snak = new Snake();                 //init snake
            Frog[] frog = new Frog[5];                // init frog

            Matrix.ValuationCalabash(Baby);           //
            Matrix.ValuationMonster(Scor, frog);
            Matrix.ValuationGrandfather(Gran);
            Matrix.ValuationSnake(Snak);

            Matrix.printMatrix();                    //
            /*try {
                Thread.sleep(1000 * 3);
            } catch(InterruptedException e){
                e.printStackTrace();
            }*/
            Matrix.Clear();

            Scanner input = new Scanner(System.in);
            int length = input.nextInt();
            boolean bo = true;
            while (true){
                if (length == 0){            //input 0 to kill
                    bo = false;
                    break;
                }
                else if (length == 5)         //input 5 to continue next circulation
                    break;
                else
                    length = input.nextInt();
            }
            if (!bo)
                break;
            System.out.print("\n\n\n\n\n\n\n\n\n\n\n");
        }
    }
}
