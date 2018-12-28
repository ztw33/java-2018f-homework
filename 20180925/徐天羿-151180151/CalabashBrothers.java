package calabash;

public final class CalabashBrothers extends Creature {	
	int rank;  //用于给葫芦娃排序；
	
	CalabashBrothers(CalabashColor cala){
		name = cala.getName();
		rank = cala.getOrder();
		type = 0;
	}
	
	public int getRank() {
		return rank;
	}
}