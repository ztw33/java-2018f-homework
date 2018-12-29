package formations;

import beings.Being;
import beings.Creature;
public class Battlefield {
    public Battlefield() {
        field = new Being[HEIGHT][WIDTH];
        for (int i = 0; i < HEIGHT; i++){
            for(int j = 0; j < WIDTH; j++){
                field[i][j] = null;
            }
        }
    }
    public void printField(){
        for (int i = 0; i < HEIGHT; i++){
            for(int j = 0; j < WIDTH; j++){
                if(field[i][j] != null)
                    field[i][j].toldname();
                else{
                    System.out.print("|      ");
                }
            }
            System.out.print("|\n");
        }
        System.out.print('\n');
    }

    public void setCreature(int x, int y, Creature creature){
            int oldPositionx = creature.getPositionx();
            int oldPositiony = creature.getPositiony();
            if(field[oldPositiony][oldPositionx] == creature){
                field[oldPositiony][oldPositionx] = null;
            }
            field[y][x] = creature;
            creature.setPosition(x, y);
    }
    private static final int WIDTH = 20;
    private static final int HEIGHT = 8;
    private Being[][] field;

    public int getHeight() {
        return HEIGHT;
    }

    public int getWidth() {
        return WIDTH;
    }
}

