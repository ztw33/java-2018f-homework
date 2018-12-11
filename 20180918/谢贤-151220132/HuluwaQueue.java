
public class HuluwaQueue {
	public static final int huluwaNum = 7; //葫芦娃总数
	private HuLuWa []huluwa=new HuLuWa[huluwaNum];	//葫芦娃数组，用数组下标表示葫芦娃所处位置
	
	public void randomStand()
	{	 
		//生成葫芦娃对象并“随机”站队
		 System.out.println("---------\"随机\"站队---------");
		 huluwa[0]=new HuLuWa(3,HuLuWa.Color.yellow,"我是三娃铁头娃，喝，铜头铁臂刀枪不入\n");
		 huluwa[1]=new HuLuWa(5,HuLuWa.Color.cyan,"我是五娃大肚娃，我的肚里能赛艇\n");
		 huluwa[2]=new HuLuWa(6,HuLuWa.Color.blue,"我是六娃隐身娃，来无影去无踪\n");
		 huluwa[3]=new HuLuWa(1,HuLuWa.Color.red,"我是大娃大力娃，力大无穷就是我\n");
		 huluwa[4]=new HuLuWa(2,HuLuWa.Color.orange,"我是二娃机灵娃，我有千里眼顺风耳\n");
		 huluwa[5]=new HuLuWa(7,HuLuWa.Color.purple,"我是七娃宝葫娃，我有一个宝葫芦我从来也不骑\n");
		 huluwa[6]=new HuLuWa(4,HuLuWa.Color.green,"我是四娃烈火娃，想看喷火表演吗\n");
	}

	public void bubbleSort()
	{
		System.out.println("-------冒泡排序-------");
		for(int i=0;i<huluwaNum-1;i++)
			for(int j=i+1;j<huluwaNum;j++)
				if(huluwa[i].getRank()>huluwa[j].getRank())
				{
					HuLuWa temp=huluwa[i];
					huluwa[i].howl(i+1,j+1);	//换位置时报告
					huluwa[i]=huluwa[j];
					huluwa[i].howl(j+1,i+1);
					huluwa[j]=temp;				
				}
	}
	
	public void callOffByRank()
	{
		System.out.println("-------按排行报数-------");
		for(int i=0;i<huluwaNum;i++)
			huluwa[i].callOffByRank();
	}
	
	public void callOffByColor()
	{
		System.out.println("-------按颜色报数-------");
		for(int i=0;i<huluwaNum;i++)
			huluwa[i].callOffByColor();
	}
	
	public void QuickSort()
	{
		System.out.println("-------快速排序-------");
		QuickSort(0,huluwaNum-1);
	}
	
	public int partition(HuLuWa pvoit,int first,int last)
	{
		int i=first+1,empty=first;	//pvoit葫芦娃原来所在的位置设为empty
		while(i<=last)
		{
			if(huluwa[i].getColor().ordinal()<pvoit.getColor().ordinal())//通过葫芦娃颜色在枚举类型中的序数进行比较
			{//若找到一个比pvoit颜色“小”的葫芦娃，则把它放到empty的位置，empty的右边紧邻的葫芦娃则去到这个比pvoit颜色“小”的葫芦娃的原来位置，然后empty右移一位
				if(empty!=i)
					huluwa[i].howl(i+1,empty+1);
				huluwa[empty]=huluwa[i];
				if(empty+1!=i)
					huluwa[empty+1].howl(empty+1+1,i+1);
				huluwa[i]=huluwa[empty+1];
			    empty+=1;         
			    
			}
			i+=1;
		}
		return empty;
	}
	
	public void QuickSort(int first,int last)
	{
		
		if(first>=last)
	          return;
		HuLuWa pvoit=huluwa[first];	
	    int splitPoint=partition(pvoit,first,last);	//找到pvoit葫芦娃应在的位置
	    if(splitPoint!=first)
	    	pvoit.howl(first+1, splitPoint+1);
	    huluwa[splitPoint]=pvoit;
	    QuickSort(first,splitPoint-1);	//对pvoit葫芦娃左边的葫芦娃进行递归排序
	    QuickSort(splitPoint+1,last);

	}
	
}