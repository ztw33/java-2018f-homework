import java.util.ArrayList;

public class Coordinator {
    Map map;
    public Coordinator(int mapSize){
        map = new Map(mapSize);
    }

    private void gaming(){
        ArrayList<CalabashBros> calabashBros = new ArrayList<>();
        for(int i=0;i<7;i++)
            calabashBros.add(new CalabashBros(i));
        GrandFather grandFather = new GrandFather();
        Snake snake = new Snake();
        Scorpion scorpion = new Scorpion();
        ArrayList<Underling> underlings = new ArrayList<>();
        for(int i=0;i<7;i++)
            underlings.add(new Underling(i));
        ArrayList<Creature> goodGuysInFormation = new ArrayList<>();
        for(CalabashBros c : calabashBros){
            goodGuysInFormation.add(c);
        }
        ArrayList<Creature> badGuysInFormation = new ArrayList<>();
        badGuysInFormation.add(scorpion);
        for(Underling u : underlings){
            badGuysInFormation.add(u);
        }
        Formation.ChangShe(goodGuysInFormation, 8, 10, "Left", map);
        //grandFather.cheer
        this.setCheeringSquad(grandFather, map.getSize()/2-1, 0);
        Formation.YanYue(badGuysInFormation, 11, 10, "Right", map);
        //snake.cheer
        this.setCheeringSquad(snake, map.getSize()/2+1, map.getSize()-1);
        map.printWholeMap();
        System.out.println("******** Change the formation. ********");
        map.clearHalfMap("Right");
        Formation.FengShi(badGuysInFormation, 11, 10, "Right", map);
        //snake.cheer
        this.setCheeringSquad(snake, map.getSize()/2+1, map.getSize()-1);
        map.printWholeMap();
    }

    private <T extends Creature> void setCheeringSquad(T creature,int x,int y){
        map.setCreature(creature, x, y);
    }

    public static void main(String[] args){
        int mapSize = 20;
        Coordinator coordinator = new Coordinator(mapSize);
        coordinator.gaming();
    }
}
