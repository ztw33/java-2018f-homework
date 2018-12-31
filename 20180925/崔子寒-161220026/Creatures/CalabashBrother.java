package Creatures;
import Attributes.Color;

public class CalabashBrother extends Creature {
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
}

