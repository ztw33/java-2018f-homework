
public enum CalabashBro {
	CB1("老大","红色",1),
	CB2("老二","橙色",2),
	CB3("老三","黄色",3),
	CB4("老四","绿色",4),
	CB5("老五","青色",5),
	CB6("老六","蓝色",6),
	CB7("老七","紫色",7);

    private int order;
    private String name;
    private String color;

    private CalabashBro(String name,String color,int order)
    {
        this.name = name;
        this.color = color;
        this.order = order;
    }

    public String getName() {
    	return name;
    }

    public String getColor() {
    	return color;
    }
    
    public int getOrder() {
    	return order;
	}
    
    public void tellName() {
		System.out.print(name+" ");
	}
    
    public void tellColor() {
		System.out.print(color+" ");
	}
    
    public void tellPosEx(int i,int j) {
    	System.out.print(name+": "+i+" -> "+j+"\n");
    }
}
