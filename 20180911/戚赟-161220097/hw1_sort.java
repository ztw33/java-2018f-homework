package test;
import java.util.*;
public class  hw1_sort{
    public static void main(String []args)
    {
        hw1_sort hw = new hw1_sort();
        Scanner input = new Scanner(System.in);
        System.out.println("please input a non-empty string,divided by just one space");
        String temp = input.nextLine();
        //System.out.println(temp);
        if(temp == "")
        {
            System.out.println("输入为空，错误");
            return;
        }
        String []arry = temp.split(" +");
        int[] data = new int[arry.length];
        for (int i = 0; i < arry.length; i++) {
            data[i] = Integer.parseInt(arry[i]);
        }
        System.out.println("the input is");
        hw.print_out(data);
        hw.quick_sort(data,0,data.length-1);
        System.out.println("the output is");
        hw.print_out(data);
    }

    public void print_out(int []data)
    {
        //System.out.print(data.length+"\n");
        for(int i = 0; i < data.length; i++)
        {
            System.out.print(data[i]+" ");
        }
        System.out.print("\n");
    }
    public void quick_sort(int []data,int left,int right)
    {
        if(left >= right) return;
        int div = left;
        int div_element = data[left];
        div++;
        for(int i = left+1; i <= right; i++)
        {
            if (data[i] < div_element) {
                int temp = data[i];
                data[i] = data[div];
                data[div] = temp;
                div++;
            }
        }
        div--;
        data[left] = data[div];
        data[div] = div_element;
        quick_sort(data,left,div-1);
        quick_sort(data,div+1,right);
    }
}
