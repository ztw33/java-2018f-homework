package homework;

public enum Cucurbit {
	RED("the first"), ORANGE("the second"), YELLOW("the third"), 
	GREEN("the forth"), BLUE("the fifth"),
	INDIGO("the sixth"), PURPLE("the seventh");
	
	private String identity;
	private Cucurbit(String identity) {
		this.identity = identity;
	}
	public String getIndetity() { return identity; }
	
}
