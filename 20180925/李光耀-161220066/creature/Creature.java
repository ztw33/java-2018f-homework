package creature;

public class Creature {
	private CreatureType type;
	private String name;
	private CreatureImage image;
	public Creature(CreatureType type,String name,CreatureImage image) {
		this.type=type;
		this.name=name;
		this.image=image;
	}
	public CreatureType getType(){
		return type;
	}
	public String getName(){
		return name;
	}
	public CreatureImage getImage(){
		return image;
	}	
}
