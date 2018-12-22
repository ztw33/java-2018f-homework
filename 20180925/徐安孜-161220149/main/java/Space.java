
package main.java;


import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public  class Space{
    int rows,columns;
    int elementSize;
    Creature map[][];
    ImageView imv[][];

    Space(int r,int c,int es){
        rows=r;
        columns=c;
        elementSize=es;
        map = new Creature[columns][rows];
        for(int i=0;i<columns;i++) {
            for (int j = 0; j < rows; j++) {
                map[i][j] = null;
            }
        }
        imv = new ImageView[columns][rows];
        for(int i=0;i<columns;i++)
            for(int j=0;j<rows;j++){
                imv[i][j]=new ImageView();
                imv[i][j].setVisible(false);
                imv[i][j].setX(i*elementSize);
                imv[i][j].setY(j*elementSize);
            }
    }
    Creature getCreature(int x,int y){return map[x][y];}
    boolean validation(int x,int y){
        return (map[x][y]==null && x<columns && y<rows);
    }
    void creatureEnterSpace(Creature c, int x, int y){
        map[x][y]=c;
        imv[x][y].setVisible(true);
        imv[x][y].setImage(new Image(c.imageURL));
        imv[x][y].setFitWidth(elementSize);
        imv[x][y].setFitHeight(elementSize);
    }
    void creatureLeaveSpace(int x, int y){
        map[x][y]=null;
        imv[x][y].setVisible(false);
    }
}

