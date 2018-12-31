package formations;

public class CraneWing extends Formation{
    public CraneWing(){
        type = FormationType.CRANEWING;
        height = 8;
        width = 6;
        cheerPos.set(3,0);
        posList = new Pos[8];
        for(int i = 0; i < posList.length; i++){
            posList[i] = new Pos();
        }
        posList[0].set(3,1);
        posList[1].set(2,2);
        posList[2].set(1,3);
        posList[3].set(0,4);
        posList[4].set(4,2);
        posList[5].set(5,3);
        posList[6].set(6,4);
        posList[7].set(7,5);
    }
}



