
public enum HuLuWa {
	ONE("老大","红色",1,1),
	TWO("老二","橙色",2,2),
	THREE("老三","黄色",3,3),
	FOUR("老四","绿色",4,4),
	FIVE("老五","青色",5,5),
	SIX("老六","蓝色",6,6),
	SEVEN("老七","紫色",7,7);
	
	private final String name;
	private final int rankName;
	private final String color;
	private final int rankColor;
	
	HuLuWa(String name,String color,int rank1,int rank2){
		this.name=name;
		this.color=color;
		this.rankName=rank1;
		this.rankColor=rank2;
	}
	
	public String getName(){
		return name;
	}
	
	public String getColor(){
		return color;
	}

	public int getNameRank(){
		return rankName;
	}
	
	public int getColorRank(){
		return rankColor;
	}
}
