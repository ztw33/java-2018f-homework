package Animation;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.util.Duration;

public class WeaponAnimation extends MyAnimation{
    private int x, y;
    private int time;
    private GraphicsContext context;
    private Timeline timeline;
    private Image[] images;
    private int index;
    private int[][] modify;

    public WeaponAnimation(GraphicsContext context, int x, int y, int time, Image[] images, int[][] modify){
        this.context = context;
        this.x = x;this.y = y;
        this.time = time;
        this.images = images;
        this.modify = modify;
        index = 0;
        timeline = new Timeline();
        timeline.setCycleCount(images.length);
    }

    public void run() {
        timeline.getKeyFrames().add(new KeyFrame(Duration.millis(time), new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                context.clearRect(0,0,context.getCanvas().getWidth(),context.getCanvas().getHeight());
                Image current = images[index];
                context.drawImage(current,x+modify[index][0],y+modify[index][1]);
                index ++;
                if(index >= images.length) index = 0;
            }
        }));

        timeline.playFromStart();
    }
}
