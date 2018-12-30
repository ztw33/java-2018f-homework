class Cell {

    private Creature creature;
    private final Coordinate coordinate;

    Cell() {
        creature = null;
        coordinate = new Coordinate();
    }

    Cell(Coordinate coordinate) {
        creature = null;
        this.coordinate = coordinate;
    }

    Cell(Creature creature, Coordinate coordinate) {
        this.creature = creature;
        this.coordinate = coordinate;
    }

    Creature getCreature() {
        return creature;
    }

    Coordinate getCoordinate() {
        return coordinate;
    }

    String getName() {
        return creature.getName();
    }

    void setCreature(Creature creature) {
        creature.setCoordinate(coordinate);
        this.creature = creature;
    }

    void remove() {
        if (creature != null) {
            creature.setCoordinate(new Coordinate());
            creature = null;
        } else
            System.out.println("trying to remove null cell.");
    }

    boolean isEmpty() {
        return creature == null;
    }
}
