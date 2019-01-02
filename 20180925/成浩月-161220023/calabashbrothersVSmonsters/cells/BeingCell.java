package cells;

import java.awt.Image;
import java.awt.event.*;

import javax.swing.*;
import beings.*;

@SuppressWarnings("serial")
public class BeingCell extends Cell {
	
	public BeingCell(){
		addaction();
	}
	
	@Override
	public void setbeing(Being being) {
		this.being=being;
		this.setIcon(new ImageIcon(being.image.getScaledInstance(width, height, Image.SCALE_SMOOTH)));
	}
	
	private void addaction() {
		this.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				if(being!=null)
					being.behave();
			}
			
		});
	}
	
	@Override
	public boolean placeallowed(Being being) {
		if(this.being!=null||!Being.class.isAssignableFrom(being.getClass()))
			return false;
		else
			return true;
	}

}
