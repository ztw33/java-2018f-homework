//package qt;

public class CalabashSide extends Troop{
	public CalabashSide() {
		for(int i=0;i<7;i++) {
			fighters.add(new CalabashBrother(Integer.toString(i+1)));
		}
		audience=new Grandpa();
	}
}
