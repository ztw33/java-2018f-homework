package Audio;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

import java.io.FileInputStream;
import java.io.IOException;

public class WinAudio extends MyAudio{
    private AudioStream win;
    private static AudioStream audio = null;
    static{
        try {
            audio = new AudioStream(new FileInputStream(wd + "\\resources\\audio\\win.wav"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public WinAudio(){
        win = audio;
    }
    public void run(){
        AudioPlayer.player.start(win);
    }
}
