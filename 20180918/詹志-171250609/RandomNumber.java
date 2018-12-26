package homework;
import java.util.*;

//产生N个不同的随机数
public class RandomNumber {
	public int[] randNumber(int n) {
		int[] randNum = new int[n];
		Random rand = new Random(47);
		boolean[] check = new boolean[n];
		for(boolean value : check)
			value = false;
		for(int i = 0; i < n; i++) {
			do{
				check[i] = false;
				randNum[i] = rand.nextInt(n);
				for(int k = 0; k < i; k++) 
					if(randNum[k] == randNum[i])
						check[i] = true;
			} while(check[i]);
		}
		return randNum;
	}
	
}
