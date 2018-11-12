package battleInformation;

import creatureInformation.Creature;
import position.Position;

public class Board {
    private Position [][] board;
    private int n;
    public Board(int n){
        this.n = n;
        this.board = new Position[n][n];
        for(int i = 0;i < n;i++){
            for(int j = 0; j < n; j++){
                this.board[i][j] = new Position(i, j, null);
            }
        }
    }

    void setCreatureOnPosition(int x, int y, Creature creature){
        this.board[x][y].setCreature(creature);
    }

    Position getPosition(int x, int y){
        return this.board[x][y];
    }

    int getN() {
        return n;
    }

    boolean isBeyondTheMark(int x){
        return x < 0 || x > this.n - 1;
    }

    public void printBoard(){
        for(int i = 0;i < n;i++){
            for(int j = 0; j < n; j++){
                board[i][j].printPosition();
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
