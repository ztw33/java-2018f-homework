import creature.*;
import creature.huluwa.CalabashBrother;
import space.BatterGround;
import zhenfa.ChangsheZhen;
import zhenfa.FangYuanZhen;
import zhenfa.HeYiZhen;
import zhenfa.ZhenFa;

public class Main {
    public static void main(String[] args){
        BatterGround batterGround =  new BatterGround(10);

        Creature[] huluwa = CalabashBrother.values();
        (new ChangsheZhen(2,1)).apply(batterGround, huluwa);
        OldMan.values()[0].cheer(batterGround,5, 0);

        Creature[] yaojing = new Monster[8];
        yaojing[0] = new Scorpion();
        for(int i=1;i<8;i++){
            yaojing[i] = new Minion();
        }
        ZhenFa zf1 = new HeYiZhen(5,5);
        zf1.apply(batterGround, yaojing);
        (new Snake()).cheer(batterGround, 5, 8);
        batterGround.display();
        zf1.clear(batterGround, yaojing);

        System.out.println("妖精变换阵法：");
        ZhenFa zf2 = new FangYuanZhen(5,5);
        zf2.apply(batterGround, yaojing);
        batterGround.display();
        zf2.clear(batterGround, yaojing);

    }
}
