
public class sort {
	public static void main(String[] args) {
		int[] array= {77,22,99,55,44,66,33,88,11};
		for(int i=0;i<array.length;i++)
			System.out.print(array[i]+" ");
		System.out.println("");
		for(int i=0;i<array.length;i++)
			for(int j=i;j<array.length;j++)
				if(array[j]<array[i])
				{
					int temp=array[i];
					array[i]=array[j];
					array[j]=temp;
				}
		for(int i=0;i<array.length;i++)
			System.out.print(array[i]+" ");
	}

}
