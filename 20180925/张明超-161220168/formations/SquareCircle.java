package formations;

public class SquareCircle extends Formation{
    public SquareCircle(){
        type = FormationType.SQUARECIRCLE;
        height = 5;
        width = 5;
        cheerPos.set(2,2);
        posList = new Pos[8];
        for(int i = 0; i < posList.length; i++){
            posList[i] = new Pos();
        }
        posList[0].set(2,4);
        posList[1].set(2,0);
        posList[2].set(1,3);
        posList[3].set(1,1);
        posList[4].set(0,2);
        posList[5].set(3,1);
        posList[6].set(3,3);
        posList[7].set(4,2);
    }
}