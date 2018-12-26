
public class Sort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int Array[] = {0,3,5,4,9,11,12,8,7,6};
		
		for(int i = 0; i < Array.length - 1; i++)
			for(int j = 0; j < Array.length - 1 - i; j++) {
		        if(Array[j] > Array[j+1]) {
		          int temp = Array[j];
		          Array[j] = Array[j + 1];
		          Array[j + 1] = temp;
		        }
			}

		    for(int i = 0; i < Array.length; i++)
		      System.out.print(Array[i] + " ");
	}
	

}




