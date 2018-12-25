package CalashBro;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;

import javax.swing.*;
import java.awt.*;

public class Creature {
    int i; //在棋盘里面的位置
    int j;
    String name;
    boolean nature;
    Image image;
    public Creature(int x,int y)
    {
        i = x;
        j = y;
    }
    public Creature()
    {
        i = -1;
        j = -1;
    }
    public void changeTheposition(int i,int j)
    {
        this.i = i;
        this.j = j;
    }
    public void getTheinfo()
    {
        if(name != "蝎子精") System.out.print(name+"  ");
        else  System.out.print(name);
        System.out.print(i+"坐标"+j);
    }
    public int getI()
    {
        return i;
    }
    public int getJ()
    {
        return j;
    }
    public void show_GUI(Canvas canvas)
    {
        canvas.getGraphicsContext2D().drawImage(this.image,this.j * 50 ,this.i * 50);
    }
}

class Grandfather extends Creature{
    Grandfather()
    {
        name = "爷爷";
        nature = true;
        this.image =  new Image(getClass().getClassLoader().getResource("pic/grandfather.jpg").toString()
                ,50,50,false,false);
    }
}

