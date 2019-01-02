package homework2;

import java.util.Random;

public class SortCalabash {

	public CalabashBro[] bro = new CalabashBro[7];

	SortCalabash() {
		for(int i = 0; i < bro.length; i++) {
			CalabashBro temp = new CalabashBro(Name.values()[i],Color.values()[i]);//��ʼ��
	    	bro[i] = temp;
	    }
	}

	public void messbro() //打乱葫芦娃顺序
	{
		int rank1,rank2;
		Random random = new Random();
		for(int i = 0; i < 14;i++) {//14次保证充分交换
			rank1 = random.nextInt(7);//控制范围
			rank2 = random.nextInt(7);
			if(rank1 != rank2) {//生成的两个随机数不一样，交换顺序
				CalabashBro temp = bro[rank1];
				bro[rank1] = bro[rank2];
				bro[rank2] = temp;
			}
		}
		System.out.print("打乱顺序:");
		for(int i = 0;i < bro.length;i++) {
			System.out.print(bro[i].broname.ordinal()+" ");
		}
		System.out.println();
	 }
	
	 //冒泡排序
	 public void CalabashBubble() {
		 System.out.println("进行冒泡排序：");
	     for(int i = 0; i < bro.length-1; i++) {
	    	 for(int j = 0; j < bro.length-1; j++) {
	    		 if(bro[j].broname.ordinal() > bro[j+1].broname.ordinal()) {
	    			 bro[j].printPoschange(j, j+1);
	                 bro[j+1].printPoschange(j+1, j);
	                 CalabashBro temp = bro[j];
	                 bro[j] = bro[j+1];
	                 bro[j+1] = temp;
	             }
	         }
	     }
	        
	 }

	 //二分法
	 public void CalabashBinary() {
		 System.out.println("进行二分排序：");
		 for(int i = 1; i < bro.length; i++) {
			 CalabashBro temp = bro[i];
	         int low = 0, high = i-1, mid = -1;
	         while(low <= high) {
	        	 mid = (low + high) / 2;
	             if (bro[mid].brocolor.ordinal() > temp.brocolor.ordinal())
	            	 high = mid - 1;
	             else
	                 low = mid + 1;
	         }
	         for(int j = i-1; j >= low; j--) {
	        	 bro[j + 1] = bro[j];
	             bro[j].printPoschange(j, j+1);
	         }
	         bro[low] = temp;
	         bro[low].printPoschange(i, low);
	     }
	        
	 }
	  
	 public void Calaname() {
		 for(int i = 0; i < bro.length; i++)
			 bro[i].printname();
		 System.out.println();
	 }
	    
	 public void Calacolor() {
		 for(int i = 0; i < bro.length; i++)
	         bro[i].printcolor();
	     System.out.println();
	 }
	        
	 public static void main(String[] args) {
		// TODO Auto-generated method stub
		 SortCalabash A = new SortCalabash();
		 A.messbro();
	     A.CalabashBubble();
	     A.Calaname();
	      
	     A.messbro();
	     A.CalabashBinary();
	     A.Calacolor();
	}

}
