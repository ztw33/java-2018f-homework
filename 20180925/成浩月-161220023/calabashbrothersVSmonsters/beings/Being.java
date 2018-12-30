package beings;

import java.awt.*;
/*import java.io.*;
import java.net.*;*/

//import javax.swing.ImageIcon;

public abstract class Being implements Behave {
	/*不可用于直接创建对象*/
	//每一种“存在”都是有名字的,也有对应的图片和路径
	String name;
	//String imagepath;
	public Image image;
	public Being(String name){
		/*this.name=name;
		try {
			File directory = new File("");
			imagepath=directory.getCanonicalPath()+"\\beings\\additions";
		}catch(IOException e) {
			System.out.println("error "+e);
		}*/
		/*java.net.URL imgURL = this.getClass().getResource("pic/1.jpg");
		Icon startIcon = new ImageIcon(imgURL);*/
	}
}
