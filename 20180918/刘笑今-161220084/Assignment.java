import java.util.*;

public class Assignment {
    public static void main(String[] args){
        //Use this array to refer enum objects.
        CalabashBro[] queue={CalabashBro.FIRST, CalabashBro.SECOND, CalabashBro.THIRD, CalabashBro.FOURTH, CalabashBro.FIFTH, CalabashBro.SIXTH, CalabashBro.SEVENTH};

        //"array" stores the index of objects in "queue", which is in corresponding location.
        int[] array={1,2,3,4,5,6,7};
        //Randomize their location
        array=Shuffle.shuffleArray(array);
        //Output, to show their original location
        for(int i=0;i<7;i++){
            System.out.print(array[i]+" ");
        }
        System.out.println("");
        //Everybody gets to their own location.(from owning no location, to OWNING a location)
        for(int i=0;i<array.length;i++) {
            queue[array[i]-1].changeLocation(i+1);
        }

        //Bubble Sort
        for(int i=0;i<array.length;i++){
            for(int j=1;j<array.length-i;j++){
                if(!queue[array[j]-1].comparePriority(queue[array[j-1]-1])){
                    int templocation=queue[array[j]-1].getLocation();
                    queue[array[j]-1].changeLocation(queue[array[j-1]-1].getLocation());
                    queue[array[j-1]-1].changeLocation(templocation);
                    //System.out.println("");
                    int tmp=array[j];
                    array[j]=array[j-1];
                    array[j-1]=tmp;
                }
            }
        }
        //Report their colors
        for(int i=0;i<array.length;i++){
            queue[array[i]-1].reportColor();
        }
        System.out.println("\n");


        //Back to the situation where after initialization
        for(int i=0;i<queue.length;i++){
            queue[i].changeLocation(-1);
        }
        //Randomize their location again.
        array=Shuffle.shuffleArray(array);
        //Output, to show their original location
        for(int i=0;i<7;i++){
            System.out.print(array[i]+" ");
        }
        System.out.println("");
        //Everybody gets to their own location.(from owning no location, to OWNING a location)
        for(int i=0;i<array.length;i++) {
            queue[array[i]-1].changeLocation(i+1);
        }

        //Partition-Insertion Sort
        for(int i=1;i<array.length;i++){
            int begin=0, end=i-1;
            while(begin<=end){
                int half=(begin+end)/2;
                if(queue[array[i]-1].comparePriority(queue[array[half]-1])){
                    begin=half+1;
                }
                else{
                    end=half-1;
                }
            }
            int curbroindex=array[i];
            for(int j=i;j>begin;j--){
                queue[array[j-1]-1].changeLocation(queue[array[j-1]-1].getLocation()+1);
                array[j]=array[j-1];
            }
            queue[curbroindex-1].changeLocation(begin+1);
            array[begin]=curbroindex;
        }
        //Report their colors
        for(int i=0;i<array.length;i++){
            queue[array[i]-1].reportColor();
        }
        System.out.println("\n");
    }
}
