package creature;

import javafx.scene.image.Image;

public class Minion extends Bad {
	@Override
	public String toString() {
		return "小喽啰";
	}

	@Override
	public Image getImage() {
		Image image = new Image("img/minion.png");
		return image;
	}
}
