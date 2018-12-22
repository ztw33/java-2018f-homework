package Creatures;
import Attributes.Color;
import javafx.scene.image.Image;

public class CalabashBrother extends Creature implements Comparable{
    private Color color;
    public CalabashBrother(Color color) {
        this.color = color;
        int index = color.ordinal()+1;
        image = new Image("resourceFiles/"+index+".jpg");
    }
    public void outputInfo() {
        System.out.print(color.getName());
    }

    public Color getColor() {
        return color;
    }

    public Image getImage() {
        return image;
    }

    public int compareTo(Object obj) {
        try{
            CalabashBrother calabashBrother = (CalabashBrother)obj;
            if(this.color.ordinal() < calabashBrother.getColor().ordinal()) {
                return -1;
            }
            if(this.color.ordinal() == calabashBrother.getColor().ordinal()) {
                return 0;
            }
            return 1;
        }
        catch (ClassCastException e) {
            e.printStackTrace();
        }
        return 0;
    }
    public String toString() {
        return color.getName();
    }
}

