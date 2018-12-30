package Huluwa;

public class QuickSorter implements Sorter {
    @Override
    public void sort(Queue queue,PROPERTY base){

        quickSort(queue,0,queue.getTotalPositionNum()-1,base);
    }

    private void quickSort(Queue queue,int beginPos,int endPos,PROPERTY base){
        if(beginPos < endPos)
        {
            int q = Partition(queue,beginPos,endPos,base);
            quickSort(queue,beginPos,q-1,base);
            quickSort(queue,q+1,endPos,base);
        }

    }

    int Partition(Queue queue,int beginPos,int endPos,PROPERTY base)
    {
        MBuilder builder = new M1DBuilder();
        int i = beginPos - 1;
        for(int j = beginPos;j < endPos;j++)
        {

            if(! ((Huluwa)queue.getPos(j).GetPeople()).biggerThan(((Huluwa)queue.getPos(endPos).GetPeople()),base))
            {
                i++;
                if(j != i) {

                    builder.swapTwoPosition(queue.getPos(j),queue.getPos(i));
                }
            }
        }

        if(i+1 != endPos)
            builder.swapTwoPosition(queue.getPos(i+1),queue.getPos(endPos));

        return i+1;
    }
}
