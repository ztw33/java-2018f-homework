package space;

import creature.HuLuWaAdminister;

//只放葫芦娃
public class LongSnake extends Formation{
	public LongSnake() {
		super(7);
		formation[0]=new Square(0,(int)Math.ceil((double)broadyLines/2)-1,HuLuWaAdminister.getBrothers()[6]);
		formation[1]=new Square(1,(int)Math.ceil((double)broadyLines/2)-1,HuLuWaAdminister.getBrothers()[5]);
		formation[2]=new Square(2,(int)Math.ceil((double)broadyLines/2)-1,HuLuWaAdminister.getBrothers()[4]);
		formation[3]=new Square(3,(int)Math.ceil((double)broadyLines/2)-1,HuLuWaAdminister.getBrothers()[3]);
		formation[4]=new Square(4,(int)Math.ceil((double)broadyLines/2)-1,HuLuWaAdminister.getBrothers()[2]);
		formation[5]=new Square(5,(int)Math.ceil((double)broadyLines/2)-1,HuLuWaAdminister.getBrothers()[1]);
		formation[6]=new Square(6,(int)Math.ceil((double)broadyLines/2)-1,HuLuWaAdminister.getBrothers()[0]);
	}	
}