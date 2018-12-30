package logic.battleInformation;/*
 * @author:Wu Gang
 * @create: 2018-10-07 20:39
 */

import logic.creatureInformation.Creature;
import logic.creatureInformation.Monster;
import logic.creatureInformation.monster.*;

import java.util.ArrayList;

public class EvilSide<T> extends Sides<T>{
    private int numOfMonsters;

    public EvilSide(int n) {
        this.side = 1;
        this.numOfMonsters = n;
        init();
    }

    public EvilSide() {
        this.side = 1;
        this.numOfMonsters = 10;
        init();
    }

    public EvilSide(Class<T> tClass){
        this.side = 1;
        this.numOfMonsters = 10;
        init(tClass);
    }

    private void init(){
        this.encouragement = new Snake();
        this.creatures = new ArrayList<>();
        creatures.add(new Scorpion());
        for(int i = 1; i < numOfMonsters; i++)
            creatures.add(new Underlings());
        formation.board.setCreatureOnPosition(formation.board.getSIZE()-1,formation.board.getSIZE()-1,this.encouragement);
    }

    private void init(Class<T> tClass){
        this.encouragement = new Snake<T>(tClass);
        this.creatures = new ArrayList<>();
        creatures.add(new Scorpion<T>(tClass));
        for(int i = 1; i < numOfMonsters; i++)
            creatures.add(new Underlings<T>(tClass));
        formation.board.setCreatureOnPosition(formation.board.getSIZE()-1,formation.board.getSIZE()-1,this.encouragement);
    }

    public Creature getSnake() {
        return encouragement;
    }

    public ArrayList<Creature<T>> getCreatures() {
        return creatures;
    }
    
}
