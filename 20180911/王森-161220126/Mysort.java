public class Mysort {
    static int []arr = {10,5,8,2,1,3,6,4,9,7};
    public static void MyBubbleSort () {
        System.out.print("排序前：");
        for (int i = 0;i < 10; i++) {
            if (i != 0)
                System.out.print(" ");
            System.out.print(arr[i]);
        }
        System.out.print("\n");
        int temp = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.print("排序后：");
        for (int i = 0;i < 10; i++) {
            if (i != 0)
                System.out.print(" ");
            System.out.print(arr[i]);
        }
        System.out.print("\n");
    }
    public static void main(String[] args){
        Mysort A = new Mysort();
        A.MyBubbleSort();
    }
}
