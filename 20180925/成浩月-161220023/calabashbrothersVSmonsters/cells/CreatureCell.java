package cells;

import java.awt.*;
import javax.swing.*;
import beings.*;

@SuppressWarnings("serial")
public class CreatureCell extends BeingCell {

	@Override
	public void setbeing(Being being) {
		this.being=being;
		this.setIcon(new ImageIcon(being.image.getScaledInstance(width, height, Image.SCALE_SMOOTH)));
	}
	
	@Override
	public boolean placeallowed(Being being) {
		if(this.being!=null||!Creature.class.isAssignableFrom(being.getClass()))
			return false;
		else
			return true;
	}
}
