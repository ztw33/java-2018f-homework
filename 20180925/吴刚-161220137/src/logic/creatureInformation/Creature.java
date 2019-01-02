package logic.creatureInformation;/*
 * @author:Wu Gang
 * @create: 2018-10-07 19:15
 */

import javafx.scene.image.Image;
import logic.position.Position;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public abstract class Creature<T> implements Skill{
    private Position<Creature> position = new Position<>(-1, -1, null);
    private Image myImage;
    public abstract void sayName();

    private Class<T> imageClass;
    private T image;
    public void moveTo(Position<Creature> position){
        this.position.setCreature(null);
        this.position = position;
        this.position.setCreature(this);
    }

    public Creature() {
        String fileName = this.getClass().getName().split("\\.")[this.getClass().getName().split("\\.").length - 1] + ".png";
        String url = "resources/" + fileName;
//        this.myImage = new Image(url);
    }

    public Creature(Class<T> imageClass){
        this.imageClass = imageClass;
        String fileName = this.getClass().getName().split("\\.")[this.getClass().getName().split("\\.").length - 1] + ".png";
        String url = "resources/" + fileName;

        try {
            Constructor constructor = this.imageClass.getConstructor(String.class);
            this.image = (T) constructor.newInstance(url);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public Image getMyImage() {
        return myImage;
    }

    public T getImage() {
        return image;
    }
}





