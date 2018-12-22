package calabash;

public class CalabashBrothers extends Creature{		
	CalabashBrothers(int i){
		if(i == 0)
			name = "大娃";
		else if(i == 1)
			name = "二娃";
		else if(i == 2)
			name = "三娃";
		else if(i == 3)
			name = "四娃";
		else if(i == 4)
			name = "五娃";
		else if(i == 5)
			name = "六娃";
		else if(i == 6)
			name = "七娃";
	}
	
	public String getName() {
		return name;
	}
}
