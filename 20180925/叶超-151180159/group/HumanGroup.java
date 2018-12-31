package group;
import battlefield.*;
import creature.*;
import zhen.*;

public class HumanGroup extends Group {
	int x,y;
	BattleField field;
	Creature[] creatures;
	Grandpa grandpa=Grandpa.values()[0];
	Zhen zf;
	public HumanGroup(BattleField field,int x,int y){
		this.x=x;
		this.y=y;
		this.field=field;
		creatures=Huluwa.values();
	}
	
	public void grandpacheer(){
		grandpa.move(field,5,0);
	}
	
	@Override
	public void changshe(){
		zf=new ChangShe(x,y);
		zf.start(field,creatures);
	}
	@Override
	public void yanxing(){
		zf=new YanXing(x,y);
		zf.start(field,creatures);
	}
	@Override
	public void heyi(){
		zf=new HeYi(x,y);
		zf.start(field,creatures);
	}
	@Override
	public void reset(){
		zf.runaway(field, creatures);
	}

}
