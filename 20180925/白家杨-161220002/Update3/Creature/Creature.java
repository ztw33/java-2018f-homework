package Update3.Creature;

import java.util.*;
public class Creature implements Identity{
    protected String name;
    public Creature(){
        name = new String("Grass");
    }
    public void Show(){
        System.out.print("  *  ");
    }
    public String Identity(){return name;};
}