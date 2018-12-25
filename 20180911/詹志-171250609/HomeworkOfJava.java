
import java.io.*;
public class HomeworkOfJava {
	private int[] arraySort(int[] array) {
		int k = 0;
		int temp;
		for(int i = 0; i < (array.length -1); i++) {
			for(int j = 0; j < (array.length-1-k); j++) {
				if(array[j] > array[j+1]) {
					temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp; 
					
				}
				
			} k += 1;
			
			
		}
		return array;
	}
	public static void main(String[] args) {
		System.out.println("Please input some numbers, and I will sort it for you!");
		try {
			BufferedReader inputNumbers = new BufferedReader(new InputStreamReader(System.in));
			String numbers = inputNumbers.readLine();
			String [] numbersArray = numbers.split(" ");
			int[] array = new int[numbersArray.length];
			for(int i = 0; i < array.length; i++) {
				array[i] = Integer.parseInt(numbersArray[i]);
			}
			HomeworkOfJava first = new HomeworkOfJava();
			first.arraySort(array);
			for(int value : array)
				System.out.println(value);
			
				
			
			
			
		}catch(IOException e) {
			System.err.println("I/O exception");
		}
		
	}

}
