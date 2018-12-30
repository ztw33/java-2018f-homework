package sample;
import java.io.*;

enum Color{
    RED, ORANGE, YELLOW, GREEN, WATHET, BLUE, PURPLE,
}
public class HuluBro extends Creature {
    @Edit(editor = "zmr", time = "20181202")
    private Color color;
    //private String name;

    public Color getColor(){
        return color;
    }
    public String getName(){
        return name;
    }
    public HuluBro(int i, Field f, File fl, FileOutputStream fos){
        field = f;
        alive = true;
        file = fl;
        output = fos;
        //cor_x = cor_y = 0;
        //attack = 0;
        switch (i){
            case 1:
                color = Color.RED;
                name = "Hulu1";
                cor_x = 1;
                cor_y = 3;
                attack = 90;
                break;
            case 2:
                color = Color.ORANGE;
                name = "Hulu2";
                cor_x = 1;
                cor_y = 2;
                attack = 80;
                break;
            case 3:
                color = Color.YELLOW;
                name = "Hulu3";
                cor_x = 1;
                cor_y = 4;
                attack = 70;
                break;
            case 4:
                color = Color.GREEN;
                name = "Hulu4";
                cor_x = 1;
                cor_y = 1;
                attack = 60;
                break;
            case 5:
                color = Color.WATHET;
                name = "Hulu5";
                cor_x = 1;
                cor_y = 5;
                attack = 50;
                break;
            case 6:
                color = Color.BLUE;
                name = "Hulu6";
                cor_x = 1;
                cor_y = 0;
                attack = 40;
                break;
            case 7:
                color = Color.PURPLE;
                name = "Hulu7";
                cor_x = 1;
                cor_y = 6;
                attack = 30;
                break;
            default:
                break;
        }
    }
}
