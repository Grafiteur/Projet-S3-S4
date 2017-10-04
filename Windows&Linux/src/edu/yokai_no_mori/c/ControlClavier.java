package edu.yokai_no_mori.c;

import edu.yokai_no_mori.m.Plateau;
import edu.yokai_no_mori.v.Fenetre;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by david on 04/10/16.
 */

public class ControlClavier extends Control implements KeyListener {

    private long lastPressProcessed;


    ControlClavier(Plateau plateau, Fenetre fenetre) {
        super(plateau, fenetre);
        fenetre.setControlClavier(this);
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {

        if (System.currentTimeMillis() - lastPressProcessed > 200) {

            if (!plateau.isPause()) {
                switch (keyEvent.getKeyCode()) {

                    case KeyEvent.VK_LEFT:
                        break;

                    case KeyEvent.VK_UP:
                        break;

                    case KeyEvent.VK_RIGHT:
                        break;

                    case KeyEvent.VK_DOWN:
                        break;

                    case KeyEvent.VK_P:
                        plateau.setPause(!plateau.isPause());
                        break;
                }
            } else if (keyEvent.getKeyCode()==KeyEvent.VK_P){
                plateau.setPause(!plateau.isPause());
            }

            lastPressProcessed = System.currentTimeMillis();
        }
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
    }
}
