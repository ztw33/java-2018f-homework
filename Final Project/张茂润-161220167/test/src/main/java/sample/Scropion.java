package sample;
import java.io.*;
public class Scropion extends Creature {
    //private String name;
    @Edit(editor = "zmr", time = "20181204")
    public String getName(){
        return name;
    }
    public Scropion(Field f, File fl, FileOutputStream fos){
        field = f;
        alive = true;
        cor_x = 5;
        cor_y = 4;
        name = "Scropion";
        attack = 45;
        file = fl;
        output = fos;
    }
}
