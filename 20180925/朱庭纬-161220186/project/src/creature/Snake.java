package creature;

import javafx.scene.image.Image;

public class Snake extends Bad implements Cheerable {

	@Override
	public void cheer() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String toString() {
		return "蛇精";
	}

	@Override
	public Image getImage() {
		Image image = new Image("img/snake.png");
		return image;
	}
}
