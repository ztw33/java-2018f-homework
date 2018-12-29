
public class Sort {
	
    public static void main(String[] args) {
        int arr[] = new int[] {49, 8, 30, 43, 53, 54, 30, 65, 63, 82, 43, 23 };
        
        //quick sort
        quickSort(arr, 0, arr.length-1);
        
        for (int i = 0; i < arr.length; i++)
        	System.out.print(arr[i] + " ");
    }
    
    public static void quickSort(int[] arr, int p, int q) {
    	if (p < q) {
    		int pivot = partition(arr, p, q);
    		quickSort(arr, p, pivot);
    		quickSort(arr, pivot+1, q);
    	}
    	
    }

    public static int partition(int[] arr, int p, int q) {
    	int pivot = p;
    	int temp;
    	for (int i = p + 1; i <= q; i++)
    	{
    		if (arr[i] < arr[p])
    		{
    			pivot++;	
    			//swap arr[i], arr[pivot]
    			temp = arr[i];
    			arr[i] = arr[pivot];
    			arr[pivot] = temp;
    		}
    	}
    	temp = arr[pivot];
    	arr[pivot] = arr[p];
    	arr[p] = temp;
    	return pivot;
    }
    
}