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
 *	@see #formMap
 *	@see #getCreature(Point)
 */
public abstract class Formation {

	/**	阵型种类 {@value}	*/
	private FormationType type;
	
	/**	阵型所占行数 {@value}	*/
	private int formRowNum;
	
	/**	阵型所占列数 {@value}	*/
	private int formColNum;
	
	/**	阵型中心 {@value}	*/
	private Point pFormCen;
	
	/**	阵型内人物的(坐标, 实体)对集合 {@value}	*/
	public Map<Point, Creature> formMap;
	
	/**	构造函数，得到属性值	*/
	protected Formation(FormationType t, int r, int c, int cr, int cc) {
		type = t;
		formRowNum = r;
		formColNum = c;
		pFormCen = new Point(cr, cc);
		formMap = new HashMap<Point, Creature>();
	}

	/**	构造函数，最简	*/
	protected Formation(FormationType t) {
		type = t;
		formMap = new HashMap<Point, Creature>();
	}

	/**	重设属性值	*/
	protected void init(int r, int c, int cr, int cc) {
		formRowNum = r;
		formColNum = c;
		pFormCen = new Point(cr, cc);
	}
	
	/**	得到阵型类型	*/
	public FormationType getType() {
		return type;
	}
	
	/**	得到阵型行数	*/
	public int getRowNum() {
		return formRowNum;
	}
	
	/**	得到阵型列数	*/
	public int getColNum() { 
		return formColNum;
	}

	/**	得到阵型中心	*/
	public Point getFormCen() {
		return pFormCen;
	}
	
	/**	得到阵型在点p处的对象	*/
	public Creature getCreature(Point p) {
		return formMap.get(p);
	}
}
