public class BinarySort implements SortSet {
    public void sort(Coordinator coordinator, CalabashBrothers[] queue){
        for(int i=1;i<queue.length;i++) {
            CalabashBrothers temp=queue[i];
            int low=0;
            int high=i-1;
            while(low<=high){
                int mid=(low+high)/ 2;
                if(queue[mid].compareTo(temp)>0){
                    high=mid-1;
                }else{
                    low=mid+1;
                }
            }
            for(int j=i-1;j>high;j--) {
                int start=j+1;
                int end=j+2;
                queue[j].tellTheMove(start,end);

                coordinator.tell(queue,queue[j],j+1);
            }
            coordinator.tell(queue,temp,high+1);
        }
    }
}
