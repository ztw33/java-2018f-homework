package position;

/**
 * @Description 点的坐标
 * @Author LUCUS BAI
 * @Date 2018/10/23
 */

public class Position {

    private int row;
    private int col;

    public Position(int row, int col)
    {
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

//    public void move(int deltaRow, int deltaCol){
//        this.row += deltaRow;
//        this.col += deltaCol;
//    }

    @Override
    public int hashCode() {
        return Integer.hashCode(row) + Integer.hashCode(col);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Position other = (Position) obj;
        if (other.row == this.row && other.col == this.col) {
            return true;
        } else {
            return false;
        }
    }
}
