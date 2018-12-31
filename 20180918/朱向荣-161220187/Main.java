import java.util.*;

public class Main {
    public static void main(String[] args) {
        Calabashes calabros = new Calabashes();
        calabros.initialize();
        calabros.shuffle();
        calabros.show_by_seq();
        calabros.sort_bubble();
        calabros.show_by_seq();
        calabros.shuffle();
        calabros.show_by_color();
        calabros.sort_binaryinsert();
        calabros.show_by_color();
    }
}
