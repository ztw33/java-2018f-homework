package renyi;


import java.util.ArrayList;
import java.util.List;

public class Main {
    public static List<String> battlename=new ArrayList<String>();
    public static void main(String[] args)
    {
        battlenameinit();
        for(int i=0;i<8;i++)
        {
            Battle_Array a=new Battle_Array(battlename.get(i),0);
            Field f=new Field(a);
            f.show();
            System.out.println("爷爷和蛇精助阵");
            a=new Battle_Array(battlename.get(i),1);
            f=new Field(a);
            f.show();
        }
    }
    public static void battlenameinit()
    {
        battlename.add("鹤翼");
        battlename.add("雁行");
        battlename.add("衝軛");
        battlename.add("长蛇");
        battlename.add("鱼鳞");
        battlename.add("方円");
        battlename.add("偃月");
        battlename.add("锋矢");
    }
}
