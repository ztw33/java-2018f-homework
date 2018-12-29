package jchan.calabash.picture;

import jchan.calabash.calabashworld.*;

import java.awt.*;
import java.awt.image.BufferedImage;

public class DrawNPCs {
    public static void drawNPC(BufferedImage background,BufferedImage npc,int x,int y){
        Graphics graph = background.createGraphics();
        graph.drawImage(npc,x,y,GetPic.PICSIZE,GetPic.PICSIZE,null);
        graph.dispose();
    }
    public static void drawNPCs(BufferedImage background, Field field, int x, int y, int m, int n){
        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){
                if(field.cells[i][j][0].isExist()){
                    drawNPC(background,GetPic.getPic(field.cells[i][j][0].getThing().whoami()),
                            (int)((field.cells[i][j][0].getThing().getY() - y) * GetPic.PICSIZE),
                            (int)((field.cells[i][j][0].getThing().getX() - x) * GetPic.PICSIZE));
                }
            }
        }
    }
}
