
public class Reporter extends Creature{
	Reporter()
	{
		super("HK Reporter");
	}
	
	public void takePhoto(Land land,String photoWords)
	{
		System.out.println(photoWords);
		for(int i=0;i<land.getLength();i++)
		{
			System.out.print('\n');
			for(int j=0;j<land.getWidth();j++)	
				land.getPosition()[i][j].showObjShape();
		}
	}
}
