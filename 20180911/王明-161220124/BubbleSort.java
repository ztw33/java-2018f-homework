package sort_number;

import java.util.*;
import java.io.*;

public class BubbleSort {
	private int numbers;                  //整数个数
	private int[] num_array;              //存放整数的数组
	
	BubbleSort()                          //初始化numbers
	{
		numbers = 0;
	}
	
	public void input_data() throws IOException   //手动输入个数和整数的值
	{
		Scanner in = new Scanner(System.in);
		numbers = in.nextInt();
		num_array = new int[numbers];
		for(int i = 0; i < numbers; i++)
		{
			num_array[i] = in.nextInt();
		}
		in.close();
	}
	
	public void output_data()                    //输出数组
	{
		for(int i = 0; i < numbers; i++)
			System.out.print(num_array[i] + " ");
		System.out.println();
	}
	
	public void sort_data()                      //冒泡排序
	{
		for(int i = 0; i < numbers - 1; i++)
		{
			for(int j = 0; j < numbers - i - 1; j++)
			{
				if(num_array[j] > num_array[j + 1])
				{
					int replace = num_array[j];
					num_array[j] = num_array[j + 1];
					num_array[j + 1] = replace;
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException 
	{    
		BubbleSort firstcrab = new BubbleSort();
		firstcrab.input_data();
		firstcrab.sort_data();
		firstcrab.output_data();
	}
}
