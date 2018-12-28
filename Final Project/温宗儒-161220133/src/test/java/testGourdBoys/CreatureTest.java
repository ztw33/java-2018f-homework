package testGourdBoys;

import backstage.battleGround.Space;
import backstage.creature.battle.FirstChild;
import backstage.creature.battle.Minions;
import backstage.creature.battle.Scorpion;
import backstage.creature.fighter.minions.Minion;
import controller.Controller;
import javafx.embed.swing.JFXPanel;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.swing.*;

/**
 * @program: gourdBoys
 * @description: test for gourdBoys
 * @auther: Wen Zongru
 * @create: 2018-12-28
 **/
public class CreatureTest {
    @BeforeClass
    public static void before(){
        new JFXPanel();
    }
    @Test
    public void firstChildTest(){
        FirstChild firstChild = new FirstChild();
        firstChild.beAttacked(2300);
        Assert.assertTrue(firstChild.notDead());
        firstChild.beAttacked(170);
        Assert.assertFalse(firstChild.notDead());
    }

    @Test
    public void scorpionTest() {
        Scorpion scorpion = new Scorpion();
        scorpion.beAttacked(1700);
        Assert.assertTrue(scorpion.notDead());
        scorpion.beAttacked(150);
        Assert.assertFalse(scorpion.notDead());

        Assert.assertFalse(Space.isSoloEnd());
    }
    @Test
    public void minionsTest() {
        Minions minions = new Minions(50,50,50);
        minions.getBat().beAttacked(9999);
        Assert.assertTrue(minions.getBat().getNumber() <= 0);

        minions.getCentipede().beAttacked(9999);
        Assert.assertTrue(minions.getCentipede().getNumber() <= 0);

        minions.getToad().beAttacked(9999);
        Assert.assertTrue(minions.getToad().getNumber() <= 0);
    }

}
