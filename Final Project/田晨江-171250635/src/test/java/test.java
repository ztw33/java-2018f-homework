import creature.BadCreature.LittleGuys;
import creature.Creature;
import creature.GoodCreature.*;
import creature.GoodCreature.CalabashBrothers;
import formation.Queue;
import org.junit.*;
import world.BattleField;

import javax.naming.Name;
import java.lang.annotation.Native;

import static org.junit.Assert.assertEquals;


public class test {
    @Test
    public void testCB() {
        BattleField battleField = new BattleField(15,15);
        Queue brotherQueue = new Queue(new CalabashBrothers().initialCB());
        Queue lGuysQueue = new Queue(new LittleGuys().initialGuys());
        assertEquals(brotherQueue.getList().get(0).getClass(), new CalabashBrothers(NAME.大娃,SENIORITY.一, COLOR.赤).getClass());
        assertEquals(lGuysQueue.getList().get(0).getClass(), new LittleGuys().getClass());
    }


}
