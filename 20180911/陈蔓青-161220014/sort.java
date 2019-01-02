//package hello;

public class sort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] array = {27, 0, -3, 87, 6, 33, 100};
		int temp = 0;
		
		for (int i = 0; i < array.length; i++){
			for (int j = i + 1; j < array.length; j++){
				if (array[i] > array[j]){
					temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
			}
			System.out.println(array[i]);
		}
	}

}
