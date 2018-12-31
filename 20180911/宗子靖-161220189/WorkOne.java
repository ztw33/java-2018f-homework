import java.util.Scanner;

public class WorkOne {
    public static void main(String args[]) {
        Arrays arr=new Arrays();
        arr.initial();
        arr.startQuickSort();
        arr.printArray();
    }
}
class Arrays {
    int nums[];
    int num;
    Arrays() {
        nums = null;
        num=0;
    }
    void initial() {
        Scanner scan = new Scanner(System.in);
        System.out.println("输入数组元素个数");
        num = scan.nextInt();
        nums = new int[num];
        System.out.println("输入数组");
        for (int i = 0; i < num; i++) {
            nums[i] = scan.nextInt();
        }
    }
    private void quickSort(int start, int anum) {
        if (anum <= 1)
            return;
        int i = 1, j = 1;
        while (j < anum) {
            if (nums[start] < nums[start+j]) {
                j++;
            } else {
                int temp = nums[start+i];
                nums[start+i] = nums[start+j];
                nums[start+j] = temp;
                i++;
                j++;
            }
        }
        int temp1 = nums[start];
        nums[start] = nums[start+i - 1];
        nums[start+i - 1] = temp1;
        quickSort(start, i-1);
        quickSort(i,anum-i);
    }
    void startQuickSort(){
        if(nums==null)
            return;
        quickSort(0,num);
    }
    void printArray(){
        System.out.println("数组：");
        for(int i=0;i<num;i++) {
            System.out.print(nums[i]+" ");
        }
        System.out.print("\n");
    }
}
