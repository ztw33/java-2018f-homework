package logic.battleInformation;/*
 * @author:Wu Gang
 * @create: 2018-10-07 20:19
 */

import logic.creatureInformation.calabashBrother.*;
import logic.creatureInformation.Creature;
import logic.creatureInformation.GrandPa;

import java.util.ArrayList;


public class JustSide<T> extends Sides<T>{
    public JustSide() {
        this.side = 0;
        this.creatures = new ArrayList<>();
        int i = 0;

        this.creatures.add(new DaWa());
        this.creatures.add(new ErWa());
        this.creatures.add(new SanWa());
        this.creatures.add(new SiWa());
        this.creatures.add(new WuWa());
        this.creatures.add(new LiuWa());
        this.creatures.add(new QiWa());

        this.encouragement = new GrandPa();
        formation.board.setCreatureOnPosition(0,0, this.encouragement);
    }

    public JustSide(Class<T> tClass) {
        this.side = 0;
        this.creatures = new ArrayList<>();
        int i = 0;

        this.creatures.add(new DaWa<T>(tClass));
        this.creatures.add(new ErWa<T>(tClass));
        this.creatures.add(new SanWa<T>(tClass));
        this.creatures.add(new SiWa<T>(tClass));
        this.creatures.add(new WuWa<T>(tClass));
        this.creatures.add(new LiuWa<T>(tClass));
        this.creatures.add(new QiWa<T>(tClass));

        this.encouragement = new GrandPa<T>(tClass);
        formation.board.setCreatureOnPosition(0,0, this.encouragement);
    }

    public ArrayList<Creature<T>> getCalabashBrothers() {
        return creatures;
    }

    public Creature getEncouragement() {
        return this.encouragement;
    }
}
