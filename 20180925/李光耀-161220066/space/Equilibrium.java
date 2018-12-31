package space;

import creature.LittleMonster;
import creature.Scorpion;

public class Equilibrium extends Formation{
	public Equilibrium() {
		super(6);
		formation[0]=new Square(broadxLines-1,(int)Math.ceil((double)broadyLines/2)-1,Scorpion.scorpionMan);
		formation[1]=new Square(broadxLines-2,(int)Math.ceil((double)broadyLines/2),new LittleMonster(""));
		formation[2]=new Square(broadxLines-3,(int)Math.ceil((double)broadyLines/2)-1,new LittleMonster(""));
		formation[3]=new Square(broadxLines-4,(int)Math.ceil((double)broadyLines/2),new LittleMonster(""));
		formation[4]=new Square(broadxLines-5,(int)Math.ceil((double)broadyLines/2)-1,new LittleMonster(""));
		formation[5]=new Square(broadxLines-6,(int)Math.ceil((double)broadyLines/2),new LittleMonster(""));		
	}

}
