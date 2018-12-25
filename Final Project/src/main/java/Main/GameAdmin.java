package Main;

import Enums.Direction;
import Enums.Status;
import Frame.GameScreen;
import Thing.IceSword;
import Character.*;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;


//游戏屏幕类, 同时管理所有游戏元素
public class GameAdmin extends GameScreen {
    //创建一个女战士
    public Fighter cindy = new Fighter(200,100,50,120, Direction.Right,true,this);
    public IceSword iceSword = new IceSword(300,300,Direction.Left,true,this);
    private int numMonster = 5;         //初始怪物数量
    public GameAdmin(double x, double y, double width, double height) {
        super(x, y, width, height);
        addObject(cindy);
        addObject(new Snake(300,400,50,50,Direction.Left,false,this));
        addObject(new Snake(500,200,50,50,Direction.Up,false,this));
        addObject(new Snake(1000,200,50,50,Direction.Right,false,this));
        addObject(new Snake(700,500,50,50,Direction.Left,false,this));
        addObject(new Snake(600,600,50,50,Direction.Down,false,this));
        addObject(iceSword);

    }

    @Override
    protected void onKeyPressed(KeyEvent event) {
        switch (event.getCode()){
            case A: cindy.setDirection(Direction.Left);cindy.setStatus(Status.Moving);break;
            case D: cindy.setDirection(Direction.Right);cindy.setStatus(Status.Moving);break;
            case W: cindy.setDirection(Direction.Up); cindy.setStatus(Status.Moving);break;
            case S: cindy.setDirection(Direction.Down);cindy.setStatus(Status.Moving);break;
            case K: cindy.attack();break;
            case I:{
                if(!cindy.isArmed()) cindy.setWeapon(iceSword);
                else cindy.unsetWeapon();
                break;
            }
            case L:{
                if(cindy.isArmed()) cindy.shield();
                break;
            }
        }
    }

    @Override
    protected void onKeyReleased(KeyEvent event) {

        switch (event.getCode()){
            case A:
            case D:
            case W:
            case S:
                cindy.setStatus(Status.Standing);break;
        }
    }

    @Override
    protected void onMouseClicked(MouseEvent event) {

    }

    public int getNumMonster() { return numMonster; }

    public void setNumMonster(int numMonster) { this.numMonster = numMonster; }
}
