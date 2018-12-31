package beings;

import java.awt.Toolkit;
/*import java.io.*;
import javax.imageio.ImageIO;*/

public class Grandpa extends Good implements CheerUp{
	
	public Grandpa() {
		super("爷爷");
		// TODO 自动生成的构造函数存根
		/*this.imagepath=this.imagepath+"\\grandpa.jpg";
		try {
			image=ImageIO.read(new File(imagepath));
		}catch(IOException e) {
			System.out.println("error "+e);
		}*/
		/*java.net.URL imgURL = this.getClass().getResource("/beings/additions/grandpa.jpg");
		try {
			image = ImageIO.read(new File(imgURL.getFile()));
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}*/
		image = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/additions/grandpa.jpg"));
	}

	@Override
	public void behave() {
		// TODO 自动生成的方法存根
		System.out.println("加油啊小崽子们");
	}

}
