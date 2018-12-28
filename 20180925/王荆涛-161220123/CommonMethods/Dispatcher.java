package CommonMethods;

import Creature.CalabashBoy;

import java.util.Random;

/**
 * 生物调度器
 * 分为正义一方的调度和邪恶一方的调度
 * 正义一方的调度，主要是通过排序算法将葫芦娃排成队列保护爷爷
 * 邪恶一方的调度，主要是根据蝎子精的口令进行阵型变换
 */
public class Dispatcher {
    public static CalabashBoy.boy[] calabashBoys;
    public int[] xposition = new int[7];
    public int[] yposition = new int[7];

    public Dispatcher(int flag){
        if(flag == 0)
            calabashBoys = CalabashBoy.boy.values();
    }

    public void initPosition(PointNode[] calabashpos){
        Random y = new Random();
        Random x = new Random();
        int i = 0;
        int calabashCount = 0;
        while(calabashCount < 7) {
            this.xposition[i] = x.nextInt(7);
            this.yposition[i] = y.nextInt(15);
            boolean flag = false;
            for (int j = 0; j < i; j++) {
                if ((this.xposition[j] == this.xposition[i]) && (this.yposition[j] == this.yposition[i])) {
                    flag = true;
                    break;
                }
            }

            if (!flag) {
                calabashpos[calabashCount].xPoint = this.xposition[i];
                calabashpos[calabashCount].yPoint = this.yposition[i];
                calabashCount++;
                i++;
            }
        }

    }

    public void initMonsterPosition(PointNode[] monsterpos){
        Random x = new Random();
        Random y = new Random();

        int i = 0;
        int monsterCount = 0;
        while(monsterCount < 7){
            this.xposition[i] = x.nextInt(7) + 8;
            this.yposition[i] = y.nextInt(15);
            boolean flag = false;

            for (int j = 0; j < i; j++) {
                if ((this.xposition[j] == this.xposition[i]) && (this.yposition[j] == this.yposition[i])) {
                    flag = true;
                    break;
                }
            }

            if (!flag) {
                monsterpos[monsterCount].xPoint = this.xposition[i];
                monsterpos[monsterCount].yPoint = this.yposition[i];
                monsterCount++;
                i++;
            }
        }

    }
}
