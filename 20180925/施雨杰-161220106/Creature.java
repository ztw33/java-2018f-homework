public class Creature {
    protected String name;
    private int locationX;
    private int locationY;
    public Creature() {
        name = "unknown";
        locationX = -1;
        locationY = -1;
    }
    public Creature(String creatureName) {
        name = creatureName;
        locationX = -1;
        locationY = -1;
    }
    public void tellMyName() {
        System.out.print(name);
    }
    public boolean gotoPlace(Ground space, int X, int Y) {
        if(space.isEmpty(X,Y)) {
            space.leaveUnit(locationX, locationY);
            locationX = X;
            locationY = Y;
            space.gotoUnit(X,Y,this);
            return true;
        }
        else {
            //System.out.println("error");
            return false;
        }
    }
    public void leavePlace(Ground space) {
        if(space.testBound(locationX, locationY)) {
            space.leaveUnit(locationX, locationY);
            locationX = -1;
            locationY = -1;
        }
    }
}
class Monster extends Creature {
    public Monster() {
        name = "妖怪";
    }
}
class LittleMonster extends Monster{
    public LittleMonster() {
        name = "喽啰";
    }
}
class Scorpio extends Monster{
    public Scorpio() {
        name = "蝎精";
    }
}


