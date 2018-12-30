package sample;
import java.io.*;

public class LoLo extends Creature {
   // private String name;
    @Edit(editor = "zmr", time = "20181204")
    public String getName(){
        return name;
    }
    public LoLo(int x, int y, Field f, int in, File fl, FileOutputStream fos){
        field = f;
        alive = true;
        cor_x = x;
        cor_y = y;
        index = in;
        name = "LoLo";
        attack = 15;
        file = fl;
        output = fos;
    }
}
