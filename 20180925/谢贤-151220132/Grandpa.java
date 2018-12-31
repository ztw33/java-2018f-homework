
public class Grandpa extends Creature{
	private int age;
	
	Grandpa()
	{
		super("爷爷");
	}

	public String toString() //爷爷说：各位不用叫我爷爷，叫我爷就行了
	{
		return "爷";
	}
	
	public HuLuWa[] huluwaBorn()	//爷爷种下葫芦藤后长出了葫芦娃，表示惊呆了
	{
		HuLuWa []huluwa=new HuLuWa[HuLuWa.huluwaNum];
		huluwa[0]=new HuLuWa(3,HuLuWa.Color.yellow,"");
		huluwa[1]=new HuLuWa(5,HuLuWa.Color.cyan,"");
		huluwa[2]=new HuLuWa(6,HuLuWa.Color.blue,"");
		huluwa[3]=new HuLuWa(1,HuLuWa.Color.red,"");
		huluwa[4]=new HuLuWa(2,HuLuWa.Color.orange,"");
		huluwa[5]=new HuLuWa(7,HuLuWa.Color.purple,"");
		huluwa[6]=new HuLuWa(4,HuLuWa.Color.green,"");
		return huluwa;
	}
	
	public void callHuluwa(Land land,HuLuWa []huluwa)//呼叫葫芦娃
	{
		for(int i=1;i<=HuLuWa.huluwaNum;i++)
			land.getPosition()[0][i].setObj(huluwa[i-1]);
	}
	
	public void followHuluwa(Land land,Position grandpaSrcPos)	//走到葫芦娃中间为其加油鼓劲
	{
		grandpaSrcPos.popObj();
		land.getPosition()[4][2].setObj(this);
	}
	
	
	public void singleLine(Land land,HuLuWa []huluwa)	//让葫芦娃摆长蛇阵
	{	
		for(int i=1;i<=HuLuWa.huluwaNum;i++)
		{
			land.getPosition()[0][i].popObj();
			land.getPosition()[i][0].setObj(huluwa[i-1]);
		}
		
		//葫芦娃根据排行调整顺序
		for(int i=1;i<HuLuWa.huluwaNum;i++)
			for(int j=i+1;j<HuLuWa.huluwaNum+1;j++)
			{
				HuLuWa cur=(HuLuWa)land.getPosition()[i][0].getObj();
				HuLuWa other=(HuLuWa)land.getPosition()[j][0].getObj();
				//若cur葫芦娃的排行比other葫芦娃小，则需要和other葫芦娃互换位置
				if(cur.compareTo(other)<0)
				{
					Position temp=land.emptyPosition();
					//cur葫芦娃离开原来得到地方，走到一个空位置
					land.getPosition()[i][0].popObj();
					temp.setObj(cur);
					//other葫芦娃离开原来得到地方，走到cur葫芦娃原来的位置
					land.getPosition()[j][0].popObj();
					land.getPosition()[i][0].setObj(other);
					//cur葫芦娃走到other葫芦娃原来的位置
					temp.popObj();
					land.getPosition()[j][0].setObj(cur);				
				}
			}
		
	}
	
}
