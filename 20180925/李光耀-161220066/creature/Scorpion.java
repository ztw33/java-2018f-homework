package creature;



/**
* @ClassName: Scorpion
* @Description: 蝎子精
* @author 13745
* @date 2018年11月4日
*
*/
public class Scorpion extends BadCreature{
	public static Scorpion scorpionMan;
	static{
		scorpionMan=new Scorpion("蝎子精",StyleImage.SCORP);
	}
	
	public Scorpion(String name,StyleImage image) {
		super(name,image);
	}

}
