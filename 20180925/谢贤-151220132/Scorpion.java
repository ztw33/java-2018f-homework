
public class Scorpion extends Creature{
	Scorpion()
	{
		super("蝎子精");
	}
	
	public String toString()
	{
		return "蝎";
	}
	
	public Lesser[] callLesser(int lesserNum)	//派小喽喽出战
	{
		Lesser lessers[]=new Lesser[lesserNum];
		for(int i=0;i<lesserNum;i++)
			lessers[i]=new Lesser();
		return lessers;
	}
	
	
	public Position EchelonArray(Land land,Position scorpionSrcPos) //率领小喽喽排雁行阵
	{
		int lesserNum=6;
		Lesser lessers[]=callLesser(lesserNum);
		//长蛇阵的上半部分小喽喽先就位
		Position curPos=land.getPosition()[1][land.getWidth()-1];
		for(int i=0;i<lesserNum/2;i++)
		{
			curPos.setObj(lessers[i]);
			curPos=land.getPosition()[curPos.getX()+1][curPos.getY()-1];
		}
		//蝎子精离开原来的位置，来到阵中间
		scorpionSrcPos.popObj();
		curPos.setObj(this);	
		Position rtn=curPos;
		//长蛇阵的下半部分小喽喽就位
		for(int i=lesserNum/2;i<lesserNum;i++)
		{
			curPos=land.getPosition()[curPos.getX()+1][curPos.getY()-1];
			curPos.setObj(lessers[i]);
		}
		return rtn;
				
	}
	
	public Position CrescentMoonArray(Land land,Position scorpionSrcPos) //率领小喽喽排方円阵
	{
		//先把原来的小喽喽清走
		for(int i=0;i<land.getLength();i++)
			for(int j=0;j<land.getWidth();j++)	
			{
				if(land.getPosition()[i][j].getObj() instanceof Lesser)
					land.getPosition()[i][j].popObj();
			}
		
		//排兵布阵
		int lesserNum=7,curLesserNum=0;
		Lesser lessers[]=callLesser(lesserNum);
		Position upPos=land.getPosition()[2][land.getWidth()-3],downPos=land.getPosition()[6][land.getWidth()-3];
		upPos.setObj(lessers[curLesserNum++]);downPos.setObj(lessers[curLesserNum++]);
		
		upPos=land.getPosition()[upPos.getX()+1][upPos.getY()-1];downPos=land.getPosition()[downPos.getX()-1][downPos.getY()-1];
		upPos.setObj(lessers[curLesserNum++]);downPos.setObj(lessers[curLesserNum++]);
		
		upPos=land.getPosition()[upPos.getX()][upPos.getY()+2];downPos=land.getPosition()[downPos.getX()][downPos.getY()+2];
		upPos.setObj(lessers[curLesserNum++]);downPos.setObj(lessers[curLesserNum++]);
		
		upPos=land.getPosition()[upPos.getX()+1][upPos.getY()-3];downPos=land.getPosition()[downPos.getX()-1][downPos.getY()+1];
		downPos.setObj(lessers[curLesserNum++]);
		scorpionSrcPos.popObj();
		upPos.setObj(this);	

		return upPos;
	}
	
}
