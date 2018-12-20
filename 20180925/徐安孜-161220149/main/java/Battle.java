package main.java;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Battle {
    static Space battlefield;
    static SpaceManager god;
    static int current=1;
    static void restart(){
        for(int i=0;i<battlefield.columns;i++)
            for(int j=0;j<battlefield.rows;j++)
                god.removeCreature(battlefield,battlefield.map[i][j]);
    }
    static void scene1(){
        ArrayList<Creature> CalabashBrothers = new ArrayList<>();
        CalabashBrothers.add(new Calabash(CalabashRank.FIRST,"/main/resource/1.png"));
        CalabashBrothers.add(new Calabash(CalabashRank.SECOND,"/main/resource/2.png"));
        CalabashBrothers.add(new Calabash(CalabashRank.THIRD,"/main/resource/3.png"));
        CalabashBrothers.add(new Calabash(CalabashRank.FORTH,"/main/resource/4.png"));
        CalabashBrothers.add(new Calabash(CalabashRank.FIFTH,"/main/resource/5.png"));
        CalabashBrothers.add(new Calabash(CalabashRank.SIXTH,"/main/resource/6.png"));
        CalabashBrothers.add(new Calabash(CalabashRank.SEVENTH,"/main/resource/7.png"));
        god.placeFormation(battlefield,new SnakeFormation(CalabashBrothers.size()),CalabashBrothers,2,2);


        //create and place grandpa&snake
        GoodBoss grandpa = new GoodBoss("/main/resource/grandpa.jpg");
        BadBoss snake= new BadBoss("/main/resource/snake.jpg");
        god.placeCreature(battlefield,grandpa,4,5);
        god .placeCreature(battlefield,snake,15,6);


        //create and place monsters
        ArrayList<Creature> ScorpionSquad = new ArrayList<>();
        ScorpionSquad.add(new Scorpion("/main/resource/scorpion.jpg"));
        for(int i=0;i<8;i++)
            ScorpionSquad.add(new LittleMonster("/main/resource/littlemonster.jpg"));
        god.placeFormation(battlefield,new WingFormation(ScorpionSquad.size()),ScorpionSquad,9,2);
    }

    static void scene2(){
        ArrayList<Creature> CalabashBrothers = new ArrayList<>();
        CalabashBrothers.add(new Calabash(CalabashRank.FIRST,"/main/resource/1.png"));
        CalabashBrothers.add(new Calabash(CalabashRank.SECOND,"/main/resource/2.png"));
        CalabashBrothers.add(new Calabash(CalabashRank.THIRD,"/main/resource/3.png"));
        CalabashBrothers.add(new Calabash(CalabashRank.FORTH,"/main/resource/4.png"));
        CalabashBrothers.add(new Calabash(CalabashRank.FIFTH,"/main/resource/5.png"));
        CalabashBrothers.add(new Calabash(CalabashRank.SIXTH,"/main/resource/6.png"));
        CalabashBrothers.add(new Calabash(CalabashRank.SEVENTH,"/main/resource/7.png"));
        god.placeFormation(battlefield,new SnakeFormation(CalabashBrothers.size()),CalabashBrothers,2,2);


        //create and place grandpa&snake
        GoodBoss grandpa = new GoodBoss("/main/resource/grandpa.jpg");
        BadBoss snake= new BadBoss("/main/resource/snake.jpg");
        god.placeCreature(battlefield,grandpa,4,5);
        god .placeCreature(battlefield,snake,15,6);


        //create and place monsters
        ArrayList<Creature> ScorpionSquad = new ArrayList<>();
        ScorpionSquad.add(new Scorpion("/main/resource/scorpion.jpg"));
        for(int i=0;i<8;i++)
            ScorpionSquad.add(new LittleMonster("/main/resource/littlemonster.jpg"));
        god.placeFormation(battlefield,new GeeseFormation(ScorpionSquad.size()),ScorpionSquad,9,2);
    }
}
