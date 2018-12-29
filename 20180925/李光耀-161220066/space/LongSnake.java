package space;

import creature.Being;

//只放葫芦娃
/**
* @ClassName: LongSnake
* @Description: 基本阵型
* @author 13745
* @date 2018年11月4日
*
*/
public class LongSnake extends Formation{
	public LongSnake() {
		formation.add(new Square<Being>(0,(int)Math.ceil((double)broadyLines/2)-1,null));
		formation.add(new Square<Being>(1,(int)Math.ceil((double)broadyLines/2)-1,null));
		formation.add(new Square<Being>(2,(int)Math.ceil((double)broadyLines/2)-1,null));
		formation.add(new Square<Being>(3,(int)Math.ceil((double)broadyLines/2)-1,null));
		formation.add(new Square<Being>(4,(int)Math.ceil((double)broadyLines/2)-1,null));
		formation.add(new Square<Being>(5,(int)Math.ceil((double)broadyLines/2)-1,null));
		formation.add(new Square<Being>(6,(int)Math.ceil((double)broadyLines/2)-1,null));
	}	
	
}