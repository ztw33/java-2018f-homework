
public class Snake extends Creature
{
	Snake()
	{
		super("蛇精");
	}
	
	public String toString()
	{
		return "蛇";
	}
	
	public Position findScorpion(Land land)
	{
		for(int i=0;i<land.getLength();i++)
			for(int j=0;j<land.getWidth();j++)	
			{
				if(land.getPosition()[i][j].getObj() instanceof Scorpion)
					return land.getPosition()[i][j];
			}
		return null;
	}
	
	public Position followScorpion(Land land,Position snakeSrcPos)//跟随蝎子精
	{
		Position scorpionPosition=findScorpion(land);//在大地上寻找蝎子精位置
		if(scorpionPosition!=null)	//走到蝎子精身边
		{
			if(land.getPosition()[scorpionPosition.getX()][scorpionPosition.getY()+1].isEmpty())
			{
				snakeSrcPos.popObj();
				land.getPosition()[scorpionPosition.getX()][scorpionPosition.getY()+1].setObj(this);
				return land.getPosition()[scorpionPosition.getX()][scorpionPosition.getY()+1];
			}
			else 
			{
				snakeSrcPos.popObj();
				land.getPosition()[scorpionPosition.getX()][scorpionPosition.getY()-1].setObj(this);
				return land.getPosition()[scorpionPosition.getX()][scorpionPosition.getY()-1];
			}
			
		}
		return null;		
	}
	
}
