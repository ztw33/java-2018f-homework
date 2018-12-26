package formations;

import beings.Creature;
import beings.JustParty;

public abstract class Formation {
    public Formation(){
        posList = null;
    }
    public void formationCreatrue(Battlefield field, Creature[] list, Creature cheerOne) {
        int starty1 = (field.getHeight()-height)/2;
        int startx1 = (field.getWidth()/2-width);
        int starty = (field.getHeight()-height)/2;
        int startx = (field.getWidth()/2+width);
        //System.out.print("output:"+(startx-cheerPos.posx));
        //System.out.print("output:"+(starty+cheerPos.posy));
        if(cheerOne instanceof JustParty){
            field.setCreature(startx1+cheerPos.posx, starty1+cheerPos.posy, cheerOne);
        }
        else {
            field.setCreature(startx - cheerPos.posx, starty + cheerPos.posy, cheerOne);
        }
        for(int i = 0; i < list.length; i++){
            if(list[i] instanceof JustParty){
                field.setCreature(startx1+posList[i].posx, starty1+posList[i].posy, list[i]);
            }
            else{
                field.setCreature(startx-posList[i].posx, starty+posList[i].posy, list[i]);
            }
        }
    }
    protected class Pos{
        private int posx;
        private int posy;
        Pos(){

        }
        Pos(int y, int x){
            posx = x;
            posy = y;
        }
        void set(int y, int x){
            posx = x;
            posy = y;
        }
    }
    protected FormationType type;
    protected int height;
    protected int width;
    protected Pos[] posList;
    protected Pos cheerPos = new Pos();
}
