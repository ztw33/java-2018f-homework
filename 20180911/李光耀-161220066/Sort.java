import java.util.Random;
public class Sort {
	private int length;
	private int[] data;
	
	Sort(){
		Random rand=new Random();
		//rand.nextInt用于生成[0,var)之间的随机数
		this.length=rand.nextInt(1000-100+1)+100;//[100,1000]
		data=new int[length];
		for(int i=0;i<length;i++)
			data[i]=rand.nextInt(101);	//[0,101)
	}
	
	public void mergeSort(){
		mergeSortRecur(0,data.length);
	}
	
	private void mergeSortRecur(int start,int end) {//[start,end)
		if((start+1)>=end) return;
		int middle=(start+end)/2;
		mergeSortRecur(start, middle);//[start,middle) [middle,end)
		mergeSortRecur(middle, end);
		int p1=start,p2=middle;
		int[] temp=new int[end-start];
		int index=0;
		while(p1<middle&&p2<end){
			if(data[p1]<=data[p2]){
				temp[index++]=data[p1++];
			}
			else{
				temp[index++]=data[p2++];
			}
		}
		while(p1<middle)
			temp[index++]=data[p1++];
		while(p2<end)
			temp[index++]=data[p2++];
		for(int i=0;i<end-start;i++)
			data[start+i]=temp[i];
		return;
	}
	
	public void quickSort(){
		quickSortRecur(0, data.length);
	}
	
	private void  quickSortRecur(int start,int end) {	//[start,end)
		if(start>=end) return;
		int split=partition(start, end);
		quickSortRecur(start,split);
		quickSortRecur(split+1,end);
	}
	
	private int partition(int start,int end){	//[start,end)
		int split=start;
		int privot=data[split];
		for(int i=start+1;i<end;i++){
			if(data[i]<=privot){
				split++;
				int temp=data[i];
				data[i]=data[split];
				data[split]=temp;
			}
		}
		data[start]=data[split];
		data[split]=privot;
		return split;
	}
	public boolean check() {
		for(int i=0;i<length-1;i++)
			if(data[i]>data[i+1]){
				System.out.println("Sort wrong!");
				return false;
			}
		System.out.println("Sort tests OK.");
		return true;
	}
	
	public void printAll() {
		for(int i=0;i<length;i++)
			System.out.print(data[i]+" ");
		System.out.println("");
	}
	public static void main(String[] args) {
		//两组不同的测试用例
		Sort sort=new Sort();//测试quickSort
		sort.quickSort();
		if(sort.check()) 
			sort.printAll();
		sort=new Sort();	//测试mergeSort
		sort.mergeSort();
		if(sort.check())
			sort.printAll();
	}
}
