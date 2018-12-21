package EasySort;

import java.util.Scanner;

public class Sort {
    public static void main(String[] args){
         System.out.println("Please input a line of integer:");
         Scanner in=new Scanner(System.in);
         String inString=in.nextLine();              //获取一行输入
         String strArray[]=inString.split(" ");      //按空格划分字符串

         int n=strArray.length;
         int num[]=new int[n];
         for(int i=0;i<n;i++)
             num[i]=Integer.parseInt(strArray[i]);          //转化为整数存入数组num

         //下面开始对整数数组num进行排序，直接选择排序
        int min,temp;
        for(int i=0;i<n-1;i++){
            min=i;
            for(int j=i+1;j<n;j++) {
                if (num[j] < num[min])
                    min = j;
            }
            temp=num[i];
            num[i]=num[min];
            num[min]=temp;
        }

        //输出排序后的数组
        for(int i=0;i<n;i++)
            System.out.print(num[i]+" ");
    }
}
