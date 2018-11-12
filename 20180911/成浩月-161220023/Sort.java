import java.util.Scanner;
public class Sort {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("输入整型数组的长度");
		int length = sc.nextInt();
		System.out.println("输入每个数");
		int arr[]=new int[length];
		for(int i=0;i<length;i++) {
			arr[i]=sc.nextInt();
		}
		boolean flag;
		for(int i=0;i<length-1;i++) {
			flag=false;
			for(int j=length-1;j>i;j--) {
				if(arr[j]<arr[j-1]) {
					arr[j]=arr[j]^arr[j-1];
					arr[j-1]=arr[j]^arr[j-1];
					arr[j]=arr[j]^arr[j-1];
					flag=true;
				}
			}
			if(!flag)
				break;
		}
		for(int i=0;i<length;i++)
			System.out.print(arr[i]+" ");
		sc.close();
	}
}
