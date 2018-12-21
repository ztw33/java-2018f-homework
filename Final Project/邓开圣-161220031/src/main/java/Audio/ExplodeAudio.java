package Audio;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

import java.io.FileInputStream;
import java.io.IOException;

public class ExplodeAudio extends MyAudio{
    private AudioStream explode;
    //private static AudioStream audio = null;
    /*static{
        try {
            audio = new AudioStream(new FileInputStream(wd + "\\resources\\audio\\explode.wav"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/
    public ExplodeAudio(){
        try {
            explode = new AudioStream(new FileInputStream(wd + "\\resources\\audio\\explode.wav"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void run(){
        AudioPlayer.player.start(explode);
    }
}
