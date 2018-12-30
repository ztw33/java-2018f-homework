package sample;

import java.io.File;
import java.io.FileOutputStream;

public class Snake extends Creature {
    //private String name;
    @Edit(editor = "zmr", time = "20181204")
    public String getName(){
        return name;
    }
    public Snake(Field f, File fl, FileOutputStream fos){
        field = f;
        alive = true;
        cor_x = 5;
        cor_y = 3;
        attack = 75;
        name = "Snake";
        file = fl;
        output = fos;
    }
}
