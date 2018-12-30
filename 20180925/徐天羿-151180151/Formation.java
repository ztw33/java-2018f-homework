package calabash;
import java.util.ArrayList;

public abstract class Formation<T extends Creature> {
	Field area;
	ArrayList<Integer> locationX = new ArrayList<Integer>();
	ArrayList<Integer> locationY = new ArrayList<Integer>();
	
	Formation(){
		
	}
	
	protected Formation(Field iarea){
		area = iarea;
	}
	
	public final void setCre(T cre, int x, int y) {  //在阵型中放置单个生物；
		cre.updatePosition(x, y);
		area.updateField(x, y, cre);
	}
	
	public void setFormation(ArrayList<T> mons) {  //放置完整的阵型；
		for(int i = 0; i < locationX.size(); i++) {
			setCre(mons.get(i), locationX.get(i), locationY.get(i));
		}
	}
	
	public int getSize() {  //获取阵型需要的生物数；
		return locationX.size();
	}
}