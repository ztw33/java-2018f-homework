import org.junit.Test;
import static org.junit.Assert.*;

public class TestUnit {
    @Test
    public void testChangePos()throws Exception{
        Being being=new Being("a",0);
        being.changePos(10,20);
        assertEquals(10,being.getPos().getX());
        assertEquals(20,being.getPos().getY());
    }
    @Test
    public void testBubbleSort()throws Exception{
        CalabashBros bros=new CalabashBros();
        bros.reArrange(false);
        bros.bubbleSort(false);
        assertTrue(bros.getCalabashKid(0).getName().equalsIgnoreCase("大娃"));
        assertTrue(bros.getCalabashKid(1).getName().equalsIgnoreCase("二娃"));
        assertTrue(bros.getCalabashKid(2).getName().equalsIgnoreCase("三娃"));
        assertTrue(bros.getCalabashKid(3).getName().equalsIgnoreCase("四娃"));
        assertTrue(bros.getCalabashKid(4).getName().equalsIgnoreCase("五娃"));
        assertTrue(bros.getCalabashKid(5).getName().equalsIgnoreCase("六娃"));
        assertTrue(bros.getCalabashKid(6).getName().equalsIgnoreCase("七娃"));
    }
    @Test
    public void testAddPosWithChange()throws Exception{
        Position pos=new Position(10,20);
        Position npos=new Position(20,30);
        Position nnpos=pos.addPosWithChange(npos);
        assertEquals(30,pos.getX());
        assertEquals(50,pos.getY());
        assertEquals(30,nnpos.getX());
        assertEquals(50,nnpos.getY());
    }
    @Test
    public void testAddPosWithoutChange()throws Exception{
        Position pos=new Position(10,20);
        Position npos=new Position(20,30);
        Position nnpos=pos.addPosWithoutChange(npos);
        assertEquals(10,pos.getX());
        assertEquals(20,pos.getY());
        assertEquals(30,nnpos.getX());
        assertEquals(50,nnpos.getY());
    }
    @Test
    public void testOverZeroPoint()throws Exception{
        Position pos0=new Position(1,1);
        Position pos1=new Position(1,-1);
        Position pos2=new Position(-1,-1);
        Position pos3=new Position(-1,1);
        Position pos4=new Position(0,0);
        assertTrue(pos0.overZeroPoint());
        assertFalse(pos1.overZeroPoint());
        assertFalse(pos2.overZeroPoint());
        assertFalse(pos3.overZeroPoint());
        assertFalse(pos4.overZeroPoint());
    }
    @Test
    public void testOneStepClose()throws Exception{
        Position pos0=new Position(10,10);
        Position pos1=new Position(10,11);
        Position pos2=new Position(8,10);
        Position pos3=new Position(9,10);
        Position pos4=new Position(10,20);
        assertTrue(Position.oneStepClose(pos0,pos1));
        assertTrue(Position.oneStepClose(pos0,pos3));
        assertFalse(Position.oneStepClose(pos0,pos2));
        assertFalse(Position.oneStepClose(pos0,pos4));
        assertTrue(Position.oneStepClose(pos2,pos3));
    }
    @Test
    public void testDistance()throws Exception{
        Position pos0=new Position(10,10);
        Position pos1=new Position(10,11);
        Position pos2=new Position(8,10);
        Position pos3=new Position(9,10);
        Position pos4=new Position(10,20);
        assertEquals(Position.distance(pos0,pos1),1);
        assertEquals(Position.distance(pos1,pos2),3);
        assertEquals(Position.distance(pos4,pos1),9);
        assertEquals(Position.distance(pos2,pos4),12);
    }
    @Test
    public void testFormation()throws Exception{
        assertEquals(Formation.ARROW.getUnitNum(),9);
        assertEquals(Formation.CRESCENT.getUnitNum(),7);
        assertEquals(Formation.SQUARE.getUnitNum(),8);
        assertEquals(Formation.FISHSCALE.getUnitNum(),12);
    }
}
