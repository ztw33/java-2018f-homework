package formations;

public class GeeseFlyShape extends Formation{
    public GeeseFlyShape(){
        type = FormationType.GEESEFLYSHAPE;
        height = 8;
        width = 8;
        cheerPos.set(3,1);
        posList = new Pos[8];
        for(int i = 0; i < posList.length; i++){
            posList[i] = new Pos();
        }
        posList[0].set(3,3);
        posList[1].set(0,0);
        posList[2].set(1,1);
        posList[3].set(2,2);
        posList[4].set(4,4);
        posList[5].set(5,5);
        posList[6].set(6,6);
        posList[7].set(7,7);
    }
}
