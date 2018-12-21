package world;

import java.util.Random;

import world.creatures.Creature;
import world.util.*;

/**
 *	生物实体类，世界的每个生物都有其对应的实体. <br>
 *	包括：
 *	(1) 固定属性：id + 生物 + 状态 + 位置 + 线程（行为），用于没有动画的显示
 *		@see #id
 *		@see #state
 *		@see #creature
 *		@see #position
 *		@see #thread
 *
 * 	(2) 运动属性：移动方向 + 目标对象指针 + 胜利与否，由于有动画的显示
 *		@see #direction
 *		@see #enemy
 *		@see #hasWined
 *
 * 	@see #setMoveDirection
 *	@see #run()
 *	@see #start()
 *	@see CharWindow.#entities
 * 
 *	@author Mirror
 */
public class Entity implements Runnable {
	
	/**	编号，为阵营号*1000+阵型偏移	*/
	public int id;
	/**	状态	*/
	public EntityState state;
	/**	生物	*/
	public Creature creature;
	/**	位置	*/
	public Point position;
	/**	线程	*/
	private Thread thread; 
	
	/**	移动方向	*/
	public Point direction = new Point(0, 0);
	/**	敌方对象的指针或null	*/
	public Entity enemy = null;
	/**	上一回合胜利与否	*/
	public boolean hasWined = false;

	/**	设定id值
	 *	@param bia 阵型内位置，记作偏移	*/
	public void setId(Point bia) {
		if (creature.getGroup() == GroupType.Bro)
			id = 1000;
		else id = 2000;
		// 偏移(没有用阵型总列数，只要保证不重复就行)
		id += bia.row() * Global.colNum + bia.col();
	}
	
	/**	初始构造函数	*/
	public Entity(Point bia, Creature c, Point p) {
		state = EntityState.LIVE;
		creature = c.copy();
		position = p.copy();
		setId(bia);
	}
	/**	构造函数，用于xml文件解析	*/
	public Entity(int i, CreatureType ct, int orgr, int orgc) {
		id = i;
		creature = ct.getCreature();
		position = new Point(orgr, orgc);
		state = EntityState.LIVE;
	}

	/**	重设属性值，用于xml文件解析	*/
	public void resetEntity(EntityState st, int pr, int pc, int movr, int movc, Entity ene, boolean w) {
		state = st;
		position.reset(pr, pc);
		direction.reset(movr, movc);
		enemy = ene;
		hasWined = w;
	}
	
	/**	返回[min, max]的随机整数	*/
	private int getRandom(int min, int max) {
		Random random = new Random();
		return (random.nextInt(max - min + 1) + min);
	}
	
	/**	随机结果胜利	*/
	private boolean win(GroupType type) {
		int bias = getRandom(-10, 10);
		if (type == GroupType.Bro)
			return (getRandom(0, 99) < Global.BroWinPercent + bias);
		else
			return (getRandom(0, 99) < Global.MonWinPercent - bias);
	}
	
	/**	获取最近的敌方实体的位置
	 *	@return 若敌方全部消灭，返回null；否则返回距离最近的敌方实体位置	*/
	private Point getNearestEnemy() {
		Entity nearEn = null; // 最近的敌方实体指针
		int nearD = Integer.MAX_VALUE; // 最近距离
		for (Entity en: CoreWorld.entities.values()) {
			if ((en.state == EntityState.LIVE) && (en.creature.getGroup() != creature.getGroup())) {
				int tmpD = en.position.distance(position);
				if (tmpD < nearD) {
					nearD = tmpD;
					nearEn = en;
				}
			}
		}
		return ((nearEn == null) ? (null) : (nearEn.position));
	}
	
	/**	判断某位置是否有实体
	 *	@return 有则返回该实体Entity的指针，没有则返回null	*/
	private Entity getLiveEntityAt(Point pos) {
		for (Entity en: CoreWorld.entities.values()) {
			if ((en.position.equals(pos)) && (en.state == EntityState.LIVE))
				return en;
		}
		return null;
	}

	/**	初始化运动属性	*/
	public void stand() {
		direction.reset(0, 0); 
		enemy = null;
		hasWined = false;
	}
	
	/**	获取到达敌方最近实体的随机方向，只能上下或左右.
	 *	设置direction为(1, 0) 或 (-1, 0) 或 (0, 1) 或 (0, -1)或(0, 0) 
	 *	不允许同时设定两个实体对象的方向	*/
	private void setMoveDirection() {
		stand(); // 初始化运动属性
		// 若要求保持阵型
		if (Global.keepFormationRound > 0) { 
			if (creature.getGroup() == GroupType.Bro) 
				direction.reset(0, 1);
			else 
				direction.reset(0, -1);
		} 
		else { // 否则进入大乱斗模式
			Point pTarget = getNearestEnemy();
			if (pTarget == null) { // 敌人全都消灭，战斗结束
				Global.battleEnd = true;
				return;
			}
			int signRow = (pTarget.row() > position.row()) ? (1) : (-1);
			int signCol = (pTarget.col() > position.col()) ? (1) : (-1);
			// 增强随机性，使对战更精彩
			int rand = getRandom(1, 10);
			if (pTarget.row() == position.row()) 
				direction.reset((rand <= 2) ? (new Point(signRow, 0)) : (new Point(0, signCol)));
			else if (pTarget.col() == position.col())
				direction.reset((rand <= 8) ? (new Point(signRow, 0)) : (new Point(0, signCol)));
			else 
				direction.reset((rand <= 5) ? (new Point(signRow, 0)) : (new Point(0, signCol)));
		}
		// 查看目标位置情况
		enemy = getLiveEntityAt(position.mov(direction));
		if (enemy != null && enemy.creature.getGroup() == creature.getGroup()) { 
			// 目标位置是同阵营实体
			enemy = null;
			if (!(Global.keepFormationRound > 0)) // 大乱斗时，不移动
				direction.reset(0, 0); 
		}
		// 目标位置是空地或敌人，移动照常
		return;
	}
	
	/**	向右下移动Entity
	 *	限制Entity类的所有实例的访问	*/
	@Override
	public void run() {
		synchronized (this) {
			if (Global.battleEnd == true) return; // 战斗结束
			if (state != EntityState.LIVE) return; // 本实体对象死亡/出界
			// 尝试移动
			setMoveDirection(); 
			if (direction.equals(new Point(0, 0))) return;// 没有移动
			// 先移动
			position.reset(position.mov(direction));
			// 如果出界了
			if (!position.inWorld())
				state = EntityState.OUT;
			// 如果遇到了敌人
			if (enemy != null) { 
				hasWined = win(creature.getGroup()); // 决生死
				if (hasWined) 
					enemy.state = EntityState.DEAD;
				else this.state = EntityState.DEAD;
			}
		}
	}
	
	/**	创建线程	*/
	public void start() {
    	thread = new Thread(this);
    	thread.start();
	}
}
