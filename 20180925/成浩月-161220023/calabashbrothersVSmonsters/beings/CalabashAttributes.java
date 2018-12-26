package beings;

import java.awt.Color;

//改变了原先将枚举类型定义在CalabashBrother类中的做法(那样的话葫芦娃创建对象仍然要传入一个index的参数)
//现在葫芦娃创建对象必须传入一个此枚举类型作为参数以此来限制葫芦娃的种类
public enum CalabashAttributes {
	FIRST("大娃",Color.RED,"/c1.jpg"),SECOND("二娃",Color.ORANGE,"/c2.jpg"),THIRD("三娃",Color.YELLOW,"/c3.jpg"),FOURTH("四娃",Color.GREEN,"/c4.jpg"),FIFTH("五娃",Color.CYAN,"/c5.jpg"),SIXTH("六娃",Color.BLUE,"/c6.jpg"),SEVENTH("七娃",new Color(160,32,240),"/c7.jpg");
	String name;
	Color color;
	String path;
	CalabashAttributes(String name,Color color,String path){
		this.name=name;
		this.color=color;
		this.path=path;
	}
}
