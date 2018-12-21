package world.util;

import java.util.Objects;

import world.Global;

/**
 *	以行列定位的点类型
 *	
 *	@author Mirror
 *
 *	@see #pRow
 *	@see #pCol
 *	@see #row()
 *	@see #col()
 *	@see #equals(Object)
 *	@see #hashCode()
 *	@see #inWorld()
 *	@see #reset()
 *	@see #copy()
 *	@see #reverse()
 *	@see #mov(Point)
 *	@see #distance(Point)
	*/
public final class Point {

	/**	行定位	*/
	private int pRow;
	/**	列定位	*/
	private int pCol;

	/**	构造函数	*/
	public Point(int r, int c) {
		pRow = r;
		pCol = c;
	}
	
	/**	得到点所在行数	*/
	public int row() {
		return pRow;
	}

	/**	得到点所在列数	*/
	public int col() {
		return pCol;
	}

	/**	重写 Object 的 {@code Object.equals(key, k)} 方法.
	 *	由于 {@code Formation.formMap} 寻找键值的 {@code formMap.containsKey(point)} 使用的是
	 *	类 Object 的 {@code Object.equals(key, k)} 方法，而且使用了HashCode，
	 *	因而需要重写以保证比较的是值而非地址
	 *
	 *	@param obj 与此点比较行列位置比较
	 *	@return boolean 是否相等 	*/
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (obj instanceof Point) {
			Point p = (Point) obj;
			return ((this.pRow == p.pRow) && (this.pCol == p.pCol));
		}
		return false;
	}
	
	/**	重写 Object 的 {@code Object.hashCode()} 方法.
	 *	对于 Map 类型（HashMap），重写 equals 的同时也要重写 hashCode，
	 *	因为 hashCode 的值是根据地址引用计算的而不是根据值	*/
	@Override
	public int hashCode() {
		return Objects.hash(pRow, pCol);
	}

	/**	@param pLU 某长方范围的左上角行列坐标
	 *	@param pRD 某长方范围的右下角行列坐标
	 *	@return boolean 此点是否在该长方范围内	*/
	public boolean in(Point pLU, Point pRD) {
		return ((pRow >= pLU.row()) && (pRow <= pRD.row()) && (pCol >= pLU.col()) && (pCol <= pRD.col()));
	}

	/**	此点是否在世界范围内	*/
	public boolean inWorld() {
		return in(new Point(0, 0), new Point(Global.rowNum - 1, Global.colNum - 1));
	}
	
	/**	为此点重设行列坐标为点p	*/
	public void reset(Point p) {
		pRow = p.pRow;
		pCol = p.pCol;
	}

	/**	为此点重设行列坐标为(r, c)	*/
	public void reset(int r, int c) {
		pRow = r;
		pCol = c;
	}
	
	/**	得到一个复制的点	*/
	public Point copy() {
		return new Point(pRow, pCol);
	}

	/**	得到一个反向的点	*/
	public Point reverse() {
		return new Point(-pRow, -pCol);
	}
	
	/**	得到距离p点的行列差之和	*/
	public int distance(Point p) {
		return (Math.abs(pRow - p.pRow) + Math.abs(pCol - p.pCol));
	}
	
	/**	向右下方向移动此点，相对位移(d.row(), d.col())	*/
	public Point mov(Point d) {
		if (d == null) return this.copy();
		return new Point(pRow + d.pRow, pCol + d.pCol);
	}
	
	/**	打印此点	*/
	public String show() {
		return ("(" + pRow + "," + pCol + ")");
	}
}
