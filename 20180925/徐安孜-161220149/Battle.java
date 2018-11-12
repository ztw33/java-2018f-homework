
import java.util.*;

public class Battle{
    public static void main(String[] args){
        Space battlefield = new Space(20,20);
        Manipulator god = new Manipulator();

        //create and place calabash brothers
        ArrayList<Creature> CalabashBrothers = new ArrayList<>();
        CalabashBrothers.add(new Calabash(CalabashRank.FIRST));
        CalabashBrothers.add(new Calabash(CalabashRank.SECOND));
        CalabashBrothers.add(new Calabash(CalabashRank.THIRD));
        CalabashBrothers.add(new Calabash(CalabashRank.FORTH));
        CalabashBrothers.add(new Calabash(CalabashRank.FIFTH));
        CalabashBrothers.add(new Calabash(CalabashRank.SIXTH));
        CalabashBrothers.add(new Calabash(CalabashRank.SEVENTH));
        god.placeFormation(battlefield,new SnakeFormation(CalabashBrothers.size()),CalabashBrothers,4,3);

        //create and place grandpa&snake
        GoodBoss grandpa = new GoodBoss('爷');
        BadBoss snake= new BadBoss('蛇');
        god.placeCreature(battlefield,grandpa,7,1);
        god .placeCreature(battlefield,snake,3,18);

        //create and place monsters
        ArrayList<Creature> ScorpionSquad = new ArrayList<>();
        ScorpionSquad.add(new Scorpion('蝎'));
        for(int i=0;i<8;i++)
            ScorpionSquad.add(new LittleMonster('喽'));
        god.placeFormation(battlefield,new WingFormation(ScorpionSquad.size()),ScorpionSquad,5,10);
        battlefield.display();

        //changer the formation of monsters
        god.removeCreature(battlefield,ScorpionSquad);
        ScorpionSquad.add(new LittleMonster('喽'));
        ScorpionSquad.add(new LittleMonster('喽'));
        god.placeFormation(battlefield,new GeeseFormation(ScorpionSquad.size()),ScorpionSquad,5,7);
        battlefield.display();
    }
}
