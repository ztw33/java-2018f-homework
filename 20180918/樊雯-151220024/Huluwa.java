package work2_huluwa;

enum Name { 老大, 老二, 老三, 老四, 老五, 老六, 老七; }
enum Color { 红色, 橙色, 黄色, 绿色, 青色, 蓝色, 紫色; }
public class Huluwa{
	 private int order; //记录现在站位
	 private int trueorder;//实际排序
	 Name name;
	 Color colour;	 

	 public Huluwa() {}
	    public Huluwa(int num,int place) {
	    	this.trueorder = num;
	        this.order = place;
	        name =Name.values()[num];
	        colour = Color.values()[num];
	    } 
	    
	    public void changeplace(int newpos){
	    	int tmp = this.order;
	    	this.order = newpos;
	    	System.out.printf(name + " :"+tmp+"->"+newpos+"  ");
	    }//换位置并向爷爷报告自己的移动；
	    
	    
	    public void getname() {
	    	System.out.printf(name + " ");
	    }
	    public void getcolor() {
	    	System.out.printf(colour + " ");
	    }
	    public void getposition() {
	    	System.out.printf(order + " ");
	    }
	    public int gettrue() {
	        return this.trueorder;
	    }
}