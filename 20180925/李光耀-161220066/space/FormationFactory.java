package space;

import gui.Gui;
import util.Factory;

public class FormationFactory implements Factory<Formation>{

	private static int index=-1;
	private static int monsterFormationLength=7;
	
	
	@Override
	public Formation create() {
		index=(index+1)%monsterFormationLength;
		switch (index) {
		case 0:return new CraneWing();
		case 1:return new Echelon();
		case 2:return new Equilibrium();
		case 3:return new FishScale();
		case 4:return new Diamond();
		case 5:return new CurvedMoon();
		case 6:return new Arrow();
		default:
			break;
		}
		return null;
	}

	@Override
	public Formation back() {
		if(index==0)
		{
			index=monsterFormationLength-1;
		}
		else{
			index--;
		}			
		switch (index) {
		case 0:return new CraneWing();
		case 1:return new Echelon();
		case 2:return new Equilibrium();
		case 3:return new FishScale();
		case 4:return new Diamond();
		case 5:return new CurvedMoon();
		case 6:return new Arrow();
		default:
			break;
		}
		return null;
	}
	
	public void showCurFormation(){
		switch (index) {                           
		case 0:Gui.textArea.append("妖怪处于鹤翼阵型\n");break;
		case 1:Gui.textArea.append("妖怪处于雁行阵型\n");break;
		case 2:Gui.textArea.append("妖怪处于衡遏阵型\n");break;
		case 3:Gui.textArea.append("妖怪处于鱼鳞阵型\n");break;
		case 4:Gui.textArea.append("妖怪处于方门阵型\n");break;
		case 5:Gui.textArea.append("妖怪处于偃月阵型\n");break;
		case 6:Gui.textArea.append("妖怪处于锋矢阵型\n");break;
		default:                                   
			break;                                 
		}                                          
	}
}
