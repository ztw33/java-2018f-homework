package regulate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import creature.HuLuWa;

import creature.StyleImage;
import gui.Gui;

//管理葫芦娃七兄弟
/**
* @ClassName: HuLuWaAdminister
* @Description: 用于对七兄弟的管理 主要排序和乱序 引入集合框架后格外简单
* @author 13745
* @date 2018年11月4日
*
*/
public class HuLuWaAdminister {
	private static ArrayList<HuLuWa> brothers=new ArrayList<>();
	//private static HuLuWa[] brothers;
	//private static Random random=new Random();
	//private static bubbleSortByRank adSort;
	
	public  void shuffleHuLuWas(){
//使用集合框架进行更新
		Collections.shuffle(brothers);
//原来内容
//		for(int i=0;i<brothers.length;i++){
//			int rnd=random.nextInt(brothers.length-i); //[0,hulu.length-i)
//			HuLuWa temp=brothers[rnd];
//			brothers[rnd]=brothers[brothers.length-i-1];
//			brothers[brothers.length-i-1]=temp;
//		}
		Gui.textArea.append("葫芦娃乱序\n");
	}
	
	
	public  ArrayList<HuLuWa> getBrothers(){
		return brothers;
	}
	
//使用集合框架后 下面内容也可以废弃
	//内部类 实现特定的排序算法 此处为冒泡排序
//	static class bubbleSortByRank implements SortAlgorithm{
//		@Override
//		public int compare(Object a, Object b) {
//			HuLuWa h1=(HuLuWa)a;
//			HuLuWa h2=(HuLuWa)b;
//			if(h1.getRank()<h2.getRank()){
//				return -1;
//			}
//			else if(h1.getRank()>h2.getRank()){
//				return 1;
//			}
//			else{
//				return 0;
//			}
//		}
//
//		@Override
//		public void sort(Object[] array) {
//			HuLuWa[] huLuWas=(HuLuWa[])array;
//			for(int count=0;count<huLuWas.length-1;count++){
//				boolean exchange=false;
//				for(int i=0;i<huLuWas.length-1-count;i++){
//					if(compare(huLuWas[i],huLuWas[i+1])>0){
//						//swap(i,i+1);
//						HuLuWa temp=huLuWas[i+1];
//						huLuWas[i+1]=huLuWas[i];
//						huLuWas[i]=temp;
//						exchange=true;
//					}
//				}
//				if(exchange==false)
//					break;
//			}
//		}
//		
//	}

	
	
	public  void sortHuLuWas(){
		Comparator<HuLuWa> c = new Comparator<HuLuWa>() {
			@Override
			public int compare(HuLuWa h1, HuLuWa h2) {
				// TODO Auto-generated method stub
				if(h1.getRank()<h2.getRank())
					return 1;
				else 
					return -1;
			}
		};
		brothers.sort(c);
		Gui.textArea.append("葫芦娃排列整齐\n");
	}
	
	static{
		brothers.add(new HuLuWa("葫芦老大",StyleImage.HULUWAONE,1));
		brothers.add(new HuLuWa("葫芦老二",StyleImage.HULUWATWO,2));
		brothers.add(new HuLuWa("葫芦老三",StyleImage.HULUWATHREE,3));
		brothers.add(new HuLuWa("葫芦老四",StyleImage.HULUWAFOUR,4));
		brothers.add(new HuLuWa("葫芦老五",StyleImage.HULUWAFIVE,5));
		brothers.add(new HuLuWa("葫芦老六",StyleImage.HULUWASIX,6));
		brothers.add(new HuLuWa("葫芦老七",StyleImage.HULUWASEVEN,7));
	}
	
}

