package Huluwa;

public class M1DBuilder implements MBuilder {

    @Override
    public void buildSpaceInOrder(Space space,Creature []creatures){
       Queue queue = (Queue)space;
       for(int i = 0; i < creatures.length;i++)
       {
           if (i < space.getTotalPositionNum()) {
               if (creatures[i].getPosition() != null)
                   creatures[i].getPosition().LetPeopleLeave();

               queue.getPos(i).LetPeopleLeave();
               queue.getPos(i).SetPeople(creatures[i]);
           }
           else break;
       }
    }

    @Override
    public void randomBuild(Space space,Creature []creatures)
    {
        Queue queue = (Queue)space;

        for(int i = 0; i<creatures.length;i++){
            MPoint1D tempPoint = MPoint1D.getRandom(queue.getTotalPositionNum());

            while(!space.getPosition(tempPoint).isEmpty()){
                tempPoint = MPoint1D.getRandom(queue.getTotalPositionNum());
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
        pos1.SetPeople(temp2);
        pos2.SetPeople(temp);

        temp.report();
        System.out.print(pos1.getPoint().toString()+" -> " + pos2.getPoint().toString());
        System.out.println();

        temp2.report();
        System.out.print(pos2.getPoint().toString()+" -> " + pos1.getPoint().toString());
        System.out.println();
    }

    @Override
    public void clearPos(Space space){
        Queue queue = (Queue)space;
        for(int i = 0; i < queue.getTotalPositionNum(); i++)
        {
            queue.getPos(i).LetPeopleLeave();
        }
    }

    @Override
    public void buildSpaceInForamtion(MFormation formation,Space space,Creature []creatures){
        return;
    }



}
