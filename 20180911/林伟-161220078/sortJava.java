package sort;

import java.util.Scanner;

public class sort {
	
	public static void swap(int[] array,int i,int j)
	{
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}//swap array[i] and array[j]
	
	public static void sortTheArray(int[] array,int i,int j)//quick sort
	{
		int tempi = i;
		int tempj = j;
		if(i >= j)
			return;
		int key = array[i];
		boolean turn = true;
		while(i != j)
		{
			if(turn)
			{
				if(array[j] < key)
					{
						swap(array,i,j);
						turn = false;
						//j--;
					}
				else j--;
			}
			else
			{
				if(array[i] > key)
				{
					swap(array,i,j);
					turn = true;
					//i++;
				}
				else i++;
			}
		}
		sortTheArray(array,tempi,i-1);
		sortTheArray(array,i + 1,tempj);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = new int[100];
		Scanner sourceIn = new Scanner(System.in);
		int tempData = sourceIn.nextInt();
		int numberOfArray = 0;
		for(;tempData != -1;numberOfArray++)// end with -1
		{
			if(numberOfArray >= 100)
				{System.out.println("error: out of the space!\n");return;}
			array[numberOfArray] = tempData;
			tempData = sourceIn.nextInt();
		}
		sortTheArray(array,0,numberOfArray-1);
		for(int i = 0;i < numberOfArray;i++)
			System.out.println(array[i] + " ");//print the array
	}

}
