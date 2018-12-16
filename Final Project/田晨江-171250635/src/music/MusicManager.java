package music;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class MusicManager {

    public static MediaPlayer getMediaPlayer(String s) {

        return new MediaPlayer(new Media(""));
    }
}
