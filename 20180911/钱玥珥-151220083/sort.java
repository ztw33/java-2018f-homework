package sort;

public class sort {
	public static int partition(int []nums,int left,int right) {
		int temp=nums[right],i=left-1,k;
		for(int j = left;j<right;j++) {
			if(nums[j]<=temp) {
				i=i+1;
				k=nums[i];
				nums[i]=nums[j];
				nums[j]=k;
			}
		}
		k=nums[i+1];
		nums[i+1]=nums[right];
		nums[right]=k;
		return i+1;
	}
	
	public static void quicksort(int []nums,int left,int right) {
		if(left<right) {
			int mid=partition(nums,left,right);
			quicksort(nums,left,mid-1);
			quicksort(nums,mid+1,right);
		}
	}
	
	public static void main(String[] args) {
		int nums[]= {-1,22,15,-20,-17,6,9,-2};
		quicksort(nums,0,nums.length-1);
		for(int i = 0;i<nums.length;i++)
			System.out.print(nums[i]+" ");
	}

}
