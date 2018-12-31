package Update2.Creature;

import java.util.*;
public class Creature{
    private String name;
    public Creature(){
        name = new String("Grass");
    }
    public void Show(){
        System.out.print("  *  ");
    }
    public String Identity(){return name;};
}