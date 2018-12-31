package Huluwa;

public class M2DBuilder implements MBuilder {

    @Override
    public void buildSpaceInOrder(Space space,Creature []creatures){
        Matrix2D matrix = (Matrix2D)space;

        for(int i = 0;i < creatures.length; i++) {
            if (i < space.getTotalPositionNum()) {
                if (creatures[i].getPosition() != null)
                    creatures[i].getPosition().LetPeopleLeave();

                matrix.getPoisition(i / matrix.getWidth(), i % matrix.getWidth()).LetPeopleLeave();
                matrix.getPoisition(i / matrix.getWidth(), i % matrix.getWidth()).SetPeople(creatures[i]);
            }
            else break;
        }
    }

    @Override
    public void buildSpaceInForamtion(MFormation formation,Space space,Creature []creatures){
        MPoint2D []pointset = (MPoint2D[])formation.getAllPoint();
        for(int i = 0;i < creatures.length;i++)
        {
            if(i < pointset.length && i < space.getTotalPositionNum()) {
                if(creatures[i].getPosition()!=null) {
                    creatures[i].getPosition().LetPeopleLeave();
                }
                space.getPosition(pointset[i]).LetPeopleLeave();
                space.getPosition(pointset[i]).SetPeople(creatures[i]);

            }
            else break;
        }
    }

    @Override
    public void randomBuild(Space space,Creature []creatures)
    {
        Matrix2D matrix = (Matrix2D)space;
        for(int i = 0; i<creatures.length;i++){
            MPoint2D tempPoint = MPoint2D.getRandom(matrix.getLength()+1,matrix.getWidth()+1);
            while(!space.getPosition(tempPoint).isEmpty()){
                tempPoint = MPoint2D.getRandom(matrix.getLength()+1,matrix.getWidth()+1);
            }
            space.getPosition(tempPoint).SetPeople(creatures[i]);
        }
    }

    @Override
    public void swapTwoPosition(Position pos1,Position pos2){
        Creature temp = pos1.GetPeople();
        Creature temp2 = pos2.GetPeople();
        pos1.LetPeopleLeave();
        pos2.LetPeopleLeave();
        pos1.SetPeople(temp);
        pos2.SetPeople(temp2);

        temp.report();
        System.out.print(pos1.getPoint().toString()+" -> " + pos2.getPoint().toString());
        temp2.report();
        System.out.print(pos2.getPoint().toString()+" -> " + pos1.getPoint().toString());
    }

    @Override
    public void clearPos(Space space){
        Matrix2D matrix = (Matrix2D)space;
        for(int i = 0;i < matrix.getLength();i++)
            for(int j = 0; j < matrix.getWidth();j++)
            {
                matrix.getPoisition(i,j).LetPeopleLeave();
            }
    }
}
