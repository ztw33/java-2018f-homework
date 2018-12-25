package huluwa0918;
import java.util.List;
import java.util.Arrays;
import java.util.Collections;
public class Huluwa{
	String []order;
	Huluwa(){
		order=new String[]{"1","2","3","4","5","6","7"};
	}
	
	void random() {
		List list = Arrays.asList(order);
		Collections.shuffle(list);
	}
	void bubbleSort() {
		for(int i = 0;i<6;i++) {
			for(int j = 0;j<7-i-1;j++) {
				if(order[j].compareTo(order[j+1])>0) {
					System.out.println(name(order[j],true)+"："+(j+1)+"->"+(j+2));
					String temp=order[j];
					order[j]=order[j+1];
					order[j+1]=temp;
					
				}
			}
		}
	}
	void binarySort() {
		for(int i = 1;i<7;i++) {
			String temp = order[i];
			int left = 0,right = i-1,mid=0,tempi=i;
			while(left<=right) {
				mid = (left+right)/2;
				if(temp.compareTo(order[mid])<0) {
					right = mid-1;
				}
				else {
					left=mid+1;
				}
			}
			for(int j = i-1;j>=left;j--) {
				System.out.println(name(order[j],true)+"："+(j+1)+"->"+(j+2));
				order[j+1]=order[j];
				if(j+1==tempi) {
					tempi=j;
				}
			}
			if(left!=i) {
				if(left!=tempi) {
					System.out.println(name(temp,true)+"："+(tempi+1)+"->"+(left+1));
				}
				order[left]=temp;
			}
		}
	}
	private String name(String a,Boolean mode) {
		if(a.equals("1")) {
			return mode?"老大":"红色";
		}
		else if(a.equals("2")) {
			return mode?"老二":"橙色";
		}
		else if(a.equals("3")) {
			return mode?"老三":"黄色";
		}
		else if(a.equals("4")) {
			return mode?"老四":"绿色";
		}
		else if(a.equals("5")) {
			return mode?"老五":"青色";
		}
		else if(a.equals("6")) {
			return mode?"老六":"蓝色";
		}
		else{
			return mode?"老七":"紫色";
		}
	}

	private void printAll(Boolean mode) {
		for(int i = 0;i<7;i++) {
			System.out.print(name(order[i],mode)+" ");
		}
		System.out.println();
	}
	void printOrder() {
		printAll(true);
	}
	void printColor() {
		printAll(false);
	}
	public static void main(String[] args) {
		Huluwa wawa = new Huluwa();
		wawa.random();
		wawa.printOrder();
		
		wawa.bubbleSort();
		wawa.printOrder();
		
		System.out.println();
		
		wawa.random();
		wawa.printColor();
		
		wawa.binarySort();
		wawa.printColor();

	}
}
