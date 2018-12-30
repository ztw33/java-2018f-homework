package sample;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

//@RunWith(Arquillian.class)
public class CreatureTest {

    @Test
    public void testGetCor_x() {
        Creature creature = new Creature();
        int x = creature.getCor_x();
        assertTrue(x >=0 && x <= 7);
    }

    @Test
    public void testGetCor_y(){
        Creature creature = new Creature();
        int y = creature.getCor_y();
        assertTrue(y >=0 && y <= 7);
    }
}
