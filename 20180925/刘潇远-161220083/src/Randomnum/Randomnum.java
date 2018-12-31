package java2018.CalabashBrother.Randomnum;
import java.util.Random;
public class Randomnum {
	static Random r = new Random();
	public static int getRandom(int upLine) {
		//long t = System.currentTimeMillis();
		//Random r = new Random();
		return r.nextInt(upLine);
	}
}
