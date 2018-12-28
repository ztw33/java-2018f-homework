package space;

import creature.Being;

/**
* @ClassName: CurvedMoon
* @Description: 基本阵型
* @author 13745
* @date 2018年11月4日
*
*/
public class CurvedMoon extends Formation{
	public CurvedMoon() {
		formation.add(new Square<Being>(broadxLines-1,(int)Math.ceil((double)broadyLines/2)-1-3,null));
		formation.add(new Square<Being>(broadxLines-2,(int)Math.ceil((double)broadyLines/2)-1-2,null));
		formation.add(new Square<Being>(broadxLines-2,(int)Math.ceil((double)broadyLines/2)-1-1,null));
		formation.add(new Square<Being>(broadxLines-3,(int)Math.ceil((double)broadyLines/2)-1-1,null));
		formation.add(new Square<Being>(broadxLines-3,(int)Math.ceil((double)broadyLines/2)-1,null));
		formation.add(new Square<Being>(broadxLines-4,(int)Math.ceil((double)broadyLines/2)-1,null));
		formation.add(new Square<Being>(broadxLines-4,(int)Math.ceil((double)broadyLines/2)-1+1,null));
		formation.add(new Square<Being>(broadxLines-4,(int)Math.ceil((double)broadyLines/2)-1+2,null));
		formation.add(new Square<Being>(broadxLines-5,(int)Math.ceil((double)broadyLines/2)-1,null));
		formation.add(new Square<Being>(broadxLines-5,(int)Math.ceil((double)broadyLines/2)-1+1,null));
		formation.add(new Square<Being>(broadxLines-5,(int)Math.ceil((double)broadyLines/2)-1+2,null));
		formation.add(new Square<Being>(broadxLines-6,(int)Math.ceil((double)broadyLines/2)-1,null));
		formation.add(new Square<Being>(broadxLines-6,(int)Math.ceil((double)broadyLines/2)-1+1,null));
		formation.add(new Square<Being>(broadxLines-6,(int)Math.ceil((double)broadyLines/2)-1+2,null));
		formation.add(new Square<Being>(broadxLines-7,(int)Math.ceil((double)broadyLines/2)-1,null));
		formation.add(new Square<Being>(broadxLines-7,(int)Math.ceil((double)broadyLines/2)-1-1,null));
		formation.add(new Square<Being>(broadxLines-8,(int)Math.ceil((double)broadyLines/2)-1-1,null));
		formation.add(new Square<Being>(broadxLines-8,(int)Math.ceil((double)broadyLines/2)-1-2,null));
		formation.add(new Square<Being>(broadxLines-9,(int)Math.ceil((double)broadyLines/2)-1-3,null));
		
	}

	
}
