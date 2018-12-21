package Audio;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

import java.io.FileInputStream;
import java.io.IOException;

public class ShieldAudio extends MyAudio {
    private AudioStream shield;
    //private static AudioStream audio = null;
    /*static{
        try {
            audio = new AudioStream(new FileInputStream(wd + "\\resources\\audio\\shield.wav"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/
    public ShieldAudio(){
        try {
            shield = new AudioStream(new FileInputStream(wd + "\\resources\\audio\\shield.wav"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void run(){
        AudioPlayer.player.start(shield);
    }
}
