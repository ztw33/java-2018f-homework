package Creature;

import Map.Graph;

public class Creature {
    protected String name;

    public Creature(){name="□□";}

    public String getName(){
        return name;
    }
    public String tellName(){System.out.print(name+" "); return name;}

    public void setLocation(Graph graph,int x, int y){
        graph.putCreature(this,x,y);
    }

}
