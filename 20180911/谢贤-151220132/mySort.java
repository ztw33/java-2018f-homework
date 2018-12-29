
public class mySort {
	
	public static void main(String[] args)
    {
    	int []myArray={5,4,26,-31,12,2,0};
    	sort(myArray);
        for(int i=0;i<myArray.length;i++)
        	System.out.println(myArray[i]);
        		
    }
	
	static void sort(int[] arr)
	{
		for(int i=0;i<arr.length-1;i++)
        	for(int j=i+1;j<arr.length;j++)
        	{
        		if(arr[i]>arr[j])
        		{	  
        			int temp=arr[i];
        			arr[i]=arr[j];
        			arr[j]=temp;
        		}	        							        		
        	}
	}
}
