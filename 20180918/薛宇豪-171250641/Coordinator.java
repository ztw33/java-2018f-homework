public class Coordinator {
    public void commandSort(SortSet sortSet, CalabashBrothers[] queue){
        sortSet.sort(this,queue);
    }

    public void tell(CalabashBrothers[] queue, CalabashBrothers c,int destination){
        c.move(queue,destination);
    }
}
