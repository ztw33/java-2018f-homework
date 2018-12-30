import java.util.*;
enum Color {红色,橙色,黄色,绿色,青色,蓝色,紫色;}
enum Name {老大,老二,老三,老四,老五,老六,老七;}

public class HuluBrother{

    protected int familyRank;
    protected int initialPosition;
    protected int nowPosition;
    protected String myColor;
    protected String myName;

    HuluBrother(int familyRank, String myColor, String myName){
        this.familyRank = familyRank;
        this.myColor = myColor;
        this.myName = myName;
    }

    public void speakMyName(){
        System.out.print(myName + " ");
    }

    public void speakMyColor(){
        System.out.print(myColor + " ");
    }

    public void exchangeMyPosition(int oldPos, int nowPos){
        System.out.println(myName + ": " + (int)(oldPos + 1) + "->" + (int)(nowPos + 1));
        oldPos = nowPos;
    }
}