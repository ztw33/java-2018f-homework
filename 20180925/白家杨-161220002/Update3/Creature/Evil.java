package Update3.Creature;

import Update3.BattleField;
import Update3.Creature.Creature;
import Update3.Strategy.*;
import Update3.UI;

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
/*enum MONSTERS {
    UGLY("小喽啰"), BOSS("大蛇精");
    private String name;

    private MONSTERS(String a) {
        this.name = a;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String a) {
        this.name = a;
    }
}
*/
public class Evil extends Creature implements ItemListener{
    //private MONSTERS man;
    final int row = 15;
    final int col = 10;
    final int base_col = 10;
    private BattleField bat;
    public Evil(){;}
    public Evil(BattleField b) {
        //man = MONSTERS.BOSS;
        bat = b;
    }

    @Override
    public void Show() {
        System.out.print(name);
    }

    public String Identity(){return name;};

    public void UseStrategy(Strategy str) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (str.Arrange(i, j)) {
                    bat.SetCreature(i, base_col + j, new Monster());
                } else
                    bat.SetCreature(i, base_col + j, new Creature());
            }
        }
        //给BOSS安排位置
        int x_pos = str.CoreX(false);
        int y_pos = str.CoreY(false);
        bat.SetCreature(x_pos,y_pos+base_col, new Boss());
    }

    public void itemStateChanged(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED) {     // 查看是否为新选中的选项触发
            if (e.getItem().equals("长蛇阵")) {  // 查看触发的选项
                System.out.println("Demon 长蛇阵");
                bat.AppendText("妖怪摆出了长蛇阵");
                UseStrategy(new Changshe());
            }
            else if(e.getItem().equals("鹤翼阵")){
                System.out.println("Demon 鹤翼阵");
                bat.AppendText("妖怪摆出了鹤翼阵");
                UseStrategy(new Heyi());
            }
            else if(e.getItem().equals("方圆阵")){
                System.out.println("Demon 方圆阵");
                bat.AppendText("妖怪摆出了方圆阵");
                UseStrategy(new Fangyuan());
            }
            else if(e.getItem().equals("锋矢阵")){
                System.out.println("Demon 锋矢阵");
                bat.AppendText("妖怪摆出了锋矢阵");
                UseStrategy(new Fengshi());
            }
            else if(e.getItem().equals("雁行阵")){
                System.out.println("Demon 雁行阵");
                bat.AppendText("妖怪摆出了雁行阵");
                UseStrategy(new Yanxing());
            }
            else if(e.getItem().equals("偃月阵")){
                System.out.println("Demon 偃月阵");
                bat.AppendText("妖怪摆出了偃月阵");
                UseStrategy(new Yanyue());
            }
            else if(e.getItem().equals("鱼鳞阵")){
                System.out.println("Demon 鱼鳞阵");
                bat.AppendText("妖怪摆出了鱼鳞阵");
                UseStrategy(new Yuling());
            }
            else if(e.getItem().equals("衡轭阵")){
                System.out.println("Demon 衡轭阵");
                bat.AppendText("妖怪摆出了衡轭阵");
                UseStrategy(new Henggui());
            }
            else {
                ;
            }
        }
    }
}
