package sort;

public class sort_test 
{
		public static void main(String[] args) 
		{
			System.out.println("HELLO WORLD");
			int array[] = {1, 9, 3, 6, 7, 2};
			int max = 0;
			for(int j = 0;j < array.length; j++) 
			{
				max = j;
				for(int i = j; i < array.length; i++) 
				{
					if(array[i] > array[max])
						max = i;
				}
				int tmp = array[j];
				array[j] = array[max];
				array[max] = tmp;	
			}
			for(int i = 0; i< array.length; i++) 
			{
				System.out.print(" " + array[i]);
			}
			
        }
}
