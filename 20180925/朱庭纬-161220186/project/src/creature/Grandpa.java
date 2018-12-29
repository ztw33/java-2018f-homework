package creature;

import javafx.scene.image.Image;

public class Grandpa extends Good implements Cheerable {

	@Override
	public void cheer() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String toString() {
		return "爷爷";
	}

	@Override
	public Image getImage() {
		Image image = new Image("img/grandpa.png");
		return image;
	}
}
