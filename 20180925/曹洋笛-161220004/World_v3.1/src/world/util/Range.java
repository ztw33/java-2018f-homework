package world.util;

/**	
 *	界定世界范围和特殊点.
 *	左侧战场和右侧战场的中心点（葫芦娃和妖怪阵型初始位置点）
 *	啦啦队初始位置点
 *	
 *	@author Mirror
 */
public class Range {

	/**	行数 {@value} */
	public static final int rowNum = 17; // 0 ~ 16
	
	/**	列数 {@value} */
	public static final int colNum = 18; // 0 ~ 17
	
	/**	左侧战场中心点 */
	public static final Point leftCenterP = new Point(8, 4);

	/**	右侧战场中心点 */
	public static final Point rightCenterP = new Point(8, 13);	

	/**	老爷爷初始位置点 */
	public static final Point originElder = new Point(3, 6);

	/**	蛇精初始位置点 */
	public static final Point originSnake = new Point(13, 11);
}
