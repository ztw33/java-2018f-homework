import java.util.Random;

public class Snake extends Monster{
    private int[] midPoint;
    private Formation monFormation;
    public Snake() {
        name = "蛇精";
        monFormation = new Formation();
        midPoint = new int[2];
        midPoint[0] = -1;
        midPoint[1] = -1;
    }
    public void setMidPoint(int X, int Y) {
        midPoint[0] = X;
        midPoint[1] = Y;
    }
    public void chooseUnit(Ground space) {
        Random rand = new Random();
        int bound = space.showBound();
        int randX = -1;
        int randY = -1;
        do {
            randX = rand.nextInt(bound - midPoint[0] - 1) + midPoint[0];
            randY = rand.nextInt(bound);
        }while(!gotoPlace(space, randX, randY));
    }
    public void initializeFormation(int direction, Ground space, Creature[] creatures) {
        monFormation.SetCreature(creatures);
        monFormation.SetDirection(direction);
        monFormation.SetGound(space);
    }
    public void commandMonsters(FormationType type) {
        monFormation.SetFormation(type);
        monFormation.SetMidPoint(midPoint[0], midPoint[1]);
        monFormation.DealFormation();
    }
    public void waitNewLocation(Monster[] monsters, Ground space) {
        for(int i = 0; i < monsters.length; i++)
            monsters[i].leavePlace(space);
        leavePlace(space);
    }
}
