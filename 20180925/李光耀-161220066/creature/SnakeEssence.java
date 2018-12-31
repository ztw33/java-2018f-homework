package creature;


public class SnakeEssence extends Creature{

	public static SnakeEssence snakeWoman;
	
	static{
		//try {
		//	Image image=ImageIO.read(HuLuWas.class.getResource("snake.jpg"));
		//	image=image.getScaledInstance(Gui.squareXLength, Gui.squareYLength,Image.SCALE_DEFAULT );
			snakeWoman=new SnakeEssence("蛇精",CreatureImage.SNAKE);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
	
	public SnakeEssence(String name,CreatureImage image) {
		super(CreatureType.SNAKE, name,image);
		// TODO Auto-generated constructor stub
	}

}
