package Creature;

import CommonMethods.*;

public class CreatureCreater {
    public PointNode[] calabashpos= new PointNode[7];
    public PointNode[] monsterpos = new PointNode[7];
    public CalabashBoy.boy[] calabashBoys;
    public Grandfather grandfather;
    public Snake snake;
    public Scorpion scorpion;
    public Flunky[] flunkies = new Flunky[6];

    public CreatureCreater(){}

    public void initCalabashBoy(){
        this.calabashBoys = CalabashBoy.boy.values();
    }

    public void initGrandfather(){
        this.grandfather = new Grandfather();
    }

    public void initSnake(){
        this.snake = new Snake();
    }

    public void initScorpion(){
        this.scorpion = new Scorpion();
    }

    public void initFlunky(){
        for(int i =0 ; i < flunkies.length; i++)
            flunkies[i] = new Flunky();
    }

    public CalabashBoy.boy[] getCalabashBoys() {
        return calabashBoys;
    }

    public PointNode[] getCalabashpos() {
        return calabashpos;
    }

    public void initCalabash(){
        Dispatcher dispatcher = new Dispatcher(0);
        for(int i = 0 ; i < calabashpos.length; i++)
            calabashpos[i] = new PointNode(calabashBoys[i].name());
        dispatcher.initPosition(calabashpos);
    }

    public PointNode[] initMonsterpos() {
        Dispatcher dispatcher = new Dispatcher(1);
        for(int i = 0 ; i < monsterpos.length; i++)
            monsterpos[i] = new PointNode("F");
        monsterpos[3].name = "Y";
        dispatcher.initMonsterPosition(monsterpos);
        return monsterpos;
    }
}
