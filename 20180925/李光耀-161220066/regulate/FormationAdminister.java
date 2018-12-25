package regulate;

import space.Formation;
import space.FormationFactory;
import space.LongSnake;

/**
* @ClassName: FormationAdminister
* @Description: 循环生成阵型
* @author 13745
* @date 2018年11月4日
*
*/
public class FormationAdminister {
//	private static int index=-1;
//	private static int monsterFormationLength=7;
	
	public  Formation getNextMonsterFormation(){
		return new FormationFactory().create();
//		index=(index+1)%monsterFormationLength;
//		switch (index) {
//		case 0:Gui.textArea.append("妖怪处于鹤翼阵型\n");return new CraneWing();
//		case 1:Gui.textArea.append("妖怪处于雁行阵型\n");return new Echelon();
//		case 2:Gui.textArea.append("妖怪处于衡遏阵型\n");return new Equilibrium();
//		case 3:Gui.textArea.append("妖怪处于鱼鳞阵型\n");return new FishScale();
//		case 4:Gui.textArea.append("妖怪处于方门阵型\n");return new Diamond();
//		case 5:Gui.textArea.append("妖怪处于偃月阵型\n");return new CurvedMoon();
//		case 6:Gui.textArea.append("妖怪处于锋矢阵型\n");return new Arrow();
//		default:
//			break;
//		}
//		return null;
	}
	
	public  Formation getPreMonsterFormation(){
		return new FormationFactory().back();
//		if(index==0)
//		{
//			index=monsterFormationLength-1;
//		}
//		else{
//			index--;
//		}			
//		switch (index) {
//		case 0:Gui.textArea.append("妖怪处于鹤翼阵型\n");return new CraneWing();
//		case 1:Gui.textArea.append("妖怪处于雁行阵型\n");return new Echelon();
//		case 2:Gui.textArea.append("妖怪处于衡遏阵型\n");return new Equilibrium();
//		case 3:Gui.textArea.append("妖怪处于鱼鳞阵型\n");return new FishScale();
//		case 4:Gui.textArea.append("妖怪处于方门阵型\n");return new Diamond();
//		case 5:Gui.textArea.append("妖怪处于偃月阵型\n");return new CurvedMoon();
//		case 6:Gui.textArea.append("妖怪处于锋矢阵型\n");return new Arrow();
//		default:
//			break;
//		}
//		return null;
	}
	
	public  Formation getHuLuFormation(){
		return new LongSnake();
	}
}
