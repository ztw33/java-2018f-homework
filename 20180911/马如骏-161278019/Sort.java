import java.util.Scanner;
public class Sort {
    /** 冒泡排序 */
    public static void bubbleSort(int[] list, int flag) {
        int temp = 0;
        int length = list.length;
        if(flag == 1) {
            for(int i = 0;i< length-1; i++){
                for(int j = 0; j< length-1-i;j++){
                    if(list[j] > list[j+1]){
                        temp = list[j];
                        list[j] = list[j+1];
                        list[j+1] = temp;
                    }
                }
            }
        } else {
            for(int i = 0;i< length-1; i++){
                for(int j = 0; j< length-1-i;j++){
                    if(list[j] < list[j+1]){
                        temp = list[j];
                        list[j] = list[j+1];
                        list[j+1] = temp;
                    }
                }
            }
        }
        System.out.println("排序结果：");
        for(int i=0; i<length; i++){
            System.out.print(list[i] + " ");
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入数组长度:");
        int length = scanner.nextInt();
        int list[] = new int[length];
        System.out.println("请输入数组:");
        for(int i=0; i<length; i++) {
            list[i] = scanner.nextInt();
        }
        int flag = 0;
        do{
            System.out.println("递增排序请输入1，递减排序请输入2:");
            flag = scanner.nextInt();
            if(!(flag==1 || flag==2)) {
                System.out.println("输入错误，请重新输入！");
            }
        }while(!(flag==1 || flag==2));
        scanner.close();
        Sort.bubbleSort(list, flag);
    }
}