package Huluwa;

public class Queue implements Space{
    //一个一维空间
    private int totalPositionNum;

    private Position []pos;//每个位置也是一个对象,队列管理这些位置

    public Queue(int positionNum) {
        totalPositionNum = positionNum;
        pos = new Position[totalPositionNum];
        for(int i = 0;i < positionNum;i++){
            MPoint1D point = new MPoint1D(i);
            pos[i] = new Position(point);

        }
    }

    @Override
    public Position getPosition(MPoint point) {
        int x = ((MPoint1D)point).getX();
        if(x >= 0 && x < totalPositionNum)
            return pos[x];
        else return null;
    }

    public Position getPosition(int x){
        if(x >= 0 && x < totalPositionNum)
            return pos[x];
        else return null;
    }

    @Override
    public void show() {
        for (int i = 0; i < totalPositionNum; i++) {
            if(pos[i].isEmpty())
                System.out.print("\t");
            else pos[i].GetPeople().report();
        }
        System.out.println();
    }

    public void showName(){
       show();
    }

    public void showColor(){
        for (int i = 0; i < totalPositionNum; i++) {
            if(pos[i].isEmpty())
                System.out.print("\t");
            else ((Huluwa)pos[i].GetPeople()).reportColor();
        }
        System.out.println();

    }

    @Override
    public int getTotalPositionNum(){
        return this.totalPositionNum;
    }


    public Position getPos(int x){
        return pos[x];
    }

}
