package beings;

import java.awt.Toolkit;
/*import java.io.*;
import javax.imageio.*;*/

public class Hogwash extends Follower implements Battle {

	public Hogwash() {
		super("老鼠精");
		// TODO 自动生成的构造函数存根
		/*this.imagepath=this.imagepath+"\\hogwash.jpg";
		try {
			image=ImageIO.read(new File(imagepath));
		}catch(IOException e) {
			System.out.println("error "+e);
		}*/
		/*java.net.URL imgURL = this.getClass().getResource("/beings/additions/hogwash.jpg");
		try {
			image = ImageIO.read(new File(imgURL.getFile()));
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}*/
		image = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/additions/hogwash.jpg"));
	}

	@Override
	public void behave() {
		// TODO 自动生成的方法存根
		
	}

}
