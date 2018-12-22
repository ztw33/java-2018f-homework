package creature;

import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;
import java.util.List;


public class HeroList {
    public List<Creature> List =new ArrayList<Creature>();
    private boolean camp;
    private int size;
    public HeroList() {
        this.size = 8;
        this.camp = true;

        Grandpa grandpa = new Grandpa();
        List.add(grandpa);
        for (int i = 1; i < 8; i++) {
            Calabash calabash = new Calabash(i);
            List.add(calabash);
        }

        //for (Creature aList : List) System.out.print(aList.name);
    }

    public void setQueue(int index) {
        if (index == 1) {
            List.get(1).setPosition(7, 5);
            List.get(2).setPosition(6, 4);
            List.get(3).setPosition(5, 3);
            List.get(4).setPosition(4, 2);
            List.get(5).setPosition(6, 6);
            List.get(6).setPosition(5, 7);
            List.get(7).setPosition(4, 8);
            List.get(0).setPosition(4, 5);
        } else if (index == 2) {
            List.get(1).setPosition(2, 8);
            List.get(2).setPosition(3, 7);
            List.get(3).setPosition(4, 6);
            List.get(4).setPosition(5, 5);
            List.get(5).setPosition(6, 4);
            List.get(6).setPosition(7, 3);
            List.get(7).setPosition(8, 2);
            List.get(0).setPosition(5, 2);
        }
    }

    public boolean isOccupied(int x, int y){
        for (int i=0;i<List.size();i++)
        {
            if (List.get(i).getX()==x && List.get(i).getY()==y)
                return true;
        }
        return false;
    }

    public void killPoistion(int x, int y) {
        for (int i=0;i<List.size();i++)
        {
            if (List.get(i).getX()==x && List.get(i).getY() == y)
                List.remove(i);
        }
    }

    public void move()
    {
        for (int i=0;i<List.size();i++)
            List.get(i).randomMove();
    }

    public Creature get(int index) { return List.get(index); }
    public int getSize(){ return this.size;}
}
