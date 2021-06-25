package it.timerPack;
import it.soundPack.Sound;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Timer {
    private int timer;
    private Sound playTickTock;
    private Sound playAlarm;
    private final String tickTockSound = "http://www.theflatnet.de/pub/sgfx/samples/TickTack.wav";
    private final String slowerTickTockSound = "http://cd.textfiles.com/10000soundssongs/WAV/TIC1.WAV";
    private final String alarmSound = "http://www.eng.auburn.edu/~sealscd/COMP7970/project/3Dstudio/levels/MISSION2/buzzer.wav";
    private final String meowSound = "http://cd.textfiles.com/multimediamania/WAVUTILS/113_WAVS/MEOW.WAV";

    public static final String ANSI_RESET = "\u001B[0m";
    private String ANSI_COLOR="\u001B[0m";

    public Timer(int n) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        this.timer=n;
        this.playTickTock = new Sound(tickTockSound);
        this.playAlarm = new Sound(alarmSound);
    }

    public void startTimer() throws Exception {
        System.out.println(ANSI_COLOR+"Sono partito "+timer+" secondi rimanenti"+ANSI_RESET);
        playTickTock.playSound(timer);
        playTickTock.stopSound();
        stopTimer();
    }

    private void stopTimer() throws Exception {
        System.out.println(ANSI_COLOR+"Tempo esaurito"+ANSI_RESET);
        playAlarm.playSound(2);
        playAlarm.stopSound();
    }
    public void setStringColor(String color){
        this.ANSI_COLOR=color;
    }

    public void resetTimer() {
        this.timer=0;
    }

    public void setTimer(int n)
    {
        this.timer=n;
    }
}

