package space;

import creature.Being;

/**
* @ClassName: Equilibrium
* @Description: 基本阵型
* @author 13745
* @date 2018年11月4日
*
*/
public class Equilibrium extends Formation{
	public Equilibrium() {
		formation.add(new Square<Being>(broadxLines-1,(int)Math.ceil((double)broadyLines/2)-1,null));
		formation.add(new Square<Being>(broadxLines-2,(int)Math.ceil((double)broadyLines/2),null));
		formation.add(new Square<Being>(broadxLines-3,(int)Math.ceil((double)broadyLines/2)-1,null));
		formation.add(new Square<Being>(broadxLines-4,(int)Math.ceil((double)broadyLines/2),null));
		formation.add(new Square<Being>(broadxLines-5,(int)Math.ceil((double)broadyLines/2)-1,null));
		formation.add(new Square<Being>(broadxLines-6,(int)Math.ceil((double)broadyLines/2),null));		
	}
}
