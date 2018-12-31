package Frame;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.canvas.GraphicsContext;

//游戏中所有物体的父类, 提供相关的基本数据和公共操作
public abstract class GameObject {
    //使用Property以便于必要时进行绑定
    protected IntegerProperty xProperty = new SimpleIntegerProperty(0);
    protected IntegerProperty yProperty = new SimpleIntegerProperty(0);
    protected IntegerProperty widthProperty = new SimpleIntegerProperty(0);
    protected IntegerProperty heightProperty = new SimpleIntegerProperty(0);
    protected BooleanProperty updateProperty = new SimpleBooleanProperty(true);
    protected BooleanProperty visibleProperty = new SimpleBooleanProperty(true);
    protected BooleanProperty isGoodProperty = new SimpleBooleanProperty(true);
    protected static final String wd = System.getProperty("user.dir");

    public GameObject(){
        this.xProperty = new SimpleIntegerProperty(0);
        this.yProperty = new SimpleIntegerProperty(0);
        this.widthProperty = new SimpleIntegerProperty(0);
        this.heightProperty = new SimpleIntegerProperty(0);
    }

    public GameObject(int x, int y, int width, int height,boolean good){
        this.xProperty = new SimpleIntegerProperty(x);
        this.yProperty = new SimpleIntegerProperty(y);
        this.widthProperty = new SimpleIntegerProperty(width);
        this.heightProperty = new SimpleIntegerProperty(height);
        this.isGoodProperty = new SimpleBooleanProperty(good);
    }

    //画图函数
    public abstract void draw(GraphicsContext gc);
    //更新屏幕函数
    public abstract void update();

    //以下是一些getters和setters
    public IntegerProperty xProperty() {
        return xProperty;
    }

    public IntegerProperty yProperty(){
        return yProperty;
    }

    public IntegerProperty widthProperty(){
        return widthProperty;
    }

    public IntegerProperty heightProperty(){
        return heightProperty;
    }

    public BooleanProperty visibleProperty(){
        return this.visibleProperty;
    }

    public int getX(){
        return this.xProperty.get();
    }

    public void setX(int x){
        this.xProperty.set(x);
    }

    public int getY(){
        return this.yProperty.get();
    }

    public void setY(int y){
        this.yProperty.set(y);
    }

    public int getWidth(){
        return this.widthProperty.get();
    }

    public void setWidth(int width) {
        this.widthProperty.set(width);
    }

    public int getHeight(){
        return this.heightProperty.get();
    }

    public void setHeight(int height) {
        this.heightProperty.set(height);
    }

    public boolean isVisible() {
        return visibleProperty.get();
    }

    public void setVisible(boolean visible) {
        this.visibleProperty.set(visible);
    }

    public boolean isUpdate() {
        return updateProperty.get();
    }

    public boolean isGood() {
        return isGoodProperty.get();
    }

}
