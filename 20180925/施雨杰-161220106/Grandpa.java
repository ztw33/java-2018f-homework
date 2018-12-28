import java.util.Random;

public class Grandpa extends Creature{
    private int[] midPoint;
    private Formation HuluFormation;
    public Grandpa() {
        name = "爷爷";
        midPoint = new int[2];
        midPoint[0] = -1;
        midPoint[1] = -1;
        HuluFormation = new Formation();
    }
    public void standInLine(HuluWa[] brothers) {
        Random rand  = new Random();
        int lengh = brothers.length;
        for (int i = 0; i < lengh; i++) {
            int pos = rand.nextInt(lengh - i);
            HuluWa temp = brothers[pos];
            brothers[pos] = brothers[lengh-1-i];
            brothers[lengh-1-i] = temp;
        }
    }
    public void standByOrder(HuluWa[] brothers) {
        Sort mySort = new BubbleSort(brothers);
        mySort.sort();
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
            randX = rand.nextInt(midPoint[0]);
            randY = rand.nextInt(bound);
        }while(!gotoPlace(space, randX, randY));
    }
    public void initializeFormation(int direction, Ground space, Creature[] creatures) {
        HuluFormation.SetCreature(creatures);
        HuluFormation.SetDirection(direction);
        HuluFormation.SetGound(space);
    }
    public void commandHuluWa(FormationType type) {
        HuluFormation.SetFormation(type);
        HuluFormation.SetMidPoint(midPoint[0], midPoint[1]);
        HuluFormation.DealFormation();
    }
    public void waitNewLocation(HuluWa[] creatures, Ground space) {
        for(int i = 0; i < creatures.length; i++) {
            creatures[i].leavePlace(space);
            leavePlace(space);
        }
    }
}