package Bullet;

import org.junit.Test;

import static org.junit.Assert.*;

public class BulletTest {

    @Test
    public void getDistance() {
        double x1 = 0;
        double y1 = 0;
        double x2 = 3;
        double y2 = 4;
        double res = Bullet.getDistance(x1,y1,x2,y2);
        assertEquals((int)res,5);
    }
}