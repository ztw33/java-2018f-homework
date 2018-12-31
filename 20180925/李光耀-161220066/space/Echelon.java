package space;

import creature.LittleMonster;
import creature.Scorpion;

//雁行
public class Echelon extends Formation{
	public Echelon() {
		super(5);
		formation[0]=new Square(broadxLines-1,(int)Math.ceil((double)broadyLines/2)-1-2,Scorpion.scorpionMan);
		formation[1]=new Square(broadxLines-2,(int)Math.ceil((double)broadyLines/2)-1-1,new LittleMonster(""));
		formation[2]=new Square(broadxLines-3,(int)Math.ceil((double)broadyLines/2)-1,new LittleMonster(""));
		formation[3]=new Square(broadxLines-4,(int)Math.ceil((double)broadyLines/2)-1+1,new LittleMonster(""));
		formation[4]=new Square(broadxLines-5,(int)Math.ceil((double)broadyLines/2)-1+2,new LittleMonster(""));		
	}
}
