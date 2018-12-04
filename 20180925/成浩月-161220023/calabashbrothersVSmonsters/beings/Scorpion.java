package beings;

import java.awt.Toolkit;
/*import java.io.*;
import javax.imageio.ImageIO;*/

public class Scorpion extends Bad implements Battle {

	public Scorpion() {
		super("蝎子精");
		// TODO 自动生成的构造函数存根
		/*this.imagepath=this.imagepath+"\\scorpion.jpg";
		try {
			image=ImageIO.read(new File(imagepath));
		}catch(IOException e) {
			System.out.println("error "+e);
		}*/
		/*java.net.URL imgURL = this.getClass().getResource("/beings/additions/scorpion.jpg");
		try {
			image = ImageIO.read(new File(imgURL.getFile()));
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}*/
		image = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/additions/scorpion.jpg"));
	}

	@Override
	public void behave() {
		// TODO 自动生成的方法存根
		System.out.println("兄弟们给我拿下他们");
	}

}
