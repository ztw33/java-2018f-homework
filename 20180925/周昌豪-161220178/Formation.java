package Battle;

enum FormationType
{
	/* 阵型记录了相对位置*/
	ChangSe(Pos(0, 0), Pos(1, 0), Pos(2, 0), Pos(3, 0), Pos(4, 0), Pos(5, 0), Pos(6, 0)),
	HeYi(Pos(0, 0), Pos(1, 1), Pos(2, 2), Pos(3, 3), Pos(4, 2), Pos(5, 1), Pos(6, 0)),
	JianTu(Pos(0, 0), Pos(1, 0), Pos(1, 1), Pos(2, 2), Pos(3, 0), Pos(3, 1), Pos(4, 0)),
	YanYue(Pos(0, 0), Pos(-1, 2), Pos(0, 1), Pos(1, 1), Pos(2, 0), Pos(2, 1), Pos(3, 2)),
	FengShi(Pos(0, 0), Pos(1, 1), Pos(2, -1), Pos(2, 0), Pos(2, 2), Pos(3, 1), Pos(4, 0)),
	GongE(Pos(0, 0), Pos(1, 1), Pos(2, 0), Pos(3, 1), Pos(4, 0), Pos(5, 1), Pos(6, 0));
	
	private Position list[];
	public static final int FormationCreatureNum =   7;
	
	FormationType(Position p0, Position p1, Position p2, Position p3,
			Position p4, Position p5, Position p6)
	{
		list = new Position[FormationCreatureNum];
		list[0] = p0; list[1] = p1; list[2] = p2; list[3] = p3;
		list[4] = p4; list[5] = p5; list[6] = p6;
	}
	
	private static Position Pos(int i, int j) 
	{
		return new Position(i, j);
	}

	public Position[] GetList()
	{
		return list.clone();
	}
}

public class Formation
{
	public static Position[] GetRandomFormation()
	{
		int random = (int)(Math.random()* FormationType.values().length);
		//FormationType[] menu =  FormationType.values().clone();
		return FormationType.values()[random].GetList();
	}
}