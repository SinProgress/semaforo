package it.soundPack;
import javax.sound.sampled.*;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Sound {
    private URL url;
    private Clip audio;
    private final AudioInputStream audioInputStream;

    public Sound(String indirizzo) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
        this.url = new URL(indirizzo);
        this.audio = AudioSystem.getClip();
        // getAudioInputStream() also accepts a File or InputStream
        this.audioInputStream = AudioSystem.getAudioInputStream(url);

    }

    public void playSound(int durata) throws Exception{
        this.audio.open(audioInputStream);
        audio.loop(Clip.LOOP_CONTINUOUSLY);
        TimeUnit.SECONDS.sleep(durata);
    }

    public void stopSound(){
        audio.stop();
        audio.close();
        return;
    }
}
