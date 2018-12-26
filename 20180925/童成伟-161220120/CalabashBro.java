package home3;

import java.util.Random;

public class CalabashBro {//葫芦兄弟类

	public Calabash[] bro = new Calabash[7];

	CalabashBro() {//初始化7个
		for(int i = 0; i < bro.length; i++) {
			Calabash temp = new Calabash(CalaName.values()[i]);
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
				Calabash temp = bro[rank1];
				bro[rank1] = bro[rank2];
				bro[rank2] = temp;
			}
		}
		/*System.out.print("打乱顺序:");
		for(int i = 0;i < bro.length;i++) {
			System.out.print(bro[i].name+" ");
		}
		System.out.println();*/
	 }
	
	 //冒泡排序
	 public void CalabashBubble() {
		 System.out.println("葫芦兄弟整理阵型进行排序");
	     for(int i = 0; i < bro.length-1; i++) {
	    	 for(int j = 0; j < bro.length-1; j++) {
	    		 if(bro[j].getrank() > bro[j+1].getrank()) {
	                 Calabash temp = bro[j];
	                 bro[j] = bro[j+1];
	                 bro[j+1] = temp;
	             }
	         }
	     }
	        
	 }

}
