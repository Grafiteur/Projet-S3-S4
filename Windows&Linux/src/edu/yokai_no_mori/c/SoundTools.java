package edu.yokai_no_mori.c;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Created by david on 04/10/16.
 */

public class SoundTools {

    private static FileInputStream[] sonsPrincipals;
    private static FileInputStream[] sonsEvenements;
    private static Player sonJeux;
    private static Player sonEvent;
    private static Thread sonActuel;

    public final static int SOUND_MENU = 0;
    public final static int SOUND_THEME = 1;

    public final static int BOUTON_MENU_SOUND = 0;
    public final static int MALUS_SOUND = 1;
    public final static int UP_SOUND = 2;
    public final static int COLLISION_ROCK_SOUND = 3;
    public final static int COLLISION_ENNEMI_SOUND = 4;

    public static void playSonPrincipal(final int _i) {

        sonActuel = new Thread(new Runnable() {
            public void run() {

                while (true) {
                    loadSoundPrincipal();
                    createPlayer(_i);
                    try {
                        sonJeux.play();
                    } catch (JavaLayerException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        sonActuel.start();
    }

    public static void playSonEvent(final int _i) {

        loadSoundEvent();

        try {
            sonEvent = new Player(sonsEvenements[_i]);
        } catch (JavaLayerException e) {
            e.printStackTrace();
        }

        new Thread(new Runnable() {
            public void run() {
                try {
                    sonEvent.play();
                } catch (JavaLayerException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public static void stop() {
        sonActuel.stop();
    }

    private static void loadSoundPrincipal() {

        try {
            sonsPrincipals = new FileInputStream[2];
            sonsPrincipals[0] = new FileInputStream("sound/ambiance.mp3");
            sonsPrincipals[1] = new FileInputStream("sound/menu.mp3");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void loadSoundEvent() {

        try {
            sonsEvenements = new FileInputStream[4];
            sonsEvenements[0] = new FileInputStream("sound/boutonMenu.mp3");
            sonsEvenements[1] = new FileInputStream("sound/deplacement.mp3");
            sonsEvenements[2] = new FileInputStream("sound/bonus.mp3");
            sonsEvenements[3] = new FileInputStream("sound/deplacementImpossible.mp3");
            sonsEvenements[4] = new FileInputStream("sound/promotion.mp3");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void createPlayer(int _i) {
        try {
            sonJeux = new Player(sonsPrincipals[_i]);
        } catch (JavaLayerException e) {
            e.printStackTrace();
        }
    }
}
