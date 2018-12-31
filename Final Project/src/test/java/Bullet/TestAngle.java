package Bullet;

import org.junit.Test;

import static org.junit.Assert.*;

public class TestAngle {
    @Test
    public void testAngle(){
        double sin = 1;
        double angle = Math.asin(sin);
        double res = angle*180/Math.PI;
        double sin2 = -0.9;
        double angle2 = Math.asin(sin2);
        double res2 = angle2*180/Math.PI;
        //assertEquals(res,res2);
        System.out.println(res);
        System.out.println(res2);
    }
}