public class Main{
	public static void main(String []args){

		int []array = {7,4,5,2,1,3,9,8,6};
		int len = array.length;

		//冒泡排序
		for(int i=1;i<len;i++)
			for(int j=0;j<len-i;j++){
				if(array[j]>array[j+1]){
					int temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
				}
			}
			
		for(int i:array)
			System.out.println(i);
	}
}
