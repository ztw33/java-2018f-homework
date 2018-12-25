package creature;

import javafx.scene.image.Image;

public class Scorpion extends Bad {
	@Override
	public String toString() {
		return "蝎子精";
	}

	@Override
	public Image getImage() {
		Image image = new Image("img/scorpion.png");
		return image;
	}
}
