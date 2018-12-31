package cala;
enum Color{red,orange,yellow,green, cyan,blue,purple};
public class CalabashBrothers {
	//public enum Color{red,orange,yellow,green, cyan,bule,purple};
	String name;
	int index;
	Color color;
	CalabashBrothers()
	{}
	
	CalabashBrothers(String n,int i,Color c)
	 {	super();
		 this.name=n;
		 this.index=i;
		 this.color=c;
	 }
}