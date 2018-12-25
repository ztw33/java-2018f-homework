package common;

/**
 * @Description
 * @Author LUCUS BAI
 * @Date 2018/12/3
 */
public class Delay {
    public static void delay(int delayTime) {
        try {
            Thread.sleep(delayTime);
        } catch (Exception e) {
            System.out.println("[ERROR] In Delay.delay()");
            System.exit(0);//退出程序
        }
    }
}
