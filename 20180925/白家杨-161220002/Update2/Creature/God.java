package Update2.Creature;

//import Update2.Creature.*;
import Update2.Strategy.Changshe;
import Update2.Strategy.Heyi;
import Update2.Strategy.Strategy;
import Update2.Strategy.Yuling;
import Update2.UI;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

enum PERSON {
    HERO("葫芦娃"), GRANDPA(" 爷爷 ");
    private String name;

    private PERSON(String a) {
        this.name = a;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String a) {
        this.name = a;
    }
}

public class God extends Creature implements ItemListener {
    private PERSON man;
    final int row = 15;
    final int col = 10;
    private UI bat;
    public God(UI b) {
        man = PERSON.GRANDPA;
        bat = b;
    }

    public God(PERSON p) {
        switch (p) {
            case HERO:
                man = PERSON.HERO;
                break;
            case GRANDPA:
                man = PERSON.GRANDPA;
                break;
        }
    }

    @Override
    public void Show() {
        System.out.print(man.getName());
    }

    public String Identity(){return man.getName();};

    public void UseStrategy(Strategy str) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (str.Arrange(i, j)) {
                    bat.SetCreature(i, j, new God(PERSON.HERO));
                } else
                    bat.SetCreature(i, j, new Creature());
            }
        }
        //给爷爷安排位置
        int x_pos = str.CoreX(true);
        int y_pos = str.CoreY(true);
        bat.SetCreature(x_pos,y_pos, new God(PERSON.GRANDPA));
    }
    public void itemStateChanged(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED) {     // 查看是否为新选中的选项触发
            if (e.getItem().equals("长蛇阵")) {  // 查看触发的选项
                System.out.println("Demon 长蛇阵");
                UseStrategy(new Changshe());
            }
            else if(e.getItem().equals("鹤翼阵")){
                System.out.println("Demon 鹤翼阵");
                UseStrategy(new Heyi());
            }
            else if(e.getItem().equals("鱼鳞阵")){
                System.out.println("Demon 鱼鳞阵");
                UseStrategy(new Yuling());

            }
            else {
                ;
            }
        }
    }
}
