package form;

import java.util.ArrayList;
import spritecontroller.*;

public class Form {
    public Form(){
    }
    public void formForGood(CalabashBrothers calabashBro, Grandpa oneGrandpa){
        calabashBro.sevenBro[0].setPos(4, 3);
        calabashBro.sevenBro[1].setPos(4, 4);
        calabashBro.sevenBro[2].setPos(4, 5);
        calabashBro.sevenBro[3].setPos(4, 6);
        calabashBro.sevenBro[4].setPos(4, 7);
        calabashBro.sevenBro[5].setPos(4, 8);
        calabashBro.sevenBro[6].setPos(4, 9);
        oneGrandpa.setPos(2, 6);
    }
    //反派要变换的阵型
    public int HE_YI(Scorpion oneScorpion, Snake oneSnake, ArrayList<Underlyings> severalUnderlying) {
        oneScorpion.setPos(8, 6);
        severalUnderlying.clear();
        for(int i = 0 ;i < 6; i++)
        {
            severalUnderlying.add(new Underlyings(i + 1));
        }
        severalUnderlying.get(0).setPos(9, 7);
        severalUnderlying.get(1).setPos(10, 8);
        severalUnderlying.get(2).setPos(11, 9);
        severalUnderlying.get(3).setPos(12, 8);
        severalUnderlying.get(4).setPos(13, 7);
        severalUnderlying.get(5).setPos(14, 6);
        oneSnake.setPos(11, 7);
        return 6;
    }
    public int YAN_XING(Scorpion oneScorpion, Snake oneSnake, ArrayList<Underlyings> severalUnderlying) {
        oneScorpion.setPos(9, 7);
        severalUnderlying.clear();
        for(int i = 0 ;i < 4; i++)
        {
            severalUnderlying.add(new Underlyings(i + 1));
        }
        severalUnderlying.get(0).setPos(10, 6);
        severalUnderlying.get(1).setPos(11, 5);
        severalUnderlying.get(2).setPos(12, 4);
        severalUnderlying.get(3).setPos(13, 3);
        oneSnake.setPos(12, 6);
        return 4;
    }
    public int HENG_E(Scorpion oneScorpion, Snake oneSnake, ArrayList<Underlyings> severalUnderlying) {
        oneScorpion.setPos(8, 6);
        severalUnderlying.clear();
        for(int i = 0 ;i < 5; i++)
        {
            severalUnderlying.add(new Underlyings(i + 1));
        }
        severalUnderlying.get(0).setPos(8, 7);
        severalUnderlying.get(1).setPos(8, 8);
        severalUnderlying.get(2).setPos(9, 5);
        severalUnderlying.get(3).setPos(9, 6);
        severalUnderlying.get(4).setPos(9, 7);
        oneSnake.setPos(11, 6);
        return 5;
    }
    public int YU_LIN(Scorpion oneScorpion, Snake oneSnake, ArrayList<Underlyings> severalUnderlying) {
        oneScorpion.setPos(9, 6);
        severalUnderlying.clear();
        for(int i = 0 ;i < 9; i++)
        {
            severalUnderlying.add(new Underlyings(i + 1));
        }
        severalUnderlying.get(0).setPos(10, 6);
        severalUnderlying.get(1).setPos(11, 6);
        severalUnderlying.get(2).setPos(12, 6);
        severalUnderlying.get(3).setPos(11, 7);
        severalUnderlying.get(4).setPos(9, 5);
        severalUnderlying.get(5).setPos(10, 5);
        severalUnderlying.get(6).setPos(11, 5);
        severalUnderlying.get(7).setPos(10, 4);
        severalUnderlying.get(8).setPos(9, 3);
        oneSnake.setPos(13, 6);
        return 9;
    }
    public int FANG_YUAN(Scorpion oneScorpion, Snake oneSnake, ArrayList<Underlyings> severalUnderlying) {
        oneScorpion.setPos(8, 6);
        severalUnderlying.clear();
        for(int i = 0 ;i < 7; i++)
        {
            severalUnderlying.add(new Underlyings(i + 1));
        }
        severalUnderlying.get(0).setPos(9, 7);
        severalUnderlying.get(1).setPos(9, 5);
        severalUnderlying.get(2).setPos(10, 4);
        severalUnderlying.get(3).setPos(10, 8);
        severalUnderlying.get(4).setPos(11, 5);
        severalUnderlying.get(5).setPos(11, 7);
        severalUnderlying.get(6).setPos(12, 6);
        oneSnake.setPos(10, 6);
        return 7;
    }
    public int YAN_YUE(Scorpion oneScorpion, Snake oneSnake, ArrayList<Underlyings> severalUnderlying){
        oneScorpion.setPos(8, 6);
        severalUnderlying.clear();
        for(int i = 0 ;i < 18; i++)
        {
            severalUnderlying.add(new Underlyings(i + 1));
        }
        severalUnderlying.get(0).setPos(8, 5);
        severalUnderlying.get(1).setPos(8, 7);
        severalUnderlying.get(2).setPos(9, 5);
        severalUnderlying.get(3).setPos(9, 6);
        severalUnderlying.get(4).setPos(9, 7);
        severalUnderlying.get(5).setPos(10, 4);
        severalUnderlying.get(6).setPos(11, 3);
        severalUnderlying.get(7).setPos(10, 8);
        severalUnderlying.get(8).setPos(11, 9);
        severalUnderlying.get(9).setPos(10, 5);
        severalUnderlying.get(10).setPos(10, 6);
        severalUnderlying.get(11).setPos(10, 7);
        severalUnderlying.get(12).setPos(11, 4);
        severalUnderlying.get(13).setPos(12, 3);
        severalUnderlying.get(14).setPos(13, 2);
        severalUnderlying.get(15).setPos(11, 8);
        severalUnderlying.get(16).setPos(12, 9);
        severalUnderlying.get(17).setPos(13, 10);
        oneSnake.setPos(11, 6);
        return 18;
    }
    public int FENG_SHI(Scorpion oneScorpion, Snake oneSnake, ArrayList<Underlyings> severalUnderlying) {
        oneScorpion.setPos(11, 3);
        severalUnderlying.clear();
        for(int i = 0 ;i < 11; i++)
        {
            severalUnderlying.add(new Underlyings(i + 1));
        }
        severalUnderlying.get(0).setPos(8, 6);
        severalUnderlying.get(1).setPos(9, 5);
        severalUnderlying.get(2).setPos(10, 4);
        severalUnderlying.get(3).setPos(11, 4);
        severalUnderlying.get(4).setPos(12, 4);
        severalUnderlying.get(5).setPos(13, 5);
        severalUnderlying.get(6).setPos(14, 6);
        severalUnderlying.get(7).setPos(11, 5);
        severalUnderlying.get(8).setPos(11, 6);
        severalUnderlying.get(9).setPos(11, 7);
        severalUnderlying.get(10).setPos(11, 8);
        oneSnake.setPos(12, 6);
        return 11;
    }
}
