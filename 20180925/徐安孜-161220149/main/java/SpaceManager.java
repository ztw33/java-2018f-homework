package main.java;
import javax.swing.text.html.ImageView;
import java.util.ArrayList;



public class SpaceManager {

    void placeCreature(Space bf, Creature c, int x, int y){
        c.Location.x=x;
        c.Location.y=y;
        bf.creatureEnterSpace(c,x,y);
    }
    void removeCreature(Space bf, Creature c){
        if(c==null)return;
        bf.creatureLeaveSpace(c.Location.x,c.Location.y);
        c.Location.x=-1;
        c.Location.y=-1;
    }
    void removeCreature(Space bf, ArrayList<Creature> c){
        for(int i=0;i<c.size();i++) {
            bf.creatureLeaveSpace(c.get(i).Location.x, c.get(i).Location.y);
            c.get(i).Location.x = -1;
            c.get(i).Location.y = -1;
        }
    }
    void placeFormation(Space bf, Formation f, ArrayList<Creature>members,int x, int y) {
        //(x,y)is the coordinate of the upper-left corner of the formation
        for(int i=0;i<members.size();i++)
            placeCreature(bf,members.get(i),x+f.pattern.get(i).x,y+f.pattern.get(i).y);
    }


}