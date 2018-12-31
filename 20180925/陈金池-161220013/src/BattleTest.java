import com.cjinchi.battlefield.BattleField;
import com.cjinchi.creature.CalabashMan;
import com.cjinchi.creature.Creature;
import com.cjinchi.creature.GrandFather;
import com.cjinchi.creature.Minion;
import com.cjinchi.creature.ScorpionMan;
import com.cjinchi.creature.SnakeWoman;

public class BattleTest {

    public static void main(String[] args) {
        // Create a new battle field
        BattleField battleField = new BattleField();

        System.out.println("Round One:");
        // Get random calabash mans, then make them sorted
        CalabashMan[] calabashMans = CalabashMan.getRandomCalabashMans();
        CalabashMan.sortBySequence(calabashMans);
        Creature[] niceCreatures = calabashMans;
        // Go to side one of battle field, as Changshe
        battleField.setSideOneChangsheFormat(niceCreatures);
        battleField.setSideOneAudience(GrandFather.getInstance());
        // Get bad creatures,go to side two of battle field as Fangyuan
        Creature[] badCreatures = new Creature[BattleField.sideTwoCreatureNum];
        badCreatures[0] = ScorpionMan.getInstance();
        for (int i = 1; i < BattleField.sideTwoCreatureNum; i++) {
            badCreatures[i] = Minion.getInstance(i);
        }
        battleField.setSideTwoFangyuanFormat(badCreatures);
        battleField.setSideTwoAudience(SnakeWoman.getInstance());
        // Show battle
        battleField.show();
        System.out.println();

        System.out.println("Round Two:");
        // Bad creatures change their format
        battleField.removeSideTwoFangyuanFormat();
        battleField.setSideTwoFengshiFormat(badCreatures);
        battleField.show();
    }

}
