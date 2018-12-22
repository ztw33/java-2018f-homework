package njucs.java2018;

public class Field { //长19宽15的战场
    public final int Width = 19;
    public final int Height = 15;
    public Square[][] square;
    Field() {
        square = new Square[Height][Width];
        for(int i = 0; i < Height; i ++) {
            for(int j = 0; j < Width; j ++) {
                square[i][j] = new Square();
            }
        }
    }
    public void show() {
        for(int i = 0; i < Height; i ++) {
            for(int j = 0; j < Width; j ++) {
                if(!square[i][j].isEmpty())
                    System.out.print(square[i][j].getBeing().getName() + '-');
                else
                    System.out.print("-----" );
            }
            System.out.println();
        }
    }
    public void clearField() {
        for(int i = 0; i < Height; i ++) {
            for(int j = 0; j < Width; j ++) {
                square[i][j].clearSquare();
            }
        }
    }
}

class Square {
    private Being being;
    Square() {
        this.being = null;
    }
    public boolean isEmpty() {
        return (this.being == null);
    }
    public void setBeing(Being being) {
        if(isEmpty()) this.being = being;
    }
    public Being getBeing() {
        return this.being;
    }
    public void clearSquare() {
        this.being = null;
    }
}