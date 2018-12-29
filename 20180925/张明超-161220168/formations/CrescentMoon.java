package formations;

public class CrescentMoon extends Formation{
    public CrescentMoon(){
        type = FormationType.CRESCENTMOON;
        height = 6;
        width = 4;
        cheerPos.set(3,0);
        posList = new Pos[8];
        for(int i = 0; i < posList.length; i++){
            posList[i] = new Pos();
        }
        posList[0].set(2,3);
        posList[1].set(2,1);
        posList[2].set(1,2);
        posList[3].set(0,3);
        posList[4].set(5,3);
        posList[5].set(4,2);
        posList[6].set(3,1);
        posList[7].set(3,3);
    }
}
