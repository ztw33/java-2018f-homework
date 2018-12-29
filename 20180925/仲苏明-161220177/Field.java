package calabashbrothers;

import java.util.Random;
import java.util.Scanner;

public class Field {
	static char[][] space=new char[13][13];
	
	public static void c_queue(calabash[] bros) {
		System.out.println("葫芦娃列阵：");
		for(int i=0;i<7;i++) {
			bros[i].getposition(i+3, 2);
			space[i+3][2]=bros[i].symbol;
		}
	}
	
	@SuppressWarnings({ "static-access", "resource" })
	public static Formation formachose() {
		System.out.println("选择小喽啰阵型：\n"
				+ "1鹤翼\n"
				+ "2雁行\n"
				+ "3衝軛\n"
				+ "4长蛇\n"
				+ "5鱼鳞\n"
				+ "6方円\n"
				+ "7偃月\n"
				+ "8锋矢\n"
				);
		Formation forma=new Formation();
		Scanner in =new Scanner(System.in);
		forma.Fid=in.nextInt();
		forma.formachose();
		//forma =new Formation();
		System.out.println("小喽啰列阵：");
		//Formation forma = new Formation(id);
		return forma;
	}
	
	@SuppressWarnings("static-access")
	public static void s_queue(Formation forma,scorpion scorp,minion[] minis) {
		scorp.getposition(forma.sx, forma.sy);
		space[forma.sx][forma.sy]=scorp.symbol;
		System.out.println(forma.num);
//		for(int i=0;i<forma.num;i++) {
//			System.out.println(forma.y[i]);
//		}
		for(int i=0;i<forma.num;i++) {
			//System.out.println(forma.x[i]);
			//System.out.println(forma.y[i]);
			//System.out.println(minis[i].symbol);
			minis[i].getposition(forma.x[i], forma.y[i]);
			space[forma.x[i]][forma.y[i]]=minis[i].symbol;
		}
	}
	
	public static void g_join(grandpa grandpa) {
		System.out.println("爷爷加入助威：");
		Random random=new Random();
		grandpa.getposition(random.nextInt(1)+10,random.nextInt(1));
		space[grandpa.loc_x][grandpa.loc_y]=grandpa.symbol;
	}
	
	public static void s_join(snake snake) {
		System.out.println("蛇精加入助威：");
		Random random=new Random();
		snake.getposition(random.nextInt(1),random.nextInt(1)+11);
		space[snake.loc_x][snake.loc_y]=snake.symbol;
	}
	
	public static void show() {
		for(int i=0;i<13;i++) {
			for(int j=0;j<13;j++) {
				System.out.print(space[i][j]);
			}
			System.out.println("\t");
		}
	}
}
