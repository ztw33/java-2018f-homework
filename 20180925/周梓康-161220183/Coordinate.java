class Coordinate {

    private int coordinateX;
    private int coordinateY;

    Coordinate() {
        coordinateX = -1;
        coordinateY = -1;
    }

    Coordinate(int coordinateX, int coordinateY) {
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
    }

    Coordinate(Coordinate coordinate) {
        coordinateX = coordinate.getCoordinateX();
        coordinateY = coordinate.getCoordinateY();
    }

    int getCoordinateX() {
        return coordinateX;
    }

    int getCoordinateY() {
        return coordinateY;
    }

    void setCoordinateX(int coordinateX) {
        this.coordinateX = coordinateX;
    }

    void setCoordinateY(int coordinateY) {
        this.coordinateY = coordinateY;
    }

    void set(Coordinate coordinate) {
        coordinateX = coordinate.getCoordinateX();
        coordinateY = coordinate.getCoordinateY();
    }

    Coordinate add(Coordinate coordinate) {
        return new Coordinate(this.getCoordinateX() + coordinate.getCoordinateX(),
                this.getCoordinateY() + coordinate.getCoordinateY());
    }

    Coordinate add(int coordinateX, int coordinateY) {
        return new Coordinate(this.getCoordinateX() + coordinateX, this.getCoordinateY() + coordinateY);
    }
}
