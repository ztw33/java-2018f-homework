package homework2;

enum Name {老大,老二,老三,老四,老五,老六,老七}
enum Color {红色,橙色,黄色,绿色,青色,蓝色,紫色}

public class CalabashBro {
	public Color brocolor;
	public Name broname;
	
	CalabashBro(Name name, Color color){//初始化
		this.broname = name;
		this.brocolor = color;
	}

	public void printname(){
		System.out.print(broname+ " ");
	}

	public void printcolor(){
		System.out.print(brocolor+ " ");
	}

	public void printPoschange(int Old,int New)
	{
		 System.out.println(broname+":"+Old+"->"+New);
	}

}