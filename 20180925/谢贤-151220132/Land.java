
public class Land 
{
	private int length;	//大地的长
	private int width;	//宽
	private Position [][]position;//大地区域
	Land(int length,int width)
	{
		this.length=length;
		this.width=width;
		position=new Position[length][width];
		for(int i=0;i<length;i++)
			for(int j=0;j<width;j++)	
			{
				position[i][j]=new Position(i,j);
				position[i][j].setX(i);
				position[i][j].setY(j);
				position[i][j].setEmpty(true);
			}
	}
	

	void showActivities(Grandpa grandpa,HuLuWa []huluwa,Scorpion scorpion,Snake snake)		//展示大地上的活动
	{
		Position scorpionPos=position[4][width-2],snakePos=position[4][width-1];
		//蝎子精登场
		scorpionPos.setObj(scorpion);
		//蛇精登场
		snakePos.setObj(snake);
		//爷爷登场
		Position grandpaPos=position[0][0];
		grandpaPos.setObj(grandpa);	
		
		//爷爷发现情况不对，赶紧呼叫葫芦娃过来帮忙
		grandpa.callHuluwa(this,huluwa);
		
		//这时现场混进了一名记者
		Reporter reporter=new Reporter();
		//现场记者传来一张葫芦娃急忙忙赶来的随机站队的照片
		reporter.takePhoto(this,"葫芦娃随机站队:");
		
		//爷爷指挥葫芦娃摆长蛇阵威慑对方
		grandpa.singleLine(this,huluwa); 
		//记者抓拍到了这一瞬间
		reporter.takePhoto(this,"\n葫芦娃长蛇阵:");
		
		//蝎子精见状，也命令小喽喽摆出雁形阵
		scorpionPos=scorpion.EchelonArray(this,scorpionPos);
		//爷爷跑到葫芦娃中间为葫芦娃加油
		grandpa.followHuluwa(this,grandpaPos);
		//蛇精也跑到蝎子精旁边为其鼓劲
		snakePos=snake.followScorpion(this,snakePos);	
		
		//现场记者擦了擦嘴角的口水，拍下了这一场景
		reporter.takePhoto(this,"\n第一回合：长蛇阵VS雁形阵:");
		
		//蝎子精被葫芦娃讥笑其阵型太丑，一怒之下放出了他自以为最帅的方円阵
		scorpionPos=scorpion.CrescentMoonArray(this,scorpionPos);
		//蛇精紧随着蝎子精
		snakePos=snake.followScorpion(this,snakePos);	
		
		//记者嘴角微微一笑，淡定地锁定了这一对峙局面
		reporter.takePhoto(this,"\n第二回合：长蛇阵VS方円阵:");	
	}
	
	
	public Position emptyPosition()		//返回土地上的一个空位置
	{
		for(int i=0;i<length;i++)
			for(int j=0;j<width;j++)	
			{
				if(position[i][j].isEmpty())
					return position[i][j];
			}
		return new Position(length,width);
	}
	
	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public Position[][] getPosition() {
		return position;
	}

	public void setPosition(Position[][] position) {
		this.position = position;
	}

	
}
