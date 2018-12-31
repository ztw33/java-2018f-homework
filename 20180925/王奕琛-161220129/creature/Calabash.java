package creature;

import creature.Creature;

//葫芦娃类；
public class Calabash extends Creature {
    public enum COLOR{RED,ORANGE,YELLOW,GREEN,CYAN,BLUE,PURPLE}

    private COLOR color;
    private int num;

    public Calabash(int n){
        switch (n){
            case 0:name = "大娃";break;
            case 1:name = "二娃";break;
            case 2:name = "三娃";break;
            case 3:name = "四娃";break;
            case 4:name = "五娃";break;
            case 5:name = "六娃";break;
            case 6:name = "七娃";break;

        }
        this.num = n;
        this.color = COLOR.values()[n];
    }

    public int getNum(){
        return num;
    }
}
