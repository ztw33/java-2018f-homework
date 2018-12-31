package world;

import world.creatures.*;
import world.formations.*;
import world.tools.*;

/* 世界运转：
 * 将某个阵型置于地图上
 * 更改阵型
 * 阵型移动
 * 将啦啦队置于地图上
 * 啦啦队移动
 * 展示整个世界
 */

public class WorldMap {
	
	public static final int rangeRow = 20; // 行范围 (0, rangeRow-1)
	public static final int rangeCol  = 20; // 列范围 (0, rangeCol-1)
	
	// 对象
	private Formation broForm; // 定义葫芦娃阵型
	private Formation monForm; // 定义妖怪阵型
	private Snake snake = new Snake(); // 蛇精
	private Elder elder = new Elder(); // 老爷爷
	
	// 所有阵型
	private HeYi hyForm = new HeYi();
	private YanXing yxForm = new YanXing();
	private ChongE ceForm = new ChongE();
	private ChangShe csForm = new ChangShe();
	private YuLin ylForm = new YuLin();
	private FangYuan fyForm = new FangYuan();
	private YanYue yyForm = new YanYue();
	private FengShi fsForm = new FengShi();

	// 定位
	private final Point LU = new Point(0, 0); // 地图左上角
	private final Point RD = new Point(rangeRow - 1, rangeCol - 1); // 地图右下角
	private Point broCen;  // 葫芦娃阵型中心点
	private Point broLU; // 葫芦娃阵型左上角的点
	private Point broRD; // 葫芦娃阵型右下角的点
	private Point monCen; // 妖怪阵型中心点
	private Point monLU; // 妖怪阵型左上角的点
	private Point monRD; // 妖怪阵型右下角的点
	private Point snkP; // 蛇精位置
	private Point eldP; // 老爷爷位置
	
	private void updateBroLURD() { // 根据 Cen 值刷新 Bro 的 LU、RD值
		broLU.reset(broCen.row() - broForm.center().row(), broCen.col() - broForm.center().col());
		broRD.reset(broLU.row() + broForm.getRowNum() - 1, broLU.col() + broForm.getColNum() - 1);
	}

	private void updateMonLURD() { // 根据 Cen 值刷新 Mon 的 LU、RD值
		monLU.reset(monCen.row() - monForm.center().row(), monCen.col() - monForm.center().col());
		monRD.reset(monLU.row() + monForm.getRowNum() - 1, monLU.col() + monForm.getColNum() - 1);
	}
	
	public WorldMap() {
		broForm = csForm; // 葫芦娃阵型，只能是长蛇阵
		monForm = hyForm; // 妖怪阵型，指向某种阵型，初始化为鹤翼阵
		// 各定位点的初始化
		broCen = new Point(rangeRow/2 - 1, rangeCol/4 - 1);
		broLU = new Point(0, 0);
		broRD = new Point(0, 0);
		updateBroLURD();
		monCen = new Point(rangeRow/2 - 1, rangeCol*3/4 - 1);
		monLU = new Point(0, 0);
		monRD = new Point(0, 0);
		updateMonLURD();
		eldP = new Point(rangeRow*3/4, rangeCol/4 - 1);
		snkP = new Point(rangeRow*3/4, rangeCol*3/4 - 1);
	}

	private Formation getForm(Types type) {
		Formation form = null;
		switch (type) {
		case HY: form = hyForm; break;
		case YX: form = yxForm; break;
		case CE: form = ceForm; break;
		case CS: form = csForm; break;
		case YL: form = ylForm; break;
		case FY: form = fyForm; break;
		case YY: form = yyForm; break;
		case FS: form = fsForm; break;
		default: form = hyForm;
		}
		return form;
	}

	private boolean inRange(Point p) { // 判断点p是否在地图范围内
		return p.in(LU, RD);
	}

	private boolean inRange(Point pLU, Point pRD) { // 判断(LU -> RD)范围是否在地图范围内
		return ((pLU.row() >= LU.row()) && (pRD.row() <= RD.row()) 
				&& (pLU.col() >= LU.col()) && (pRD.col() <= RD.col()));
	}
	
	private boolean inBroRange(Point p) { // 判断点p是否在葫芦娃阵型范围内
		return p.in(broLU, broRD);
	}
	
	private boolean inBroRange(Point pLU, Point pRD) { // 判断(LU -> RD)范围是否与葫芦娃阵型范围有重叠
		return !((pLU.row() > broRD.row()) || (pRD.row() < broLU.row()) 
				|| (pLU.col() > broRD.col()) || (pRD.col() < broLU.col()));
	}
	
	private boolean inMonRange(Point p) { // 判断点p是否在妖怪阵型范围内
		return p.in(monLU, monRD);
	}
	
	private boolean inMonRange(Point pLU, Point pRD) { // 判断(LU -> RD)范围是否与妖怪阵型范围有重叠
		return !((pLU.row() > monRD.row()) || (pRD.row() < monLU.row()) 
				|| (pLU.col() > monRD.col()) || (pRD.col() < monLU.col()));
	}
	
	private boolean onMascotPoint(Point p) { // 判断点p是否覆盖了啦啦队
		return (p.equ(eldP) || p.equ(snkP));
	}

	private boolean onMascotPoint(Point pLU, Point pRD) { // 判断(LU -> RD)范围是否覆盖了啦啦队
		return ((eldP.in(pLU, pRD)) || (snkP.in(pLU, pRD)));
	}
	
	private boolean checkPointGround(Point p) { // 检查点p的场地是否可用
		if (!inRange(p)) {
			System.out.println("超出地图范围");
			return false;
		}
		else if (onMascotPoint(p)) {
			System.out.println("该位置已被啦啦队占用");
			return false;
		}
		else if ((inMonRange(p) && !monForm.isEmpty(p.row() - monLU.row(), p.col() - monLU.col()))
				|| (inBroRange(p) && !broForm.isEmpty(p.row() - broLU.row(), p.col() - broLU.col()))) {
			System.out.println("该位置已被其他阵型占用");
			return false;				
		}
		else return true;
	}
	
	private boolean checkFormGround(Point cen) { // 检查葫芦娃某阵型的场地是否可用
		Point lu = new Point(cen.row() - broForm.center().row(), cen.col() - broForm.center().col());
		Point rd = new Point(lu.row() + broForm.getRowNum() - 1, lu.col() + broForm.getColNum() - 1);
		if (!inRange(lu, rd)) {
			System.out.println("超出地图范围");
			return false;
		}
		else if (inMonRange(lu, rd) || onMascotPoint(lu, rd)) {
			System.out.println("该位置已被其他阵型占用");
			return false;
		}
		else return true;
	}
	
	private boolean checkFormGround(Point cen, Types type) { // 检查妖怪某阵型的场地是否可用
		Formation form = getForm(type);
		Point lu = new Point(cen.row() - form.center().row(), cen.col() - form.center().col());
		Point rd = new Point(lu.row() + form.getRowNum() - 1, lu.col() + form.getColNum() - 1);
		if (!inRange(lu, rd)) {
			System.out.println("超出地图范围");
			return false;
		}
		else if (inBroRange(lu, rd) || onMascotPoint(lu, rd)) {
			System.out.println("该位置已被其他阵型占用");
			return false;
		}
		else return true;
	}
	
	public void setBroPosition(Point cen) { // 在cen处放葫芦娃阵型
		if (cen.equ(broCen))
			System.out.println("葫芦娃阵型已在该位置");
		else if (checkFormGround(cen)) {
			broCen.reset(cen.row(), cen.col());
			updateBroLURD();
		}
	}

	public void movBroPosition(int dr, int dc) { // 移动葫芦娃阵型
		if (dr == 0 && dc == 0)
			System.out.println("葫芦娃阵型未移动");
		else if (checkFormGround(new Point(broCen.row() + dr, broCen.col() + dc))) {
			broCen.mov(dr, dc);
			updateBroLURD();
		}
	}
	
	public void setMonType(Types type) { // 根据 Type 为 monForm 赋值
		monForm = getForm(type);
		updateMonLURD();
	}
	
	public void setMonPosition(Point cen) { // 在cen处放妖怪阵型
		if (cen.equ(monCen))
			System.out.println("妖怪阵型已在该位置");
		else if (checkFormGround(cen, monForm.getType())) {
			monCen.reset(cen.row(), cen.col());
			updateMonLURD();
		}
	}
	
	public void movMonPosition(int dr, int dc) { // 移动妖怪阵型
		if (dr == 0 && dc == 0)
			System.out.println("妖怪阵型未移动");
		else if (checkFormGround(new Point(monCen.row() + dr, monCen.col() + dc), monForm.getType())) {
			monCen.mov(dr, dc);
			updateMonLURD();
		}
	}
	
	public void movEldPosition(int dr, int dc) { // 移动老爷爷
		if (dr == 0 && dc == 0)
			System.out.println("老爷爷未移动");
		else if (checkPointGround(new Point(eldP.row() + dr, eldP.col() + dc)))
			eldP.mov(dr, dc);
	}
	
	public void movSnkPosition(int dr, int dc) { // 移动蛇精
		if (dr == 0 && dc == 0)
			System.out.println("蛇精未移动");
		else if (checkPointGround(new Point(snkP.row() + dr, snkP.col() + dc)))
			snkP.mov(dr, dc);
	}

	public void showWorld() { // 显示世界
		 // 初始化显示的地图
		char[][] map = new char[rangeRow][rangeCol];
		for (int i = 0; i < rangeRow; i++) { 
			for (int j = 0; j < rangeCol; j++)
				map[i][j] = ' '; 
		}
		// 分别把葫芦娃、妖怪、啦啦队放上去
		char[][] broFormMap = broForm.getFormMap();
		for (int i = broLU.row(); i <= broRD.row(); i++) {
			for (int j = broLU.col(); j <= broRD.col(); j++)
				map[i][j] = broFormMap[i - broLU.row()][j - broLU.col()];
		}
		char[][] monFormMap = monForm.getFormMap();
		for (int i = monLU.row(); i <= monRD.row(); i++) {
			for (int j = monLU.col(); j <= monRD.col(); j++)
				map[i][j] = monFormMap[i - monLU.row()][j - monLU.col()];
		}
		map[eldP.row()][eldP.col()] = elder.getSymbol();
		map[snkP.row()][snkP.col()] = snake.getSymbol();
		// 开始打印地图
		char boundary = '#';
		// 第一行，地图边界
		for (int j = 0; j < rangeCol + 2; j++)
			System.out.print(boundary + " ");
		System.out.println();
		// 地图主体
		for (int i = 0; i < rangeRow; i++) {
			System.out.print(boundary);
			for (int j = 0; j < rangeCol; j++)
				System.out.print(" " + map[i][j]);
			System.out.println(" " + boundary);
		}
		// 最后一行，地图边界
		for (int j = 0; j < rangeCol + 2; j++)
			System.out.print(boundary + " ");
		System.out.println();
	}
}
