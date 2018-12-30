public class Coordinate {
    int coordinateX;
    int coordinateY;

    static final int N = 15;
    public Coordinate() {
        coordinateX = 0;
        coordinateY = 0;
    }

    public Coordinate(int coordinateX, int coordinateY) {
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
    }

    public int hashLoc() {
        return coordinateX * N + coordinateY;
    }

}
