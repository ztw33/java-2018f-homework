package space;

import creature.LittleMonster;
import creature.Scorpion;

public class FishScale extends Formation{
	public FishScale() {
		super(11);
		formation[0]=new Square(broadxLines-1,(int)Math.ceil((double)broadyLines/2)-1,Scorpion.scorpionMan);
		formation[1]=new Square(broadxLines-2,(int)Math.ceil((double)broadyLines/2)-1-2,new LittleMonster(""));
		formation[2]=new Square(broadxLines-2,(int)Math.ceil((double)broadyLines/2)-1-1,new LittleMonster(""));
		formation[3]=new Square(broadxLines-2,(int)Math.ceil((double)broadyLines/2)-1,new LittleMonster(""));
		formation[4]=new Square(broadxLines-2,(int)Math.ceil((double)broadyLines/2)-1+1,new LittleMonster(""));
		formation[5]=new Square(broadxLines-2,(int)Math.ceil((double)broadyLines/2)-1+2,new LittleMonster(""));
		formation[6]=new Square(broadxLines-3,(int)Math.ceil((double)broadyLines/2)-1-1,new LittleMonster(""));
		formation[7]=new Square(broadxLines-3,(int)Math.ceil((double)broadyLines/2)-1,new LittleMonster(""));
		formation[8]=new Square(broadxLines-3,(int)Math.ceil((double)broadyLines/2)-1+1,new LittleMonster(""));
		formation[9]=new Square(broadxLines-4,(int)Math.ceil((double)broadyLines/2)-1-1,new LittleMonster(""));
		formation[10]=new Square(broadxLines-5,(int)Math.ceil((double)broadyLines/2)-1,new LittleMonster(""));
	}
}
