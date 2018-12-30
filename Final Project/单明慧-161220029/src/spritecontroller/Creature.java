package spritecontroller;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.io.File;
import java.io.FileOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


import battlefield.BattleField;
import bullet.Bullet;

public class Creature implements Runnable, Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected String name;
	protected  transient Image apperance;
	protected  transient ImageView figure;
	public int posX;
	public int posY;
	protected int vX;
	protected int vY;
	protected int attackArea = 0;
	protected int fullhp;
	public int currentHp;
	protected int atk;
	protected int defence;
	public boolean isDead = false;
	protected ArrayList<Bullet> allBullets;
	static protected Lock creatureLock = new ReentrantLock();
	protected FileOutputStream out;
	protected File file;
	
	public void update(double time) {
		posX += vX * time;
		posY += vY * time;
	}
	
	public void getOut(FileOutputStream out) {
		this.out = out;
	}
	
	public void getFile(File file) {
		this.file = file;
	}
	
	public void getBullList(ArrayList<Bullet> allBullets) {
		this.allBullets = allBullets;
	}
	
	public void render(GraphicsContext gc, Pane p) {
		figure.setLayoutX(posX * 50 + 300);
		figure.setLayoutY(posY * 50 + 250);
		gc.setStroke(Color.BLACK);
		gc.setFill(Color.GREEN);
		p.getChildren().add(figure);
		if(!isDead) {
			double tmp = (double)currentHp/fullhp;
			gc.strokeRect(posX * 50 + 300, posY * 50 + 250, 50 , 5);
			gc.fillRect(posX * 50 + 300, posY * 50 + 250, 50 * tmp, 5);
			gc.setFill(Color.RED);
			gc.fillRect(posX * 50 + 300 + 50 * tmp, posY * 50 + 250, 50 * (1 - tmp), 5);
		}
	}
	
	public void loadImage(String imagePath) {
		try {
		apperance = new Image(imagePath);
		figure = new ImageView();
		figure.setImage(apperance);
		figure.setFitHeight(50);
		figure.setFitWidth(50);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void setPos(int x, int y) {
		posX = x;
		posY = y;
	}
	
	public int x() {
		return posX;
	}
	
	public int y() {
		return posY;
	}
	
	public void attacked(BattleField bt, Creature attacker) {
		int damage = attacker.getAtk() - attacker.getdef();
		minusHp(damage);
		if(getHp() <= 0) {
			//System.out.println(name + " I die!");
			isDead = true;
			try {
				apperance = new Image("file:pics/rip.png");
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
	
	public int getAtk() {
		return atk;
	}
	
	public int getdef() {
		return defence;
	}
	
	public int getHp() {
		return currentHp;
	}
	
	public void minusHp(int damage) {
		currentHp -= damage;
	}	
	@Override
	public void run() {
		
	}	
	public String tellName() {
		return name;
	}
}
