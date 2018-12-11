import java.util.Random;

public class SortCalabashBrothers {
    public static void main(String[] args){
        CalabashBrothers[] queue=new CalabashBrothers[7];
        Coordinator coordinator=new Coordinator();
        RandomSort(queue);
        coordinator.commandSort(new BubbleSort(),queue);
        System.out.print("报数：");
        for (int i=0;i<queue.length;i++){
            queue[i].numberOffByName();
        }
        System.out.println();

        RandomSort(queue);
        System.out.print("报数：");
        coordinator.commandSort(new BinarySort(),queue);
        for (int i=0;i<queue.length;i++){
            queue[i].numberOffByColor();
        }
        System.out.println();
    }

    private static void RandomSort(CalabashBrothers[] queue) {
        Random random = new Random();
        int[] tag={0,0,0,0,0,0,0};
        int size=queue.length;
        int count=-1;
        while (count<6){
            int num=random.nextInt(size);
            if(tag[num]==0){
                count++;
                tag[num]=1;
                switch (num){
                    case 0:queue[count]=CalabashBrothers.First;break;
                    case 1:queue[count]=CalabashBrothers.Second;break;
                    case 2:queue[count]=CalabashBrothers.Third;break;
                    case 3:queue[count]=CalabashBrothers.Fourth;break;
                    case 4:queue[count]=CalabashBrothers.Fifth;break;
                    case 5:queue[count]=CalabashBrothers.Sixth;break;
                    case 6:queue[count]=CalabashBrothers.Seventh;break;
                }
            }
        }
        System.out.print("随机站队后的位置为：");
        for (int i=0;i<size;i++){
            queue[i].numberOffByName();
        }
        System.out.println();
    }
}
