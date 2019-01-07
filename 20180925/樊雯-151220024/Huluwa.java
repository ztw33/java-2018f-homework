package work3_huluwa;

enum Name { 老大, 老二, 老三, 老四, 老五, 老六, 老七; }
enum Color { 红色, 橙色, 黄色, 绿色, 青色, 蓝色, 紫色; }
public class Huluwa implements Creature{
	 private Point position; //记录现在站位
	 private Name name;
	 private Color colour;	 

	 public Huluwa() {}
	    public Huluwa(int num) {
	        name =Name.values()[num];
	        colour = Color.values()[num];
	    } 
	    
		@Override
		public Point getplace() {
		return position;
		}
		
		@Override
		public void setplace(Point position) {
	       this.position = position;
		   position.set_placeholder(this);
		}
		
		@Override
		public void report() {
			System.out.print(this.name);
		}
	    
	    public void getname() {
	    	System.out.printf(name + " ");
	    }
	    public void getcolor() {
	    	System.out.printf(colour + " ");
	    }

}
