package Huluwa;

public class BubbleSorter implements Sorter{
    @Override
    public void sort(Queue queue,PROPERTY base){

        MBuilder builder = new M1DBuilder();
        for(int i = 0; i < queue.getTotalPositionNum(); i++)
            for(int j = 0; j < queue.getTotalPositionNum() -1 - i; j++)
            {
                if(((Huluwa)queue.getPos(j).GetPeople()).biggerThan(((Huluwa)queue.getPos(j+1).GetPeople()),base))

                    builder.swapTwoPosition(queue.getPos(j),queue.getPos(j+1));
            }
    }
}
