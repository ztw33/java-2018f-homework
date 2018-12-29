package second_homework;

import java.util.Random;

interface Sort{
	public void sort(CalabashBrothers c);
}

class BubbleSort implements Sort{
	public void sort(CalabashBrothers c) {
		System.out.println("BubbleSort...");
		int i,j;
		boolean exchange;
		int len=CalabashBrothers.number;
		for(i=0;i<len-1;i++) {
			exchange=false;
			for(j=len-1;j>i;j--) {
				if(c.larger(j-1,j)) {
					c.swap(j-1, j);
					exchange=true;
				}
			}
			if(!exchange)
				break;
		}
	}
}

class BinarySort implements Sort{
	public void sort(CalabashBrothers c) {
		System.out.println("BinarySort...");
		int i;
		int len=CalabashBrothers.number;
		for(i=1;i<len;i++) {
			int left=0,right=i-1;
			while(left<=right) {
				int middle=(right+left)/2;
				if(c.larger(middle, i))
					right=middle-1;
				else
					left=middle+1;
			}
			//插到left位置
			//从i逐个交换到left的位置
			for(int j=i;j>=left+1;j--)
				c.swap(j,j-1);
		}
	}
}

class Randomize implements Sort{
	public void sort(CalabashBrothers c) {
		Random random=new Random();
		System.out.println("Randomizing...");
		for(int i=0;i<10;i++) {
			int x=random.nextInt(6);
			int y=random.nextInt(6);
			if(x!=y)
				c.swap(x,y);
		}
	}
}