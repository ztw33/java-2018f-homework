package space;

import gui.Gui;

//向外暴露
public class Formation {
	protected int num;	//所占的方块个数
	protected Square[] formation;
	
	protected static int broadxLines=Gui.N;
	protected static int broadyLines=Gui.N;
	
	private static int index=-1;
	
	private static int formationLength=7;
	
	public static Formation getNextMonsterFormation(){
		index=(index+1)%formationLength;
		switch (index) {
		case 0:Gui.textArea.append("妖怪处于鹤翼阵型\n");return new CraneWing();
		case 1:Gui.textArea.append("妖怪处于雁行阵型\n");return new Echelon();
		case 2:Gui.textArea.append("妖怪处于衡遏阵型\n");return new Equilibrium();
		case 3:Gui.textArea.append("妖怪处于鱼鳞阵型\n");return new FishScale();
		case 4:Gui.textArea.append("妖怪处于方门阵型\n");return new Diamond();
		case 5:Gui.textArea.append("妖怪处于偃月阵型\n");return new CurvedMoon();
		case 6:Gui.textArea.append("妖怪处于锋矢阵型\n");return new Arrow();
		default:
			break;
		}
		return null;
	}
	
	public static Formation getPreMonsterFormation(){
		if(index==0)
		{
			index=formationLength-1;
		}
		else{
			index--;
		}			
		switch (index) {
		case 0:Gui.textArea.append("妖怪处于鹤翼阵型\n");return new CraneWing();
		case 1:Gui.textArea.append("妖怪处于雁行阵型\n");return new Echelon();
		case 2:Gui.textArea.append("妖怪处于衡遏阵型\n");return new Equilibrium();
		case 3:Gui.textArea.append("妖怪处于鱼鳞阵型\n");return new FishScale();
		case 4:Gui.textArea.append("妖怪处于方门阵型\n");return new Diamond();
		case 5:Gui.textArea.append("妖怪处于偃月阵型\n");return new CurvedMoon();
		case 6:Gui.textArea.append("妖怪处于锋矢阵型\n");return new Arrow();
		default:
			break;
		}
		return null;
	}
	
	public static Formation getHuLuFormation(){
		return new LongSnake();
	}
	public Formation(int num) {
		this.num=num;
		formation=new Square[num];
	}
	
	public Square[] getFormation(){
		return formation;
	}
}





