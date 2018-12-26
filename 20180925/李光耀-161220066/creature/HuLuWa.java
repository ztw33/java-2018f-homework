package creature;


/**
* @ClassName: HuLuWa
* @Description: 葫芦娃类 rank用于刻画兄弟之间序的关系
* @author 13745
* @date 2018年11月4日
*
*/
public class HuLuWa extends GoodCreature{
	//额外增添属性rank 用于排序整理操作
	private int rank;
	public HuLuWa(String name,StyleImage image,int rank) {
		super(name,image);
		this.rank=rank;
	}
	public int getRank(){
		return rank;
	}
}
