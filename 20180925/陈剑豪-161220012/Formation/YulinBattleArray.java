package Formation;
import Creature.*;
/**
 * @ Author     ：cjh
 * @ Description：鱼鳞阵
 */
public class YulinBattleArray<T extends Creature> {
    public void form(T scorpionMonster,T[] underlings,int row,int column) {
        scorpionMonster.standOnMap(row, column);
        int temp = 1;
        for (int k = 0; k < underlings.length - 1; k++) {
            if (k == (temp * temp)) {
                temp += 1;
            }
            if (k < temp * temp) {
                underlings[k].standOnMap(row + (k - (temp - 1) * (temp - 1)) - temp + 1, column + temp);

            }
            //System.out.println(k);

        }
        underlings[underlings.length - 1].standOnMap(row, column + temp + 1);
    }
}
