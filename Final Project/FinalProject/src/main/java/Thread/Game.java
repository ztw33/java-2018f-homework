package Thread;

import GUI.GUIWindow;

import java.util.concurrent.Semaphore;

public class Game {

    //MARK:Properties;
    Semaphore[] starts;
    Semaphore[] ends;

    Thread[] monsterList;
    Thread snake;
    Thread scorpion;
    Thread[] calabash;
    Thread grandFather;

    //MARK:Initialize;
    public Game(){

        //init semaphore:
        starts = new Semaphore[7+1+2+7];
        ends = new Semaphore[7+1+2+7];
        for(int i = 0; i < starts.length; i++){
            starts[i] = new Semaphore(0);
            ends[i] = new Semaphore(1);
        }

        /* init Thread */

        //init monster
        MonsterThread[] monsterThreads = new MonsterThread[7];
        monsterList = new Thread[7];
        for(int i = 0; i < monsterThreads.length; i++){
            monsterThreads[i] = new MonsterThread(i+1,starts[i],ends[i]);
            monsterList[i] = new Thread(monsterThreads[i]);
        }

        //init snake
        SnakeThread snakeThread = new SnakeThread(starts[7],ends[7]);
        snake = new Thread(snakeThread);

        //init Scorpion
        ScorpionThread scorpionThread = new ScorpionThread(starts[8],ends[8]);
        scorpion = new Thread(scorpionThread);

        //init calabash
        CalabashThread[] calabashThreads = new CalabashThread[7];
        calabash = new Thread[7];
        for(int i = 0; i < calabashThreads.length; i++){
            calabashThreads[i] = new CalabashThread(i+1,starts[8+i+1],ends[8+i+1]);
            calabash[i] = new Thread(calabashThreads[i]);
        }

        //init grandfather
        GrandFatherThread grandFatherThread = new GrandFatherThread(starts[16],ends[16]);
        grandFather = new Thread(grandFatherThread);
    }

    //MARK: help methods;

    //all thread start;
    public void start(){
        try {
            for (int i = 0; i < ends.length; i++) {
                ends[i].acquire();
            }
            for (int i = 0; i < starts.length; i++) {
                starts[i].release();
            }
        }catch (Exception e){
            System.out.println("game round erro");
        }
        //monster thread start
        for(int i = 0; i < monsterList.length; i++) {
            monsterList[i].start();
        }

        //snake thread start
        snake.start();

        //scorpion thread start
        scorpion.start();

        //calabash thread start
        for(int i = 0; i < calabash.length; i++)
            calabash[i].start();

        //grandFather thread start
        grandFather.start();

    }

    //a circulation;
    public void roundTime(){
        try {
            for (int i = 0; i < ends.length; i++) {
                ends[i].acquire();
            }
            for (int i = 0; i < starts.length; i++) {
                starts[i].release();
            }
        }catch (Exception e){
            System.out.println("game round erro");
        }
    }

}
