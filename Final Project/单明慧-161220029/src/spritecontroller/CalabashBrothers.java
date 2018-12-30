package spritecontroller;

import java.util.ArrayList;

import spritecontroller.OneCalabash;

public class CalabashBrothers {
	public OneCalabash[] sevenBro = new OneCalabash[7];
	public CalabashBrothers() {
		sevenBro[0] = new OneCalabash(0, "红色", COLOR.RED, "老大",10,200, 30, 10);
		sevenBro[1] = new OneCalabash(1, "橙色", COLOR.ORANGE, "老二", 8, 200, 30 ,20);
		sevenBro[2] = new OneCalabash(2, "黄色", COLOR.YELLOW, "老三", 8, 200, 30, 20);
		sevenBro[3] = new OneCalabash(3, "绿色", COLOR.GREEN, "老四", 6, 200, 35, 15);
		sevenBro[4] = new OneCalabash(4, "青色", COLOR.CYAN, "老五", 6, 200, 35, 15);
		sevenBro[5] = new OneCalabash(5, "蓝色", COLOR.BLUE, "老六", 8, 200, 30, 20);
		sevenBro[6] = new OneCalabash(6, "紫色", COLOR.PURPLE, "老七", 10, 200 ,30, 15);
		 for(int i = 0; i < 7; i++) {//加载图像
			   String path = "file:pics/" + (i + 1) + ".png";
			   sevenBro[i].loadImage(path);
		 }
	}
	
	public void getThreads(ArrayList<Thread> t) {
		for(int i = 0; i < 7; i++) {
			Thread t1 = new Thread(sevenBro[i]);
			t.add(t1);
		}
	}
}
