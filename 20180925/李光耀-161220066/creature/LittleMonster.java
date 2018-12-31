package creature;



public class LittleMonster extends Creature{
	
//	static{
//			image=ImageIO.read(HuLuWas.class.getResource("monster.jpg"));
//			image=image.getScaledInstance(Gui.squareXLength, Gui.squareYLength,Image.SCALE_DEFAULT );
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	public LittleMonster(String name) {
		super(CreatureType.LITTLEMONSTER, name,CreatureImage.LITTLEMONSTER);
		// TODO Auto-generated constructor stub
	}
}
