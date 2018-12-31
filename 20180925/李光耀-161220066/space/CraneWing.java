package space;


import creature.LittleMonster;
import creature.Scorpion;

//只放怪物
public class CraneWing extends Formation{
	public CraneWing() {
		super(7);
		formation[0]=new Square(broadxLines-1,(int)Math.ceil((double)broadyLines/2)-1,Scorpion.scorpionMan);
		formation[1]=new Square(broadxLines-2,(int)Math.ceil((double)broadyLines/2)-1-1,new LittleMonster(""));
		formation[2]=new Square(broadxLines-2,(int)Math.ceil((double)broadyLines/2)-1+1,new LittleMonster(""));
		formation[3]=new Square(broadxLines-3,(int)Math.ceil((double)broadyLines/2)-1-2,new LittleMonster(""));
		formation[4]=new Square(broadxLines-3,(int)Math.ceil((double)broadyLines/2)-1+2,new LittleMonster(""));
		formation[5]=new Square(broadxLines-4,(int)Math.ceil((double)broadyLines/2)-1-3,new LittleMonster(""));
		formation[6]=new Square(broadxLines-4,(int)Math.ceil((double)broadyLines/2)-1+3,new LittleMonster(""));
	}
}
