import java.util.*;
public class ArraySort {
    public static void main(String[] args){
        int Array[]=new int[6];
        int len=Array.length;
        System.out.print("请输入6个整数：");
        //读取整数
        Scanner sc=new Scanner(System.in);
        for(int i=0;i<len;i++)
        {
            Array[i]=sc.nextInt();
        }
        //排序(从小到大冒泡）
        int temp;
         for(int i=0;i<len-1;i++)
         {
             for(int j=i+1;j<len;j++)
             {
                 if(Array[i]>Array[j]){
                     temp=Array[i];
                     Array[i]=Array[j];
                     Array[j]=temp;
                 }
             }
         }
         //输出排序后的数组
        System.out.print("排序后的数组是：");
        for(int i=0; i<len; i++){
            System.out.print(Array[i] + " ");
        }
    }
}
