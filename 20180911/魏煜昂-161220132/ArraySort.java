public class ArraySort {
    public static void main(String[] args){
        int Array[]={5,-1,3,7,1,9,0,7,4,-6};
        int temp=0;
        for (int i=0;i<9;i++) {
            for (int j = 0; j < 9 - i; j++) {
                if (Array[j] > Array[j + 1]) {
                    temp = Array[j];
                    Array[j] = Array[j + 1];
                    Array[j + 1] = temp;
                }
            }
        }
        for (int i=0;i<10;i++)
            System.out.print(Array[i]+" ");
    }
}