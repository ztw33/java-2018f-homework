package world;

import world.creatures.*;
import world.formations.*;
import world.util.*;

/**
 *	里世界，世界的基础. <br>
 *	用于终端显示整个世界
 *
 *	@author Mirror
 *	 
 *	@see Creature
 *	@see Formation
 *	@see #broForm
 *	@see #monForm
 *	@see #snake
 *	@see #elder
 *	@see #pBroCen
 *	@see #pMonCen
 *	@see #pEld
 *	@see #pSnk
 *	@see #movGroup(GroupType, Point)
 *	@see #changeFormation(FormationType)
 *	@see #showWorld()
 */
public class CharWindow {

	// 对象
	/**	定义葫芦娃阵型对象 */
	public Formation<Brothers> broForm;
	/**	定义妖怪阵型对象 */
	public Formation<Monsters> monForm;
	/**	蛇精对象 */
	public Snake snake = new Snake();
	/**	老爷爷对象 */
	public Elder elder = new Elder();

	// 定位
	/**	地图左上角 */
	private final Point LU = new Point(0, 0);
	/**	地图右下角 */
	private final Point RD = new Point(Range.rowNum - 1, Range.colNum - 1);
	/**	葫芦娃阵型中心点 */
	private Point pBroCen; 
	/**	妖怪阵型中心点 */
	private Point pMonCen; 
	/**	老爷爷位置 */
	private Point pEld;
	/**	蛇精位置 */
	private Point pSnk;

	/**	构造函数，初始化 */
	public CharWindow() {
		initAll();
	}

	/**	初始化所有对象及其位置 */
	public void initAll() {
		broForm = new ChangShe(); // 葫芦娃阵型，只能是长蛇阵
		monForm = new HeYi(); // 妖怪阵型，初始化为鹤翼阵
		snake = new Snake();
		elder = new Elder();
		// 定位点的初始化
		pBroCen = Range.leftCenterP.copy();
		pMonCen = Range.rightCenterP.copy();
		pEld = Range.originElder.copy();
		pSnk = Range.originSnake.copy();
	}
	
	/**	@return 葫芦娃阵型位置 */
	public Point getBroCen() {
		return pBroCen;
	}

	/**	@return 妖怪阵型位置 */
	public Point getMonCen() {
		return pMonCen;
	}

	/**	@return 老爷爷位置 */
	public Point getEldPos() {
		return pEld;
	}

	/**	@return 蛇精位置 */
	public Point getSnkPos() {
		return pSnk;
	}
	
	/**	@param type 阵型类型值（不为长蛇阵，因为此函数是为了妖怪阵型变换而设）
	 *	@return 妖怪阵型对象 */
	private Formation<Monsters> setForm(FormationType type) {
		switch (type) {
		case HY: return new HeYi(); 
		case YX: return new YanXing(); 
		case CE: return new ChongE();
		case YL: return new YuLin();
		case FY: return new FangYuan();
		case YY: return new YanYue();
		case FS: return new FengShi();
		default: return new HeYi(); 
		}
	}

	/**	@param p 点p
	 *	@return {@code true}: p点在世界地图范围之内 */
	private boolean inRange(Point p) {
		if (p == null) return false; // debug
		return p.in(LU, RD);
	}

	/**	@param form 阵型form
	 *	 @param pCen 阵型位置，中心点pCen
	 *	@return {@code true}: 该阵型在世界地图范围之内 */
	private <T extends Creature> boolean inRange(Formation<T> form, Point pCen) {
		if (form == null) return false; // debug
		for (Point p : form.formMap.keySet()) { // 将阵型移位到以pCen为中心
			if (!p.mov(pCen).mov(form.getFormCen().reverse()).in(LU, RD))
				return false;
		}
		return true;		
	}

	/**	@param p1 点p1
	 *	@param p2 点p2
	 *	@return p1点与p2点冲突
	 */
	private boolean inCollision(Point p1, Point p2) {
		if (p1 == null || p2 == null) return false; // 若为空一定不冲突
		else return p1.equals(p2);
	}
	
	/**	@param p 点p
	 *	@param form 阵型form
	 *	@param pCen 阵型位置，中心点pCen
	 *	@return {@code true}: p点与该阵型冲突 */
	private <T extends Creature> boolean inCollision(Point p, Formation<T> form, Point pCen) {
		if (pCen == null) return true; // debug
		if (p == null || form == null) return false; // 若为空一定不冲突
		for (Point pf : form.formMap.keySet()) { // 将阵型移位到以pCen为中心
			if (pf.mov(pCen).mov(form.getFormCen().reverse()).equals(p))
				return true;
		}
		return false;
	}

	/**	@param form1 阵型1
	 *	@param p1Cen 阵型1位置，中心点p1Cen
	 *	@param form2 阵型2
	 *	@param p2Cen 阵型2位置，中心点p2Cen
	 *	@return {@code true}: 阵型1与阵型2冲突 */
	private <T1 extends Creature, T2 extends Creature> boolean inCollision(Formation<T1> form1, Point p1Cen, Formation<T2> form2, Point p2Cen) {
		if (p1Cen == null || p2Cen == null) return true; // debug
		if (form1 == null || form2 == null) return false; // 若为空一定不冲突
		for (Point p1 : form1.formMap.keySet()) {
			for (Point p2 : form2.formMap.keySet()) { // 将阵型移位到以p1Cen, p2Cen为中心
				if (p1.mov(p1Cen).mov(form1.getFormCen().reverse())
						.equals(p2.mov(p2Cen).mov(form2.getFormCen().reverse()))) 
					return true;
			}
		}
		return false;
	}
	
	/**	@param p 点p
	 *	@param type 待检查的阵营
	 *	@return {@code true}: p处可以摆放点 */
	private boolean checkGround(Point p, GroupType type) {
		if (p == null) return false; // debug
		if (!inRange(p)) {
			System.out.println("超出地图范围");
			return false;
		}
		else if (type != GroupType.Eld && inCollision(p, pEld)) {
			System.out.println("该位置已被老爷爷占领");
			return false;
		}
		else if (type != GroupType.Snk && inCollision(p, pSnk)) {
			System.out.println("该位置已被蛇精占领");
			return false;
		}
		else if (inCollision(p, broForm, pBroCen)) {
			System.out.println("该位置已被葫芦娃占领");
			return false;
		}
		else if (inCollision(p, monForm, pMonCen)) {
			System.out.println("该位置已被妖怪占领");
			return false;
		}
		else return true;
	}

	/**	@param form 阵型form
	 *	@param pCen 待检查的摆放点pCen
	 *	@param type 待检查的阵营
	 *	@return {@code true}: pCen处可以摆放该阵型 */
	private <T extends Creature> boolean checkGround(Formation<T> form, Point pCen, GroupType type) {
		if (form == null) return false; // debug
		if (!inRange(form, pCen)) {
			System.out.println("超出地图范围");
			return false;
		}
		else if (inCollision(pEld, form, pCen)) {
			System.out.println("该位置已被老爷爷占领");
			return false;
		}
		else if (inCollision(pSnk, form, pCen)) {
			System.out.println("该位置已被蛇精占领");
			return false;
		}
		else if (type != GroupType.Bro && inCollision(broForm, pBroCen, form, pCen)) {
			System.out.println("该位置已被葫芦娃占领");
			return false;
		}
		else if (type != GroupType.Mon && inCollision(monForm, pMonCen, form, pCen)) {
			System.out.println("该位置已被妖怪占领");
			return false;
		}
		else return true;
	}
	
	/**	向右下方向移动阵型
	 *	@param form 为broForm/monForm
	 *	@param pCen 为pBroCen/pMonCen
	 *	@param d 相对位移(d.row(), d.col())
	 *	@param type 待移动的阵营 */
	private <T extends Creature> void movFormation(Formation<T> form, Point pCen, Point d, GroupType type) {
		if (form == null || pCen == null) return; // debug
		if (d == null || d.equals(new Point(0, 0)))
			System.out.println("阵型未移动");
		else if (checkGround(form, pCen.mov(d), type)) // 可以移动
			pCen.reset(pCen.mov(d));
	}

	/**	向右下方向移动啦啦队
	 *	@param p 为pEld/pSnk
	 *	@param d 相对位移(d.row(), d.col())
	 *	@param type 待移动的阵营 */
	private void movPoint(Point p, Point d, GroupType type) {
		if (p == null) return; // debug
		if (d == null || d.equals(new Point(0, 0)))
			System.out.println("啦啦队未移动");
		else if (checkGround(p.mov(d), type)) // 可以移动
			p.reset(p.mov(d));
	}
	
	/**	将阵营type向右下方移动
	 *	@param type 四种阵营
	 *	@param d 相对位移(d.row(), d.col()) */
	public void movGroup(GroupType type, Point d) {
		switch (type) {
		case Bro: movFormation(broForm, pBroCen, d, type); return;
		case Mon: movFormation(monForm, pMonCen, d, type); return;
		case Eld: movPoint(pEld, d, type); return;
		case Snk: movPoint(pSnk, d, type); return;
		default: return;
		}
	}

	/**	改变妖怪阵型到新阵型type */
	public void changeFormation(FormationType type) {
		if (type == monForm.getType())
			System.out.println("阵型未改变");
		else if (checkGround(setForm(type), pMonCen, GroupType.Mon)) // 可以改变
			monForm = setForm(type);
	}
	
	/**	显示里世界 */
	public void showWorld() {
		// 若超出范围则不显示
		if (!inRange(broForm, pBroCen) || !inRange(monForm, pMonCen) || !inRange(pEld) || !inRange(pSnk)) {
			System.out.println("无法显示地图");
			return;
		}
		 // 初始化显示的地图
		char[][] cMap = new char[Range.rowNum][Range.colNum];
		for (int i = 0; i < Range.rowNum; i++) { 
			for (int j = 0; j < Range.colNum; j++)
				cMap[i][j] = ' '; 
		}
		// 分别把葫芦娃、妖怪、啦啦队放上去
		for (Point bp : broForm.formMap.keySet())
			cMap[bp.row() + pBroCen.row() - broForm.getFormCen().row()]
				[bp.col() + pBroCen.col() - broForm.getFormCen().col()] 
						= broForm.getCreature(bp).getSymbol();
		for (Point mp : monForm.formMap.keySet())
			cMap[mp.row() + pMonCen.row() - monForm.getFormCen().row()]
				[mp.col() + pMonCen.col() - monForm.getFormCen().col()] 
						= monForm.getCreature(mp).getSymbol();
		cMap[pEld.row()][pEld.col()] = elder.getSymbol();
		cMap[pSnk.row()][pSnk.col()] = snake.getSymbol();
		// 开始打印地图
		char boundary = '#';
		// 第一行，地图边界
		for (int j = 0; j < Range.colNum + 2; j++)
			System.out.print(boundary + " ");
		System.out.println();
		// 地图主体
		for (int i = 0; i < Range.rowNum; i++) {
			System.out.print(boundary);
			for (int j = 0; j < Range.colNum; j++)
				System.out.print(" " + cMap[i][j]);
			System.out.println(" " + boundary);
		}
		// 最后一行，地图边界
		for (int j = 0; j < Range.colNum + 2; j++)
			System.out.print(boundary + " ");
		System.out.println();
	}
}
