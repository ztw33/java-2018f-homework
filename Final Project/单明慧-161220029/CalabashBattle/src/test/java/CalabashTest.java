import battlefield.BattleField;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestResult;
import junit.framework.TestSuite;
import main.*;
import spritecontroller.Creature;
import spritecontroller.Scorpion;
import spritecontroller.Underlyings;

import java.awt.*;

public class CalabashTest extends TestCase {

    public void test1()
    {
        BattleField bt = new BattleField();
        assert(bt.isEmpty(5, 5) == true);
        System.out.println("Test 1 Succeeds");
    }

    public void test2()
    {
        Creature c = new Creature();
        assert(c.getAtk() == 0);
        System.out.println("Test 2 Succeeds");
    }

    public void test3(){
        BattleField bt = new BattleField();
        Creature c = new Creature();
        c.setPos(5, 5);
        bt.standOn(c);
        assert(bt.isEmpty(5, 5) == false);
        System.out.println("Test 3 Succeeds");
    }
}
