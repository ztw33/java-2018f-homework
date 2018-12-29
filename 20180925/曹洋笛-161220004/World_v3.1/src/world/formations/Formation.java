package world.formations;

import java.util.HashMap;
import java.util.Map;

import world.creatures.Creature;
import world.util.*;

/**
 *	阵型抽象类.
 *	所有行数列数均从 0 开始
 *
 *	@author Mirror
 *	
 *	@see #type
 *	@see #pFormCen
 *	@see #formMap
 *	@see #isOccupied(Point)
 *	@see #getFormMap()
 */
public abstract class Formation<T extends Creature> {
		
	/**	阵型种类 {@value} */
	private FormationType type;
	
	/**	阵型所占行数 {@value} */
	private int formRowNum;
	
	/**	阵型所占列数 {@value} */
	private int formColNum;
	
	/**	阵型中心 {@value} */
	private Point pFormCen;
	
	/**	阵型内人物的(坐标, 实体)对集合 {@value} */
	public Map<Point, T> formMap;
	
	/**	构造函数，得到属性值 */
	protected Formation(FormationType t, int r, int c, int cr, int cc) {
		type = t;
		formRowNum = r;
		formColNum = c;
		pFormCen = new Point(cr, cc);
		formMap = new HashMap<Point, T>();
	}
	
	/**	得到阵型类型 */
	public FormationType getType() {
		return type;
	}
	
	/**	得到阵型行数 */
	public int getRowNum() {
		return formRowNum;
	}
	
	/**	得到阵型列数 */
	public int getColNum() { 
		return formColNum;
	}

	/**	得到阵型中心 */
	public Point getFormCen() {
		return pFormCen;
	}
	
	/**	得到阵型在点p处的对象 */
	public T getCreature(Point p) {
		return formMap.get(p);
	}
	
	/**	某处是否有人
	 *	@param p 位置p
	 *	@return {@code true}: 有人; {@code false}: 无人 */
	public boolean isOccupied(Point p) {
		return (formMap.containsKey(p));
	}
	/**	@see #isOccupied(Point) */
	public boolean isOccupied(int r, int c) {
		return isOccupied(new Point(r, c));
	}
		
	/**	打印阵型(终端字符显示). 这是调试用函数，并不用在最终程序中 */
	public void showFormation() {
		for (int i = 0; i < formRowNum; i++) {
			for (int j = 0; j < formColNum; j++) {
				Point p = new Point(i, j);
				if (isOccupied(p))
					System.out.print(getCreature(p).getSymbol() + " ");
				else
					System.out.print("  ");
			}
			System.out.println();
		}
	}
}
