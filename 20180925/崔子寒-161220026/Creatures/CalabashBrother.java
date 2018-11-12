package Creatures;
import Attributes.Color;

public class CalabashBrother extends Creature implements Comparable{
    private Color color;
    public CalabashBrother(Color color) {
        this.color = color;
    }
    public void outputInfo() {
        System.out.print(color.getName());
    }

    public Color getColor() {
        return color;
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
}

