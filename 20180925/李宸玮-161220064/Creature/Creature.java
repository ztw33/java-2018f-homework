package Creature;

import World.Position;

public abstract class Creature {
    protected Position position=new Position();
    public String image;;//暂时用Sting来表示其形象，待图形化时要打印的则是真正的image

    public void setImage(String image) {
        this.image = image;
    }
    public void moveto(int x, int y){
        this.position.setPositoin(x,y);//设置其位置
    }
    public void move(int xpos,int ypos){
        this.position.changePosition(xpos,ypos); //在现有位置上移动
    }
    public Position getposition(){
        return this.position;
    }

   // public abstract int compare(Huluwa hulu);
}
