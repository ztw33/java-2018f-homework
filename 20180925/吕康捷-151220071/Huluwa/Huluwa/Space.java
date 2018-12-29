package Huluwa;

public interface Space {
    //空间，包含了n个位置，并能将每个位置展现
    public Position getPosition(MPoint point);
    public int getTotalPositionNum();
    public void show();
}
