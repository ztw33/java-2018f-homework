package square;
public class EnemyQueue {
	enum Formation{
		CHANGSHE("≥§…ﬂ’Û"),
		HEYI("∫◊“Ì’Û"),
		YANXING("—„––’Û"),
		CHONGE("–n‹ó’Û"),
		YULIN("”„¡€’Û"),
		FANGYUAN("∑ΩÉ“’Û"),
		YANYUE("Ÿ»‘¬’Û"),
		FENGSHI("∑Ê ∏’Û");
		Formation(String name){
			this.name=name;
		}
		String name;
	};
	
	private Formation mode;
	private Member [][]queue;
	private int row,col;
	
	EnemyQueue(){
		int m = (int)(1+Math.random()*6);
		mode=Formation.values()[m];
		setQueue();
	}
	
	public void requeue() {
		int m = (int)(1+Math.random()*7);
		while(mode==Formation.values()[m])
			m = (int)(1+Math.random()*7);;
		mode=Formation.values()[m];
		setQueue();
	}
	
	private void setQueue() {				//–´◊”æ´∫Õ‡∂¬ﬁ√«µƒ∂”–Œ
		switch(mode) {
		case CHANGSHE:
			break;
		case HEYI:
			queue=new Member[7][4];
			row=7;
			col=4;
			clear();
			queue[0][0]=Member.UNDERLING;
			queue[1][1]=Member.UNDERLING;
			queue[2][2]=Member.UNDERLING;
			queue[3][3]=Member.SCORPION;
			queue[4][2]=Member.UNDERLING;
			queue[5][1]=Member.UNDERLING;
			queue[6][0]=Member.UNDERLING;
			break;
		case YANXING:
			queue=new Member[7][7];
			row=7;
			col=7;
			clear();
			queue[0][0]=Member.UNDERLING;
			queue[1][1]=Member.UNDERLING;
			queue[2][2]=Member.UNDERLING;
			queue[3][3]=Member.SCORPION;
			queue[4][4]=Member.UNDERLING;
			queue[5][5]=Member.UNDERLING;
			queue[6][6]=Member.UNDERLING;
			break;
		case CHONGE:
			queue=new Member[7][2];
			row=7;
			col=2;
			clear();
			queue[0][1]=Member.UNDERLING;
			queue[1][0]=Member.UNDERLING;
			queue[2][1]=Member.UNDERLING;
			queue[3][0]=Member.SCORPION;
			queue[4][1]=Member.UNDERLING;
			queue[5][0]=Member.UNDERLING;
			queue[6][1]=Member.UNDERLING;
			break;
		case YULIN:
			queue=new Member[7][5];
			row=7;
			col=5;
			clear();
			queue[0][3]=Member.UNDERLING;
			queue[1][2]=Member.UNDERLING;
			queue[2][1]=Member.UNDERLING;
			queue[2][3]=Member.UNDERLING;
			queue[3][0]=Member.UNDERLING;
			queue[3][2]=Member.SCORPION;
			queue[3][4]=Member.UNDERLING;
			queue[4][3]=Member.UNDERLING;
			queue[5][2]=Member.UNDERLING;
			queue[6][3]=Member.UNDERLING;
			break;
		case FANGYUAN:
			queue=new Member[5][5];
			row=5;
			col=5;
			clear();
			queue[0][2]=Member.UNDERLING;
			queue[1][1]=Member.UNDERLING;
			queue[1][3]=Member.UNDERLING;
			queue[2][0]=Member.UNDERLING;
			queue[2][4]=Member.SCORPION;
			queue[3][1]=Member.UNDERLING;
			queue[3][3]=Member.UNDERLING;
			queue[4][2]=Member.UNDERLING;
			break;
		case YANYUE:
			queue=new Member[9][5];
			row=9;
			col=5;
			clear();
			queue[0][3]=Member.UNDERLING;
			queue[0][4]=Member.UNDERLING;
			queue[1][2]=Member.UNDERLING;
			queue[1][3]=Member.UNDERLING;
			queue[2][1]=Member.UNDERLING;
			queue[2][2]=Member.UNDERLING;
			queue[3][0]=Member.UNDERLING;
			queue[3][1]=Member.UNDERLING;
			queue[3][2]=Member.UNDERLING;
			
			queue[4][0]=Member.UNDERLING;
			queue[4][1]=Member.UNDERLING;
			queue[4][2]=Member.SCORPION;
			
			queue[5][0]=Member.UNDERLING;
			queue[5][1]=Member.UNDERLING;
			queue[5][2]=Member.UNDERLING;
			queue[6][1]=Member.UNDERLING;
			queue[6][2]=Member.UNDERLING;
			queue[7][2]=Member.UNDERLING;
			queue[7][3]=Member.UNDERLING;
			queue[8][3]=Member.UNDERLING;
			queue[8][4]=Member.UNDERLING;
			break;
		case FENGSHI:
			queue=new Member[7][6];
			row=7;
			col=6;
			clear();
			queue[0][3]=Member.UNDERLING;
			queue[1][2]=Member.UNDERLING;
			queue[2][1]=Member.UNDERLING;
			
			queue[3][0]=Member.UNDERLING;
			queue[3][1]=Member.UNDERLING;
			queue[3][2]=Member.UNDERLING;
			queue[3][3]=Member.SCORPION;
			queue[3][4]=Member.UNDERLING;
			queue[3][5]=Member.UNDERLING;
			
			queue[4][1]=Member.UNDERLING;
			queue[5][2]=Member.UNDERLING;
			queue[6][3]=Member.UNDERLING;

			break;
		default:break;
		}
	}

	private void clear() {
		for(int i = 0;i<row;i++) {
			for(int j = 0;j<col;j++)
				queue[i][j]=Member.EMPTY;
		}
	}
	
	public Member[][] getQueue() {
		return queue;
	}
	public int getRow() {
		return row;
	}
	public int getCol() {
		return col;
	}
	public String getQueueName() {
		return mode.name;
	}
}
