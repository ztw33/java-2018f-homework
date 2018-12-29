public interface Creature {

    String getName();

    Coordinate getCoordinate();

    void setCoordinate(Coordinate coordinate);
}

interface Calabash extends Creature {

    Rank getRank();

    Color getColor();
}

class Property {

    private String name;
    private Coordinate coordinate;

    Property(String name) {
        this.name = name;
        this.coordinate = new Coordinate();
    }

    String getName() {
        return this.name;
    }

    Coordinate getCoordinate() {
        return coordinate;
    }

    void setCoordinate(Coordinate coordinate) {
        this.coordinate.set(coordinate);
    }
}

class CalabashProperty extends Property {

    private Color color;
    private Rank rank;

    CalabashProperty(Color color, Rank rank) {
        super(color.toString().charAt(0) + "娃");
        this.color = color;
        this.rank = rank;
    }

    Rank getRank() {
        return rank;
    }

    Color getColor() {
        return color;
    }
}

enum CalabashBrother implements Calabash {

    RED(Color.RED, Rank.FIRST), ORANGE(Color.ORANGE, Rank.SECOND), YELLOW(Color.YELLOW, Rank.THIRD),
    GREEN(Color.GREEN, Rank.FOURTH), CYAN(Color.CYAN, Rank.FIFTH), BLUE(Color.BLUE, Rank.SIXTH),
    PURPLE(Color.PURPLE, Rank.SEVENTH);

    CalabashProperty property;

    CalabashBrother(Color color, Rank rank) {
        property = new CalabashProperty(color, rank);
    }

    public String getName() {
        return property.getName();
    }

    public Rank getRank() {
        return property.getRank();
    }

    public Color getColor() {
        return property.getColor();
    }

    public Coordinate getCoordinate() {
        return property.getCoordinate();
    }

    public void setCoordinate(Coordinate coordinate) {
        property.setCoordinate(coordinate);
    }
}

enum NonCalabashBrother implements Creature {

    GRANDPA("老爷爷"), SNAKE("蛇精"), SCORPION("蝎子精"), UNDERLING("小喽啰");

    Property property;

    NonCalabashBrother(String name) {
        property = new Property(name);
    }

    public String getName() {
        return property.getName();
    }

    public Coordinate getCoordinate() {
        return property.getCoordinate();
    }

    public void setCoordinate(Coordinate coordinate) {
        property.setCoordinate(coordinate);
    }
}

class Underlying implements Creature {

    private Property property;

    Underlying() {
        property = new Property("小喽啰");
    }

    public String getName() {
        return property.getName();
    }

    public Coordinate getCoordinate() {
        return property.getCoordinate();
    }

    public void setCoordinate(Coordinate coordinate) {
        property.setCoordinate(coordinate);
    }
}

enum Color {

    RED("红色"), ORANGE("橙色"), YELLOW("黄色"), GREEN("绿色"), CYAN("青色"), BLUE("蓝色"), PURPLE("紫色");

    private String color;

    Color(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return color;
    }
}

enum Rank {

    FIRST("老大"), SECOND("老二"), THIRD("老三"), FOURTH("老四"), FIFTH("老五"), SIXTH("老六"), SEVENTH("老七");

    private String rank;

    Rank(String rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        return rank;
    }
}
