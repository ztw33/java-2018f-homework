package bullet;

import java.io.Serializable;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import spritecontroller.*;

public class Bullet implements  Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected Image apperance;
	protected ImageView figure;
	protected double distance;
	protected double vx, vy;
	public double posX;
	public double posY;
	protected int times = 0;
	public boolean isDone = false;
	public int type = -1;
	public Bullet(int type) {
		this.type = type;
		if(type == 1) {
			try {
				apperance = new Image("file:pics/fire.png");
				figure = new ImageView();
				figure.setImage(apperance);
				figure.setFitHeight(30);
				figure.setFitWidth(30);
				}catch(Exception e) {
					e.printStackTrace();
				}
		}else if(type == 2) {
			try {
				apperance = new Image("file:pics/water.png");
				figure = new ImageView();
				figure.setImage(apperance);
				figure.setFitHeight(30);
				figure.setFitWidth(30);
				}catch(Exception e) {
					e.printStackTrace();
				}
		}else if(type == 3) {
			try {
				apperance = new Image("file:pics/scball.png");
				figure = new ImageView();
				figure.setImage(apperance);
				figure.setFitHeight(30);
				figure.setFitWidth(30);
				}catch(Exception e) {
					e.printStackTrace();
				}
		}else if(type == 4) {
			try {
				apperance = new Image("file:pics/default.png");
				figure = new ImageView();
				figure.setImage(apperance);
				figure.setFitHeight(30);
				figure.setFitWidth(30);
				}catch(Exception e) {
					e.printStackTrace();
				}
		}else if(type == 5) {
			try {
				apperance = new Image("file:pics/heal.png");
				figure = new ImageView();
				figure.setImage(apperance);
				figure.setFitHeight(20);
				figure.setFitWidth(20);
				}catch(Exception e) {
					e.printStackTrace();
				}
		}else if(type == 6) {
			try {
				apperance = new Image("file:pics/bad.png");
				figure = new ImageView();
				figure.setImage(apperance);
				figure.setFitHeight(30);
				figure.setFitWidth(30);
				}catch(Exception e) {
					e.printStackTrace();
				}
		}
	}
	public Bullet(Creature from, Creature to){
		if(from.tellName() == "老四") {
			try {
			type = 1;
			apperance = new Image("file:pics/fire.png");
			figure = new ImageView();
			figure.setImage(apperance);
			figure.setFitHeight(30);
			figure.setFitWidth(30);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(from.tellName() == "老五") {
			try {
				type = 2;
				apperance = new Image("file:pics/water.png");
				figure = new ImageView();
				figure.setImage(apperance);
				figure.setFitHeight(30);
				figure.setFitWidth(30);
				}catch(Exception e) {
					e.printStackTrace();
				}
		}else if(from.tellName() == "蝎子精") {
			try {
				type = 3;
				apperance = new Image("file:pics/scball.png");
				figure = new ImageView();
				figure.setImage(apperance);
				figure.setFitHeight(30);
				figure.setFitWidth(30);
				}catch(Exception e) {
					e.printStackTrace();
				}
		}else if(from.tellName() == "老大"||from.tellName() == "老二"||from.tellName() == "老三"||from.tellName() == "老六"||from.tellName() == "老七") {
			try {
				type = 4;
				apperance = new Image("file:pics/default.png");
				figure = new ImageView();
				figure.setImage(apperance);
				figure.setFitHeight(30);
				figure.setFitWidth(30);
				}catch(Exception e) {
					e.printStackTrace();
				}
		}else if(from.tellName() == "蛇精" ||from.tellName() == "老爷爷"){
			try {
				type = 5;
				apperance = new Image("file:pics/heal.png");
				figure = new ImageView();
				figure.setImage(apperance);
				figure.setFitHeight(20);
				figure.setFitWidth(20);
				}catch(Exception e) {
					e.printStackTrace();
				}
		}else {
			try {
				type = 6;
				apperance = new Image("file:pics/bad.png");
				figure = new ImageView();
				figure.setImage(apperance);
				figure.setFitHeight(30);
				figure.setFitWidth(30);
				}catch(Exception e) {
					e.printStackTrace();
				}
		}
		int dx = to.x() - from.x();
		int dy = to.y() - from.y();
		distance = Math.sqrt(dx * dx + dy * dy);
		vx = (double)dx / 10;
		vy = (double)dy / 10;
		posX = from.x();
		posY = from.y();
		
	}
	public double getDistance() {
		return distance;
	}
	public void render(Pane p) {
		times++;
		if(times >= 10) {
			isDone = true;
		}
		posX += vx;
		posY += vy;
		figure.setLayoutX(posX * 50 + 300);
		figure.setLayoutY(posY * 50 + 250);
		p.getChildren().add(figure);
	}
	
	public void renderReload(Pane p) {
		figure.setLayoutX(posX * 50 + 300);
		figure.setLayoutY(posY * 50 + 250);
		p.getChildren().add(figure);
	}
}
