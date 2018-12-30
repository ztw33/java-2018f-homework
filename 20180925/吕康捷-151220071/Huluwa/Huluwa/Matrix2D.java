package Huluwa;

public class Matrix2D implements Space{
    //2D方阵
    private int length;
    private int width;

    private Position [][]matrix;

    public Matrix2D(int length,int width){
        this.length = length;
        this.width = width;

        matrix = new Position[length][width];
        for(int i = 0;i < length;i++)
            for(int j = 0; j < width;j++)
            {
                MPoint2D point = new MPoint2D(i,j);
                matrix[i][j] = new Position(point);
            }

    }

    public int getLength(){
        return length;
    }
    public int getWidth(){
        return  width;
    }
    @Override
    public int getTotalPositionNum(){
        return length*width;
    }

    @Override
    public Position getPosition(MPoint tpoint){
        MPoint2D point = (MPoint2D)tpoint;
        if(point.getX() < length && point.getY() <width)
            return matrix[point.getX()][point.getY()];
        else return matrix[0][0];
    }

    public Position getPoisition(int x,int y){
        if(x < length && y <width)
            return matrix[x][y];
        else return matrix[0][0];
    }
    //获取某个位置

    //打印方阵
    @Override
    public void show(){
        System.out.println();
        for(int i = 0;i < length;i++) {
            for (int j = 0; j < width; j++) {
                if (matrix[i][j].isEmpty())
                    System.out.print("\t\t");
                else if (matrix[i][j].GetPeople() != null)
                    matrix[i][j].GetPeople().report();
            }
            System.out.print("\n");
        }
    }


}
