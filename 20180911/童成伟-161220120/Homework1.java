package homework1≈≈–Ú;

public class Homework1 {
	public static void bubblesort(int [] A) 
	{	
		for(int i = 0; i < A.length - 1;i++) 
			for(int j = 0; j < A.length - 1;j++) 
			{
				if(A[j]>A[j+1])
				{
					int temp = A[j];
					A[j] = A[j+1];
					A[j+1] = temp;
				}
			}
	}
	public static void main(String[] args)
	{
		int[] A = {9,4,3,6,5,2,7,1,8,100};
		bubblesort(A);
		for(int a:A)
			System.out.println(a);
	}
}
