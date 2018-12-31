public class Leader extends Creature{
    Leader(){
        this.number=9;
        this.x=this.y=0;
        this.name="蝎精";
        this.type=CreatureType.LEADER;
    }
    Leader(int x,int y){
        this.number=9;
        this.x=x;
        this.y=y;
        this.name="蝎精";
        this.type=CreatureType.LEADER;
    }
}
