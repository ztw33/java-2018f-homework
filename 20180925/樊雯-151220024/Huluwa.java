package work3_huluwa;

enum Name { �ϴ�, �϶�, ����, ����, ����, ����, ����; }
enum Color { ��ɫ, ��ɫ, ��ɫ, ��ɫ, ��ɫ, ��ɫ, ��ɫ; }
public class Huluwa implements Creature{
	 private Point position; //��¼����վλ
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
