package sample;

import creature.CalabashBrother;
import creature.Creature;
import field.BattleField;
import formation.*;

import java.util.Random;

public class Coordinator {
    public BattleField command(Creature[] creatures, Formation formation){
        BattleField battleField=formation.embattle(creatures);
        return battleField;
    }

    public void BubbleSort(CalabashBrother[] calabashBrothers) {  //冒泡排序
        for(int i=0;i<calabashBrothers.length-1;i++){
            for(int j=i+1;j<calabashBrothers.length;j++){
                if(calabashBrothers[i].getRank()>calabashBrothers[j].getRank()){
                    CalabashBrother temp=calabashBrothers[i];
                    calabashBrothers[i]=calabashBrothers[j];
                    calabashBrothers[j]=temp;
                }
            }
        }
    }


    public void RandomSort(CalabashBrother[] calabashBrothers) {  //随机排序
        Random random = new Random();
        int[] tag={0,0,0,0,0,0,0};
        int size=calabashBrothers.length;
        int count=-1;
        while (count<6){
            int num=random.nextInt(size);
            if(tag[num]==0){
                count++;
                tag[num]=1;
                calabashBrothers[count]=new CalabashBrother(num+1);
            }
        }
    }

    public Formation RandomFormation(int row, int column) {  //随机选取一个阵列
        Random random = new Random();
        int n=random.nextInt(7);
        switch (n){
            case 0:return new CraneWingArray(row,column);
            case 1:return new EnEchelonArray(row,column);
            case 2:return new BluntYokeArray(row,column);
            case 3:return new FishScaleArray(row,column);
            case 4:return new FangYuanArray(row,column);
            case 5:return new CrescentMoonArray(row,column);
            case 6:return new FengVectorArray(row,column);
        }
        return null;
    }
}
