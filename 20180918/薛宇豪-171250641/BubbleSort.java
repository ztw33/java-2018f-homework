public class BubbleSort implements SortSet {
    public void sort(Coordinator coordinator, CalabashBrothers[] queue){
        for(int i=0;i<queue.length-1;i++){
            for(int j=i+1;j<queue.length;j++){
                if(queue[i].compareTo(queue[j])>0){
                    int start=j+1;
                    int end=i+1;
                    queue[j].tellTheMove(start,end);

                    CalabashBrothers temp=queue[i];
                    coordinator.tell(queue,queue[j],i);
                    coordinator.tell(queue,temp,j);
                }
            }
        }
    }
}
