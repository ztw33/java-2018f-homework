package sort;
import java.util.Scanner;
public class SortTest {
	public static void main(String args[]) {
		System.out.println("请输入一组整型数组");
		
		Scanner scan=new Scanner(System.in);
		String[] str1=scan.nextLine().split(" ");
		scan.close();
		
		int[] nums= new int[str1.length];
		for(int i=0;i<str1.length;i++ ) {
			nums[i]=Integer.parseInt(str1[i]);
		}
		
		for(int i=0;i<str1.length-1;i++) {
			for(int j=i+1;j<str1.length;j++) {
				if(nums[i]>nums[j]) {
					int temp=nums[i];
					nums[i]=nums[j];
					nums[j]=temp;
				}
			}
		}
		for(int i=0;i<str1.length;i++) {
			System.out.println(nums[i]);
		}
	}
}
