package Frame;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;

//游戏屏幕的父类
//??draw()和update()的调用关系是什么? 其各自的功能有什么区别?
public abstract class GameScreen extends Canvas {
    private List<GameObject> objectList = new ArrayList<>();    //存放游戏中所有物体的容器
    private Timeline timeline;
    private KeyFrame keyFrame;
    private int duration = 30;

    protected double x, y, width, height;       //屏幕的位置和长、宽
    public GameScreen(double x, double y,double width,double height){
        super(width,height);
        this.x = x; this.y = y;
        this.width = width; this.height = height;
        setLayoutX(x); setLayoutY(y);
        initTimeLine();
    }

    //初始化事件处理函数
    public void initEvents(){
        getParent().getScene().setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                onKeyPressed(event);
            }
        });
        getParent().getScene().setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                onKeyReleased(event);
            }
        });
        getParent().getScene().setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                onMouseClicked(event);
            }
        });
    }
    //事件处理函数在子类中实现
    protected abstract void onKeyPressed(KeyEvent event);
    protected abstract void onKeyReleased(KeyEvent event);
    protected abstract void onMouseClicked(MouseEvent event);
    //添加和删除物体
    public void addObject(GameObject object){
        this.objectList.add(object);
    }
    public void removeObject(GameObject object){
        this.objectList.remove(object);
    }
    public void removeObjectByIndex(int index){
        this.objectList.remove(index);
    }

    //画出所有物体
    //GraphicsContext相当于一支画笔(效果基本等同于Java2D中的Graphics)
    public void draw(GraphicsContext gc){
        gc.clearRect(0,0,getWidth(),getHeight());   //清屏
        for(int i=0;i<objectList.size();i++){
            GameObject o = objectList.get(i);
            if(o.isVisible()){
                o.draw(gc);
            }
        }
        /*for(GameObject object:objectList){
            if(object.isVisible()){     //判断物体是否为可见状态
                object.draw(gc);
            }
        }*/
    }
    //更新所有物体  ???
    public void update(){
        for(GameObject object:objectList){
            if(object.isUpdate()){
                object.update();
            }
        }
    }
    //初始化时间表
    private void initTimeLine(){
        timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);        //无限循环
        //KeyFrame相当于timeline上的一"帧"画面, 也可以理解为时间表上的一个事件
        keyFrame = new KeyFrame(Duration.millis(duration), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                draw(getGraphicsContext2D());   //获取当前Canvas的画笔并不断执行重画
                update();
            }
        });
        timeline.getKeyFrames().add(keyFrame);  //将该帧添加到timeline中

    }
    //开始执行时间表
    public void start(){
        timeline.play();
    }
    //暂停执行时间表
    public void pause(){
        timeline.pause();
    }
    //停止时间表
    public void stop(){
        timeline.stop();
    }

    public List<GameObject> getObjectList() {
        return objectList;
    }

    public GraphicsContext getGraphics(){
        return getGraphicsContext2D();
    }
}
