import java.util.ArrayList;
import java.util.List;

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

        // Get random Calabash mans, then make them sorted
        List<CalabashMan> calabashMans = CalabashMan.getRandomCalabashMans();
        CalabashMan.sortBySequence(calabashMans);
        List<Creature> niceCreatures = new ArrayList<>();
        for (int i = 0; i < calabashMans.size(); i++) {
            niceCreatures.add(calabashMans.get(i));
        }
        // Get bad creatures
        List<Creature> badCreatures = new ArrayList<>();
        badCreatures.add(ScorpionMan.getInstance());
        for (int i = 1; i < BattleField.sideTwoCreatureNum; i++) {
            badCreatures.add(Minion.getInstance(i));
        }

        System.out.println("Round One:");
        // Go to side one of battle field, as Changshe
        battleField.setSideOneChangsheFormat(niceCreatures);
        battleField.setSideOneAudience(GrandFather.getInstance());
        // Go to side two of battle field, as Fangyuan
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
