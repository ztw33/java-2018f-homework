//package qt;

import java.util.LinkedList;
import java.util.List;

public class Troop{
	protected List<Fighter> fighters=new LinkedList<>();
	protected Audience audience;
	public List<Fighter> getFighters() {
		return fighters;
	}
	public Audience getAudience() {
		return audience;
	}
}
