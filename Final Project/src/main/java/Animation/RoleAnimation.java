package Animation;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.util.Duration;

public class RoleAnimation extends MyAnimation {
    private int x, y;
    private int time;
    private GraphicsContext context;
    private Timeline timeline;
    private Image[] images;
    private int index;


    public RoleAnimation(GraphicsContext context, int x, int y, int time, Image[] images){
        this.context = context;
        this.x = x;this.y = y;
        this.time = time;
        this.images = images;
        index = 0;
        timeline = new Timeline();
        timeline.setCycleCount(images.length);
        run();
    }


    public void run() {
        timeline.getKeyFrames().add(new KeyFrame(Duration.millis(time), new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                context.clearRect(0,0,context.getCanvas().getWidth(),context.getCanvas().getHeight());
                Image current = images[index];
                context.drawImage(current,x,y);
                index ++;
                if(index >= images.length) index = 0;
            }
        }));

        timeline.playFromStart();

    }
}
