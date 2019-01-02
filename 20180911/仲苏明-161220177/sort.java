package sort;

public class sort {
	public int[] nums;
	public static void f(int[] nums) {
		int tmp=0;
		int len=nums.length;
		for(int i=0;i<len-1;i++) {
			for(int j=0;j<len-1;j++) {
				if(nums[j]>nums[j+1]) {
					tmp=nums[j];
					nums[j]=nums[j+1];
					nums[j+1]=tmp;
				}
			}
		}
	}
	public static void main(String[] args) {
		int[] nums= {5,6,18,3,9,17,52,24,13};
		sort.f(nums);
		for(int i=0;i<nums.length-1;i++) {
			System.out.print(nums[i]+",");
		}
		System.out.print(nums[nums.length-1]);
		System.out.println("");
	}
}

