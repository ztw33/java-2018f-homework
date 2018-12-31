package spritecontroller;

import java.util.*;

import battlefield.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import bullet.Bullet;

enum COLOR {
    RED, ORANGE, YELLOW, GREEN, CYAN, BLUE, PURPLE
}
public class OneCalabash extends Creature {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private int number;
    private String colorName;
    private COLOR color;
    private Creature targetEnemy;

    private ArrayList<Underlyings> allUnderlyings;
    private Scorpion scorpion;
    private Snake snake;
    private BattleField bt;
    OneCalabash(int no, String colorName, COLOR color, String name, int attackA, int hp, int atk, int def){
        this.number = no;
        this.colorName = colorName;
        this.color = color;
        this.name = name;
        this.targetEnemy = null;
        this.attackArea = attackA;
        this.fullhp = this.currentHp = hp;
        this.atk = atk;
        this.defence = def;
    }
    public void attacked(BattleField bt, Creature attacker) {
        int damage = attacker.atk - defence;
        currentHp -= damage;
        if(currentHp <= 0) {
            //System.out.println(name + " I die!");
            isDead = true;
            try {
                apperance = new Image("/rip.png");
                figure = new ImageView();
                figure.setImage(apperance);
                figure.setFitHeight(50);
                figure.setFitWidth(50);
                bt.leave(posX, posY);
            }catch(Exception e) {
                e.printStackTrace();
            }
        }else {
            //System.out.println(name + " 受到伤害" + damage);
        }
    }
    public int tellNo() {
        return this.number;
    }
    String tellColorName() {
        return this.colorName;
    }
    COLOR tellColor() {
        return this.color;
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
    @Override
    public int getAtk() {
        return atk;
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
}

