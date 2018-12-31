package creature;


public class Scorpion extends Creature{

	public static Scorpion scorpionMan;
//	
	static{
//		try {
//			Image image=ImageIO.read(HuLuWas.class.getResource("scorp.jpg"));
//			image=image.getScaledInstance(Gui.squareXLength, Gui.squareYLength,Image.SCALE_DEFAULT );
			scorpionMan=new Scorpion("蝎子精",CreatureImage.SCORP);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
	
	public Scorpion(String name,CreatureImage image) {
		super(CreatureType.SCORPION, name,image);
		// TODO Auto-generated constructor stub
	}

}
