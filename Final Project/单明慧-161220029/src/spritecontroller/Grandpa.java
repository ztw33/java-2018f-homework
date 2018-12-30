package spritecontroller;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import battlefield.BattleField;
import bullet.Bullet;

public class Grandpa extends Creature{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Underlyings> allUnderlyings;
	private Scorpion scorpion;
	private Snake snake;
	private BattleField bt;
	private int countFile = 0;
	
	Creature targetEnemy;
	public Grandpa(){
		name = "老爷爷";
		String path = "file:pics/grandpa.png";
		fullhp = currentHp = 150;
		atk = 20;
		defence = 10;
		attackArea = 20;
		loadImage(path);
	}
	public void getThread(ArrayList<Thread> t) {
		Thread t1 = new Thread(this);
		t.add(t1);
	}
	@Override
    public int getdef() {
    	return defence;
    }
	@Override
	public int getHp() {
		return currentHp;
	}
	@Override
	public void minusHp(int damage) {
		currentHp -= damage;
	}
  @Override
    public void run() {
    	while(!isDead) {
    		creatureLock.lock();
    		if(isDead) {
    			creatureLock.unlock();
    			break;
    		}
    		findEnemy();
    		if(targetEnemy != null && !targetEnemy.isDead) {
    			int dx = targetEnemy.x() - posX;
    			int dy = targetEnemy.y() - posY;
    			if(dx * dx + dy * dy <= attackArea) {
    				//System.out.println(name + "attacked" + targetEnemy.tellName());
    				targetEnemy.attacked(bt, this);
    				allBullets.add(new Bullet(this, targetEnemy));
    			}else {
    				findNextPos(dx, dy);
    			}
    		}else {
    			creatureLock.unlock();
    			break;
    		}
    		try {
    		creatureLock.unlock();
    		Thread.sleep(1000);
    		}catch(Exception e) {
    			e.printStackTrace();
    		}
    	}
    }
    public void observeEnemy(ArrayList<Underlyings> allUnderlyings, Scorpion scorpion, Snake snake, BattleField bt) {
    	this.allUnderlyings = allUnderlyings;
    	this.scorpion = scorpion;
    	this.snake = snake;
    	this.bt = bt;
    }
    
    
    private void findNextPos(int dx, int dy) {
    	synchronized(bt) {
	    	if(dx < 0 && dy < 0) {
				if(posX != 0&&bt.isEmpty(posX - 1, posY)) {
					bt.leave(posX, posY);
					posX --;
					bt.standOn(this);
				}else if(posY != 0 && bt.isEmpty(posX, posY - 1)){
					bt.leave(posX, posY);
					posY --;
					bt.standOn(this);
				}
			}else if(dx > 0 && dy < 0) {
				if(posX != 14 && bt.isEmpty(posX + 1, posY)) {
					bt.leave(posX, posY);
					posX ++;
					bt.standOn(this);
				}else if(posY !=0 &&bt.isEmpty(posX, posY - 1)) {
					bt.leave(posX, posY);
					posY --;
					bt.standOn(this);
				}
			}else if(dx < 0 && dy > 0) {
				if(posX != 0 && bt.isEmpty(posX - 1, posY)) {	
					bt.leave(posX, posY);
					posX --;
					bt.standOn(this);
				}else if(posY !=14 && bt.isEmpty(posX, posY + 1)) {
					bt.leave(posX, posY);
					posY ++;
					bt.standOn(this);
				}
			}else if(dx > 0 && dy > 0) {
				if(posX != 14 && bt.isEmpty(posX + 1, posY)) {	
					bt.leave(posX, posY);
					posX ++;
					bt.standOn(this);
				}else if(posY != 14 && bt.isEmpty(posX, posY + 1)) {
					bt.leave(posX, posY);
					posY ++;
					bt.standOn(this);
				}
			}else {
				if(posX != 14 && bt.isEmpty(posX + 1, posY) && dx > 0) {
					bt.leave(posX, posY);
					posX++;
					bt.standOn(this);
				}else if(posX != 0 && bt.isEmpty(posX - 1, posY) && dx < 0) {
					bt.leave(posX, posY);
					posX --;
					bt.standOn(this);
				}else if(posY != 14 && bt.isEmpty(posX, posY + 1) && dy > 0) {
					bt.leave(posX, posY);
					posY++;
					bt.standOn(this);
				}else if(posY != 0 && bt.isEmpty(posX, posY - 1) && dy < 0) {
					bt.leave(posX, posY);
					posY --;
					bt.standOn(this);
				}else {
					if(posX != 14 && bt.isEmpty(posX + 1, posY)) {
						bt.leave(posX, posY);
						posX++;
						bt.standOn(this);
					}else if(posY != 14 && bt.isEmpty(posX, posY + 1)) {
						bt.leave(posX, posY);
						posY++;
						bt.standOn(this);
					}else if(posX != 0 && bt.isEmpty(posX - 1, posY)) {
						bt.leave(posX, posY);
						posX --;
						bt.standOn(this);
					}else if(posY != 0 && bt.isEmpty(posX, posY - 1)) {
						bt.leave(posX, posY);
						posY --;
						bt.standOn(this);
					}
				}
			}
    	}
    }
    
    private void findEnemy() {
    	creatureLock.lock();
    	int size = allUnderlyings.size();
    	boolean isEnemyAllDead = true;
    	for(int i = 0; i < size; i ++) {
    		if(!allUnderlyings.get(i).isDead) {
    			isEnemyAllDead = false;
    			break;
    		}
    	}
    	if(!scorpion.isDead)
    		isEnemyAllDead = false;
    	if(!snake.isDead)
    		isEnemyAllDead = false;
    	int distance = 2000;
    	if(!isEnemyAllDead) {
    		for(int i = 0; i < size; i++) {
    			int dx = posX - allUnderlyings.get(i).posX;
    			int dy = posY - allUnderlyings.get(i).posY;
    			int tmpD = dx * dx + dy * dy;
    			if(tmpD < distance && !allUnderlyings.get(i).isDead) {
    				distance = tmpD;
    				targetEnemy = allUnderlyings.get(i);
    			}
    		}
    		int dscx = posX - scorpion.x();
    		int dscy = posY - scorpion.y();
    		int tmpD = dscx * dscx + dscy * dscy;
    		if(tmpD < distance && ! scorpion.isDead) {
    			distance = tmpD;
    			targetEnemy = scorpion;
    		}
    		int dsnx = posX - snake.x();
    		int dsny = posY - snake.y();
    		tmpD = dsnx * dsnx + dsny * dsny;
    		if(tmpD < distance && ! snake.isDead) {
    			distance = tmpD;
    			targetEnemy = snake;
    		}
    	}else {
    		targetEnemy = null;
    	}
    	creatureLock.unlock();
	}
}
