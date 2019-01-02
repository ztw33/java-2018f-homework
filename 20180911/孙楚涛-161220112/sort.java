public class sort {
	public static void main(String [] avg)
	{
		int [] a = {10,3,123,421,2321,3231,41251,21313};
		for(int i = a.length-1;i>=0;--i)
		{
			for(int j = 0;j<i;++j)
			{
				if(a[j] > a[j+1])
				{
					int temp = a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
				}
			}
		}
		
		for(int i = 0;i<a.length;++i)
		{
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}
	
}
