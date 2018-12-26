package creature;
import color.COLOR;

import javafx.scene.image.*;
import java.io.File;
import java.io.IOException;

public class HuluWa extends Creature {
    private int priority;
    private COLOR color;
    public HuluWa(int huluwaNumber) {
        switch (huluwaNumber) {
            case 1:
                name = "老大";
                priority = 1;
                color = COLOR.RED;
                imgPath = "image/red.jpeg";
                break;
            case 2:
                name = "老二";
                priority = 2;
                color = COLOR.ORANGE;
                imgPath = "image/orange.jpeg";
                break;
            case 3:
                name = "老三";
                priority = 3;
                color = COLOR.YELLOW;
                imgPath = "image/yellow.jpeg";
                break;
            case 4:
                name = "老四";
                priority = 4;
                color = COLOR.GREEN;
                imgPath = "image/green.jpeg";
                break;
            case 5:
                name = "老五";
                priority = 5;
                color = COLOR.CYAN;
                imgPath = "image/cyan.jpeg";
                break;
            case 6:
                name = "老六";
                priority = 6;
                color = COLOR.BLUE;
                imgPath = "image/blue.jpeg";
                break;
            case 7:
                name = "老七";
                priority = 7;
                color = COLOR.PURPLE;
                imgPath = "image/purple.jpeg";
                break;
            default:
                System.out.println("error:there is only 7 HuluWas");
                break;
        }
        image = new Image(imgPath);
    }
    public void shoutOutColor(){
        System.out.print(color.colorInChinese);
    }
    public int getPriority(){
        return priority;
    }
    public COLOR getColor(){
        return color;
    }
    public boolean comparePriority(HuluWa compareTarget){
        //if priority is smaller than compareTarget return true
        if (priority < compareTarget.getPriority()){
            return true;
        } else {
            return false;
        }
    }
    public int compareColor(HuluWa compareTarget){
        return color.ordinal() - compareTarget.getColor().ordinal();
    }
    public void swapHuluWa(HuluWa swapTarget, int src, int dest){

        //System.out.println(name+":"+(src+1)+"->"+(dest+1));
        //System.out.println(swapTarget.getName()+":"+(dest+1)+"->"+(src+1));
    }
}
