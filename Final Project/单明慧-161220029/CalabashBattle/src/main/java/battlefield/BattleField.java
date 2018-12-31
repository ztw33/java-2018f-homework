package battlefield;

import spritecontroller.Creature;
import javafx.scene.image.Image;
import javafx.scene.canvas.GraphicsContext;

public class BattleField {
    Tile[][] field = new Tile[15][15];
    private Image environment;
    public BattleField() {
        for(int i = 0; i < 15; i++) {
            for(int j = 0; j < 15; j++) {
                field[i][j] = new Tile();
            }
        }
        try {
            String path = "/forest.png";
            environment = new Image(path);
        }catch(Exception e) {
           // e.printStackTrace();
        }
    }

    public void show(GraphicsContext gc) {
        gc.drawImage(environment, 0, 0);
    }

    public void standOn(Creature onePerson) {
        field[onePerson.x()][onePerson.y()].stood(onePerson);
    }

    public void leave(int x, int y) {
        field[x][y].leave();
    }

    public boolean isEmpty(int x, int y) {
        if(field[x][y].isOccupied)
            return false;
        else
            return true;
    }
}

