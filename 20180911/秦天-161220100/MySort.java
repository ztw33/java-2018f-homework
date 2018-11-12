public class MySort {
	static void swap(int nums[],int id1,int id2) {
		int temp=nums[id1];
		nums[id1]=nums[id2];
		nums[id2]=temp;
	}
	static void quickSort(int nums[],int left,int right) {
		if(left>=right-1)return;
		int pivot=nums[left],pos=left;
		for(int i=left+1;i<right;i++) {
			if(nums[i]<pivot) {
				pos++;
				swap(nums, pos, i);
			}
		}
		swap(nums,pos,left);
		quickSort(nums, pos+1, right);
		quickSort(nums, left, pos);
	}
	public static void main(String args[]) {
		int nums[]=new int[]{5,1,2,7,4,6,10,8,9,11,13,12,3};
		quickSort(nums,0,nums.length);
		for(int x:nums)System.out.print(x+" ");
	}
}
