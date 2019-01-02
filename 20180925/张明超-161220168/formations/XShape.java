package formations;

public class XShape extends Formation{
    public XShape(){
        type = FormationType.XSHAP;
        height = 8;
        width = 3;
        cheerPos.set(3,0);
        posList = new Pos[8];
        for(int i = 0; i < posList.length; i++){
            posList[i] = new Pos();
        }
        posList[0].set(3,1);
        posList[1].set(1,1);
        posList[2].set(2,2);
        posList[3].set(0,2);
        posList[4].set(4,2);
        posList[5].set(5,1);
        posList[6].set(6,2);
        posList[7].set(7,1);
    }
}