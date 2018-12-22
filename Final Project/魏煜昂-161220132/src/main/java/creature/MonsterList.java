package creature;

import java.util.ArrayList;

public class MonsterList {
    public java.util.List<Creature> List =new ArrayList<Creature>();
    private boolean camp;
    private int size;
    public MonsterList()
    {
        this.size = 8;
        this.camp = false;

            Snake snake = new Snake();
            List.add(snake);
            Scorpion scorpion = new Scorpion();
            List.add(scorpion);
            for (int i = 2; i < 8; i++)
            {
                Toad toad = new Toad();
                List.add(toad);
            }
        //for (Creature aList : List) System.out.print(aList.name);
    }

    public void setQueue(int index) {
        if (index == 1) {
            List.get(1).setPosition(12, 5);
            List.get(2).setPosition(13, 6);
            List.get(3).setPosition(14, 7);
            List.get(4).setPosition(15, 8);
            List.get(5).setPosition(13, 4);
            List.get(6).setPosition(14, 3);
            List.get(7).setPosition(15, 2);
            List.get(0).setPosition(15, 5);
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

    public void move()
    {
        for (int i=0;i<List.size();i++)
            List.get(i).randomMove();
    }

    public void killPoistion(int x, int y) {
        for (int i=0;i<List.size();i++)
        {
            if (List.get(i).getX()==x && List.get(i).getY() == y)
                List.remove(i);
        }
    }

    public Creature get(int index) { return List.get(index); }
    public int getSize(){ return this.size;}
}
