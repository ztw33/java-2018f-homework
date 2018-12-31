package logic.battleInformation;

import javafx.scene.image.Image;
import logic.creatureInformation.Creature;
import logic.position.Position;

public class Board {

    private final int SIZE = 15;

    private Position<Creature>[][] board;
    public Board(){
        this.board = new Position[SIZE][SIZE];
        for(int i = 0;i < SIZE;i++){
            for(int j = 0; j < SIZE; j++){
                this.board[i][j] = new Position<>(i, j, null);
            }
        }
    }

    void setCreatureOnPosition(int x, int y, Creature creature){
        this.board[x][y].setCreature(creature);
    }

    Position getPosition(int x, int y){
        return this.board[x][y];
    }

    public int getSIZE() {
        return SIZE;
    }

    boolean isBeyondTheMark(int x){
        return x < 0 || x > this.SIZE - 1;
    }

    public void printBoard(){
        for(int i = 0; i < SIZE; i++){
            for(int j = 0; j < SIZE; j++){
                board[i][j].printPosition();
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public Position<Creature>get(int x,int y){
        return board[x][y];
    }

    public Object getImage(int i, int j){
        return this.board[i][j].getImage();
    }

    public Image getMyImage(int i, int j){
        return this.board[i][j].getMyImage();
    }
}
