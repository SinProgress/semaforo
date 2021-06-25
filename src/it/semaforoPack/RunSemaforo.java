package it.semaforoPack;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.util.Scanner;

public class RunSemaforo {

    public static void main(String[] args) throws Exception {

        Scanner inputUtente = new Scanner(System.in);
        Semaforo semaforo=new Semaforo();

        System.out.println("Vuoi cambiare la durata dei timer?");
        if(inputUtente.nextLine().equals("si")) {
            System.out.println("Inserisci la durata del rosso");
            int t1 = inputUtente.nextInt();
            System.out.println("Inserisci la durata del giallo");
            int t2 = inputUtente.nextInt();
            System.out.println("Inserisci la durata del verde");
            int t3 = inputUtente.nextInt();
            semaforo.setTimers(t1, t2, t3);
        }
        do{
            semaforo.go();
            System.out.println("Vuoi spegnere il semaforo?");
            if(inputUtente.nextLine().equals("si")) semaforo.Active=false;
        } while(semaforo.Active);
        System.out.println("Semaforo spento");

    }
}
