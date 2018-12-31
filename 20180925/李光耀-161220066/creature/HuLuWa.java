package creature;


public class HuLuWa extends Creature{
	
	//额外增添属性rank 用于排序整理操作
	private int rank;
	public HuLuWa(String name,CreatureImage image,int rank) {
		super(CreatureType.HULUWA,name,image);
		this.rank=rank;
	}
	public int getRank(){
		return rank;
	}
}
