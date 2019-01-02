package work3_huluwa;

public class Hululist {
	private Point[] positions;
    private Huluwa[] hululist;

    public Point[] getPositions() {
        return positions;
    }

    public Huluwa[] getHuluwa() {
        return hululist;
    }
    public Hululist(Huluwa[] list){
        positions = new Point[list.length];
        hululist = list;

        for(int i = 0; i < list.length; i++){
            positions[i] = new Point(i, 0);
         //   list[i].setplace(positions[i]);
            hululist[i].setplace(positions[i]);
        }

    }

    public Creature[] getCreature() {

        return getHuluwa();
}
}
