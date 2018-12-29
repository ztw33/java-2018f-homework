
public class sort {
	public static void main(String[] args) {
		int arr[]= {1,314,24,5,67,8};
		
		out(arr);
		
		int tmp=0;
		for(int i=0;i < arr.length;i++)
		{
			tmp=i;
			for(int j=i+1;j<arr.length;j++)
			{
				if(arr[j] < arr[tmp])
					tmp = j;
			}
			if(tmp != i)
			{
				int t = arr[i];
				arr[i] = arr[tmp];
				arr[tmp] = t;
			}
		}
		out(arr);
	}
	
	public static void out(int[] a) {
		for(int i=0;i < a.length;i++)
		{
			System.out.print(a[i]);
			System.out.print(' ');
		}
		System.out.print('\n');
	}
	

}
