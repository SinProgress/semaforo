package it.semaforoPack;
//import Users.Sabina.Desktop.ESERCIZI_JAVA.EsercizioEccezione.src.it.timerPack;
import it.timerPack.Timer;

import it.semaforoPack.ColorTrafficLight;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class Semaforo {
    private ColorTrafficLight statoSemaforo; // colore del semaforo attuale
    private Timer tRed; // timer di durata di ciascun colore
    private Timer tYellow;
    private Timer tGreen;
    protected boolean Active=true; // semaforo attivo o meno

    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";

    public Semaforo() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        this.statoSemaforo =new ColorTrafficLight();
        this.tGreen= new Timer(5);
        this.tRed= new Timer(7);
        this.tYellow= new Timer(2);
    }

    public void setTimers(int tR, int tY, int tG){
        this.tRed.setTimer(tR);
        this.tGreen.setTimer(tG);
        this.tYellow.setTimer(tY);

    }

    public void setRed(){
        if(statoSemaforo.getColore().equals("yellow")) statoSemaforo.setColore("red");
        printStato();
    }
    public void setYellow(){
        if(statoSemaforo.getColore().equals("verde")) statoSemaforo.setColore("yellow");
        printStato();
    }
    public void setGreen(){
        if(statoSemaforo.getColore().equals("red")) statoSemaforo.setColore("green");
        printStato();
    }

    public void printStato(){
        System.out.println(statoSemaforo.getColore());
    }
    public void go() throws Exception {
        this.setRed();
        this.tRed.setStringColor(ANSI_RED);
        this.tRed.startTimer();
        this.setGreen();
        this.tGreen.setStringColor(ANSI_GREEN);
        this.tGreen.startTimer();
        this.setYellow();
        this.tYellow.setStringColor(ANSI_YELLOW);
        this.tYellow.startTimer();
    }
}
