package home3;

//enum fname{鹤翼,雁行,衡轭,长蛇,鱼鳞,方门,偃月,锋矢}

public class Formation {
	private String fname;
	
	public Formation() {
		fname = "战场阵型";
	}
	
	public void initformation(String name,Creature start, Creature cre[], Battleground battle,Space ground[][]) {
		
		int startx = start.getx();//设置起始点（爷爷或者蛇精）
		int starty = start.gety();
		switch(name) {
		case "鹤翼":
			System.out.println("摆出鹤翼阵");
			start.GoBattle(ground[startx][starty]);
			battle.getscorpion().GoBattle(ground[startx+3][starty-5]);
			for(int i = 0; i < cre.length;i++) {
				
				if(i < 4)
					cre[i].GoBattle(ground[startx-3+i][starty-5+i]);
				else
					cre[i].GoBattle(ground[startx-3+i][starty+1-i]);
			}break;
			
		case "雁行":
			System.out.println("摆出雁行阵");
			start.GoBattle(ground[startx][starty]);
			battle.getscorpion().GoBattle(ground[startx+3][starty]);
			for(int i = 0; i < cre.length;i++) {
				cre[i].GoBattle(ground[startx-3+i][starty-6+i]);
			}break;
			
		case "衡轭":
			System.out.println("摆出鹤衡轭阵");
			start.GoBattle(ground[startx][starty]);
			battle.getscorpion().GoBattle(ground[startx+1][starty-1]);
			for(int i = 0; i < cre.length;i++) {
				cre[i].GoBattle(ground[startx +1- i%2][starty -7 + i]);
			}break;
			
		case "长蛇":
			//System.out.println("摆出长蛇阵");
			start.GoBattle(ground[startx][starty]);
			for(int i = 0; i < cre.length;i++) {
				cre[i].GoBattle(ground[startx][starty+1+i]);
			}break;
			
		case "鱼鳞":
			System.out.println("摆出鱼鳞阵");
			start.GoBattle(ground[startx][starty]);
			battle.getscorpion().GoBattle(ground[startx][starty-4]);
			for(int i = 0; i < cre.length;i++) {
				if(i < 5)
					cre[i].GoBattle(ground[startx-2+i][starty-2-i%2]);
				/*else if(i == 5)
					cre[i].GoBattle(ground[startx][starty-4]);*/
				else
					cre[i].GoBattle(ground[startx+3][starty-2]);
			}break;
			
		case "方门":
			System.out.println("摆出方门阵");
			start.GoBattle(ground[startx][starty]);
			battle.getscorpion().GoBattle(ground[startx-1][starty+1]);
			for(int i = 0; i < cre.length;i++) {
				if(i ==0)
					cre[i].GoBattle(ground[startx][starty-2]);
				else if(i < 4)
					cre[i].GoBattle(ground[startx+2-i%2][starty-2+i]);
				else
					cre[i].GoBattle(ground[startx-1-i%2][starty-5+i]);
					
			}break;
			
		case "偃月":
			System.out.println("摆出偃月阵");
			start.GoBattle(ground[startx][starty]);
			battle.getscorpion().GoBattle(ground[startx+3][starty-4]);
			for(int i = 0; i < cre.length;i++) {
				if(i == 0)
					cre[i].GoBattle(ground[startx][starty-1]);
				else
					cre[i].GoBattle(ground[startx+2-i%2][starty-7+i]);
			}break;
			
		case "锋矢":
			System.out.println("摆出锋矢阵");
			start.GoBattle(ground[startx][starty]);
			battle.getscorpion().GoBattle(ground[startx+1][starty-5]);
			for(int i = 0; i < cre.length;i++) {
				if(i < 5)
					cre[i].GoBattle(ground[startx][starty-6+i]);
				else
					//cre[i].GoBattle(ground[(int) (startx + Math.pow(-1, i%2))][starty-5]);
					cre[i].GoBattle(ground[startx-1][starty-5]);
			}break;
		}
	}
}
