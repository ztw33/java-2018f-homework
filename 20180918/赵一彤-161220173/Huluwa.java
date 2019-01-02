public enum Huluwa {
    FIRST("老大", Color.RED), SECOND("老二", Color.ORANGE), THIRD("老三", Color.YELLOW), FOURTH("老四", Color.GREEN),
    FIFTH("老五", Color.INDIGO), SIXTH("老六", Color.BLUE), SEVENTH("老七", Color.PURPLE);
    private String name;
    private Color color;

    Huluwa(String name, Color color) {
        this.name = name;
        this.color = color;
    }

    String reportName() {
        return name;
    }

    Color reportColor() {
        return color;
    }
}

enum Color {
    RED, ORANGE, YELLOW, GREEN, INDIGO, BLUE, PURPLE;
}

