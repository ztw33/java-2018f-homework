package creature;


public class Human extends Creature{
	
	public static Human grandPa;
	static{
//			Image image=ImageIO.read(HuLuWas.class.getResource("grandpa.jpg"));
//			image=image.getScaledInstance(Gui.squareXLength, Gui.squareYLength,Image.SCALE_DEFAULT );
		grandPa=new Human("老爷爷",CreatureImage.GRANDPA);
		
	}
	
	public Human(String name,CreatureImage image) {
		super(CreatureType.HUMAN, name,image);
		// TODO Auto-generated constructor stub
	}

}