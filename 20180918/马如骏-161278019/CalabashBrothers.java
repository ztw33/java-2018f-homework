import java.util.Random;

public class CalabashBrothers {
    private final int MAX_CB_COUNT = 7;
    public CalabashBrother[] CalabashBrotherList = new CalabashBrother[MAX_CB_COUNT];
    private int[] RandomList = CreateRandomList();
    public CalabashBrothers(){
        for(int i=0;i<MAX_CB_COUNT;i++){
            CalabashBrotherList[i] = CalabashBrother.values()[RandomList[i] - 1];
            CalabashBrotherList[i].position = i;
        }
    }
    private int[] CreateRandomList(){
        int[] List = new int[MAX_CB_COUNT];
        Random rand = new Random();
        for(int i=0;i<List.length;i++){
            Boolean flag;
            int temp;
            do{
                temp = rand.nextInt(MAX_CB_COUNT)+1;
                flag = isInList(List, temp);
            }while(flag);
            List[i] = temp;
        }
        return List;
    }
    public static boolean isInList(int[] arr, int targetValue) {
        for(int i=0;i<arr.length;i++){
            if(targetValue == arr[i]){
                return true;
            }
        }
        return false;
    }
}
