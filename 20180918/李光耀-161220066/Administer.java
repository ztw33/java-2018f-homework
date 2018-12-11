import java.util.Random;
//一个管理员管理葫芦娃所有动作
public  class Administer {
	
	private static HuLuWa[] brothers;
	
	private static bubbleSortByName adSortName;
	
	private static binarySortByColor adSortColor;
	
	static{
		brothers=HuLuWa.values();
		adSortName=new bubbleSortByName();
		adSortColor=new binarySortByColor();
	}
	
	private Random random=new Random();
	
	public Administer() {
		
	}
	
	//管理员的基本操作 交换两个葫芦娃的位置 不向外暴露
	private static void swap(int i,int j){
		System.out.println(brothers[i].getName()+":"+i+"->"+j);
		System.out.println(brothers[j].getName()+":"+j+"->"+i);
		HuLuWa temp=brothers[j];
		brothers[j]=brothers[i];
		brothers[i]=temp;
	}
	//按照名字排序 向外暴露
	public void sortName(){
		adSortName.sort(brothers);
	}
	//按照颜色排序 向外暴露
	public void sortColor(){
		adSortColor.sort(brothers);
	}
	//随机站队
	public void randomStand() {
		for(int i=0;i<brothers.length;i++){
			int rnd=random.nextInt(brothers.length-i); //[0,hulu.length-i)
			HuLuWa temp=brothers[rnd];
			brothers[rnd]=brothers[brothers.length-i-1];
			brothers[brothers.length-i-1]=temp;
		}	
	}
	//管理员向外告诉当前葫芦娃的名字
	public void speakName(){
		for(HuLuWa a:brothers){
			System.out.print(a.getName()+" ");
		}
		System.out.println("");
	}
	//管理员向外告诉当前葫芦娃的颜色
	public void speakColor(){
		for(HuLuWa a:brothers){
			System.out.print(a.getColor()+" ");
		}
		System.out.println("");
	}
	
	//内部类 实现特定的排序算法
	static class bubbleSortByName implements sortAlgorithm{

		@Override
		public int compare(Object a, Object b) {
			HuLuWa h1=(HuLuWa)a;
			HuLuWa h2=(HuLuWa)b;
			if(h1.getNameRank()<h2.getNameRank()){
				return -1;
			}
			else if(h1.getNameRank()>h2.getNameRank()){
				return 1;
			}
			else{
				return 0;
			}
		}

		@Override
		public void sort(Object[] array) {
			HuLuWa[] hulu=(HuLuWa[])array;
			for(int count=0;count<hulu.length-1;count++){
				boolean exchange=false;
				for(int i=0;i<hulu.length-1-count;i++){
					if(compare(hulu[i],hulu[i+1])>0){
						swap(i,i+1);
						exchange=true;
					}
				}
				if(exchange==false)
					break;
			}
		}
		
	}

	//内部类 实现特定的排序算法
	static class binarySortByColor implements sortAlgorithm{

		@Override
		public int compare(Object a, Object b) {
			HuLuWa h1=(HuLuWa)a;
			HuLuWa h2=(HuLuWa)b;
			if(h1.getColorRank()<h2.getColorRank()){
				return -1;
			}
			else if(h1.getColorRank()>h2.getColorRank()){
				return 1;
			}
			else{
				return 0;
			}
		}

		@Override
		public void sort(Object[] array) {
			HuLuWa[] hulu=(HuLuWa[])array;
			for(int i=1;i<hulu.length;i++){
				int index=0;
				int start=0;
				int end=i;	//[start,end)
				while(start<end){
					int middle=(start+end)/2;
					if(compare(hulu[i],hulu[middle])<0){
						end=middle;
					}
					else if(compare(hulu[i],hulu[middle])>=0){
						start=middle+1;
					}
				}
				//start==end
				index=start;
				for(int j=i-1;j>=index;j--){
					swap(j+1, j);
				}
			}
		}
		
	}
}
