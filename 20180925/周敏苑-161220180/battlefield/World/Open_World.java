package World;

import battlefield.Battlefield;
import creature.Grandpa;
import creature.Snake;

import java.io.IOException;

public class Open_World {
    private static final int BATTLEFIELD_ROW = 20;
    private static final int BATTLEFIELD_COLUMN = 20;
    public static void main(String[] args) throws IOException {
        Battlefield battlefield = new Battlefield(BATTLEFIELD_ROW,BATTLEFIELD_COLUMN);
        Grandpa grandpa = new Grandpa("grandpa");
        Snake snake = new Snake("snake");             //两个阵营的头
        Calabash_Scheduler calabash_scheduler = new Calabash_Scheduler(grandpa);
        Monster_Scheduler monster_scheduler = new Monster_Scheduler(snake);    //两个阵营的调度者

        calabash_scheduler.init_Soldiers();
        calabash_scheduler.shuffle();
        calabash_scheduler.display_name();
        calabash_scheduler.sortbyRank();
        calabash_scheduler.shuffle();
        calabash_scheduler.display_color();
        calabash_scheduler.sortbyColor();                //homework1

        monster_scheduler.init_Soldiers();
        monster_scheduler.shuffle();
        monster_scheduler.display();

        calabash_scheduler.setFormation("Line");          //指定队型
        //monster_scheduler.setFormation("Goose");
        monster_scheduler.set_random_Formation();           //随机队型，由IO实现
        battlefield.setField_calabash(calabash_scheduler.getList());
        battlefield.setField_soldier(monster_scheduler.getList(),monster_scheduler.getScorpion());         //获取两队的信息包括位置等
        battlefield.display();

        //battlefield.clear();
    }
}
