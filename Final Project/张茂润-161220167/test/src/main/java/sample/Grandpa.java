package sample;

import java.io.*;

public class Grandpa extends Creature {
   // private String name;
   @Edit(editor = "zmr", time = "20181202")
    public String getName(){
        return name;
    }
    public Grandpa(Field f, File fl, FileOutputStream fos){
        field = f;
        alive = true;
        //cor_x = cor_y = 0;
        attack = 20;
        name = "Grandpa";
        cor_x = 0;
        cor_y = 3;
        file = fl;
        output = fos;
    }
}
