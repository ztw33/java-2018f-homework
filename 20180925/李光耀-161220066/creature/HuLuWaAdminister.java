package creature;

import java.util.Random;


import gui.Gui;


//管理葫芦娃七兄弟
public class HuLuWaAdminister {
	private static HuLuWa[] brothers;
	private static Random random=new Random();
	
	public static void shuffleHuLuWas(){
		for(int i=0;i<brothers.length;i++){
			int rnd=random.nextInt(brothers.length-i); //[0,hulu.length-i)
			HuLuWa temp=brothers[rnd];
			brothers[rnd]=brothers[brothers.length-i-1];
			brothers[brothers.length-i-1]=temp;
		}
		Gui.textArea.append("葫芦娃乱序\n");
	}
	
	public static HuLuWa[] getBrothers(){
		return brothers;
	}
	private static int compare(HuLuWa a,HuLuWa b){
		int result=a.getRank()-b.getRank();
		if(result>0)
			return 1;
		else if(result==0)
			return 0;
		else 
			return -1;	
	}
	
	private static void swap(int i,int j){
		HuLuWa temp=brothers[j];
		brothers[j]=brothers[i];
		brothers[i]=temp;
	}
	
	public static void sortHuLuWas(){
		for(int count=0;count<brothers.length-1;count++){
			boolean exchange=false;
			for(int i=0;i<brothers.length-1-count;i++){
				if(compare(brothers[i],brothers[i+1])>0){
					swap(i,i+1);
					exchange=true;
				}
			}
			if(exchange==false)
				break;
		}
		Gui.textArea.append("葫芦娃排列整齐\n");
	}
	
	static{
		brothers=new HuLuWa[7];
//			Image image=ImageIO.read(HuLuWas.class.getResource("hulu1.jpg"));
//			image=image.getScaledInstance(Gui.squareXLength, Gui.squareYLength,Image.SCALE_DEFAULT );
		brothers[0]=new HuLuWa("葫芦老大",CreatureImage.HULUWAONE,1);
		
//			image=ImageIO.read(HuLuWas.class.getResource("hulu2.jpg"));
//			image=image.getScaledInstance(Gui.squareXLength, Gui.squareYLength,Image.SCALE_DEFAULT );
		brothers[1]=new HuLuWa("葫芦老二",CreatureImage.HULUWATWO,2);
		
//			image=ImageIO.read(HuLuWas.class.getResource("hulu3.jpg"));
//			image=image.getScaledInstance(Gui.squareXLength, Gui.squareYLength,Image.SCALE_DEFAULT );
		brothers[2]=new HuLuWa("葫芦老三",CreatureImage.HULUWATHREE,3);
		
//			image=ImageIO.read(HuLuWas.class.getResource("hulu4.jpg"));
//			image=image.getScaledInstance(Gui.squareXLength, Gui.squareYLength,Image.SCALE_DEFAULT );
		brothers[3]=new HuLuWa("葫芦老四",CreatureImage.HULUWAFOUR,4);
		
//			image=ImageIO.read(HuLuWas.class.getResource("hulu5.jpg"));
//			image=image.getScaledInstance(Gui.squareXLength, Gui.squareYLength,Image.SCALE_DEFAULT );
		brothers[4]=new HuLuWa("葫芦老五",CreatureImage.HULUWAFIVE,5);
		
//			image=ImageIO.read(HuLuWas.class.getResource("hulu6.jpg"));
//			image=image.getScaledInstance(Gui.squareXLength, Gui.squareYLength,Image.SCALE_DEFAULT );
		brothers[5]=new HuLuWa("葫芦老六",CreatureImage.HULUWASIX,6);
		
//			image=ImageIO.read(HuLuWas.class.getResource("hulu7.jpg"));
//			image=image.getScaledInstance(Gui.squareXLength, Gui.squareYLength,Image.SCALE_DEFAULT );
		brothers[6]=new HuLuWa("葫芦老七",CreatureImage.HULUWASEVEN,7);
		
	}
	
}
