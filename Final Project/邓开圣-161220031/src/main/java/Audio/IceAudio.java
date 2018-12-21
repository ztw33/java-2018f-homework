package Audio;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

import java.io.FileInputStream;
import java.io.IOException;

public class IceAudio extends MyAudio {
    private AudioStream ice;
    //private static AudioStream audio = null;
    /*static{
        try {
            audio = new AudioStream(new FileInputStream(wd + "\\resources\\audio\\explode.wav"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/
    public IceAudio(){
        try {
            ice = new AudioStream(new FileInputStream(wd + "\\resources\\audio\\ice.wav"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void run(){
        AudioPlayer.player.start(ice);
    }
}
