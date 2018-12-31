package creature;

import creature.OneCalabash;

public class CalabashBrothers {
	public OneCalabash[] sevenBro = new OneCalabash[7];
	public CalabashBrothers() {
		sevenBro[0] = new OneCalabash(0, "红色", COLOR.RED, "老大");
		sevenBro[1] = new OneCalabash(1, "橙色", COLOR.ORANGE, "老二");
		sevenBro[2] = new OneCalabash(2, "黄色", COLOR.YELLOW, "老三");
		sevenBro[3] = new OneCalabash(3, "绿色", COLOR.GREEN, "老四");
		sevenBro[4] = new OneCalabash(4, "青色", COLOR.CYAN, "老五");
		sevenBro[5] = new OneCalabash(5, "蓝色", COLOR.BLUE, "老六");
		sevenBro[6] = new OneCalabash(6, "紫色", COLOR.PURPLE, "老七");
	}
}
