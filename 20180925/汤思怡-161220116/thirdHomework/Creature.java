package thirdHomework;

import javax.swing.*;
import java.awt.*;

public abstract class Creature implements Constants {
	// 生物有：名字、所属物种、照片
	protected String name;
	protected Species species;
	protected ImageIcon icon;

	public Creature() {
		// TODO Auto-generated constructor stub
	}

	public Creature(int index) {
	}

	public Creature(String name, Species species, String path) {
		this.name = name;
		this.species = species;
		this.icon = new ImageIcon(path);
		this.standardIcon();
	}

	// 标准化图片大小
	public void standardIcon() {
		icon.setImage(
				icon.getImage().getScaledInstance(Constants.IMAGE_WIDTH, Constants.IMAGE_HEIGHT, Image.SCALE_DEFAULT));
	}

	// 根据坐标站点
	public void stand(Creature dimension[][], int x, int y) {
		dimension[x][y] = this;
	}

}
