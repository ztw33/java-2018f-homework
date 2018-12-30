package group;

import battlefield.BattleField;
import creature.*;
import zhen.ChangShe;
import zhen.HeYi;
import zhen.YanXing;
import zhen.Zhen;

public class MonsterGroup extends Group {
		int x,y;
		BattleField field;
		Creature[] creatures=new Monster[7];
		Snake snake=new Snake();
		Xiezi xiezi=new Xiezi();
		Zhen zf;
		public MonsterGroup(BattleField field,int x,int y){
			this.x=x;
			this.y=y;
			this.field=field;
			creatures[0]=new Xiezi();
			for(int i=1;i<7;i++)
				creatures[i]=new Minion();
		}
		public void snakecheer(){
			snake.cheer(field, 5, 9);;
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
