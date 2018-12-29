package space;

import creature.Being;

/**
* @ClassName: Arrow
* @Description: 基本阵型
* @author 13745
* @date 2018年11月4日
*
*/
public class Arrow extends Formation{
	public Arrow() {
		formation.add(new Square<Being>(broadxLines-1,(int)Math.ceil((double)Formation.broadyLines/2)-1,null));
		formation.add(new Square<Being>(broadxLines-2,(int)Math.ceil((double)broadyLines/2)-1-3,null));
		formation.add(new Square<Being>(broadxLines-2,(int)Math.ceil((double)broadyLines/2)-1,null));
		formation.add(new Square<Being>(broadxLines-2,(int)Math.ceil((double)broadyLines/2)-1+3,null));
		formation.add(new Square<Being>(broadxLines-3,(int)Math.ceil((double)broadyLines/2)-1-2,null));
		formation.add(new Square<Being>(broadxLines-3,(int)Math.ceil((double)broadyLines/2)-1,null));
		formation.add(new Square<Being>(broadxLines-3,(int)Math.ceil((double)broadyLines/2)-1+2,null));
		formation.add(new Square<Being>(broadxLines-4,(int)Math.ceil((double)broadyLines/2)-1-1,null));
		formation.add(new Square<Being>(broadxLines-4,(int)Math.ceil((double)broadyLines/2)-1,null));
		formation.add(new Square<Being>(broadxLines-4,(int)Math.ceil((double)broadyLines/2)-1+1,null));
		formation.add(new Square<Being>(broadxLines-5,(int)Math.ceil((double)broadyLines/2)-1,null));
	}

	
}
