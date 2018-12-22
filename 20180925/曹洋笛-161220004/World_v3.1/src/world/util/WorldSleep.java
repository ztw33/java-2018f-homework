package world.util;

/**	
 *	让GUI世界（自动模式）沉默一会儿再进行刷新
 *	
 *	@author Mirror
 */
public class WorldSleep {

	public static void worldSleep(int time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
