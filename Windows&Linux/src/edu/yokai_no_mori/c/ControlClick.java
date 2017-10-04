package edu.yokai_no_mori.c;


import edu.yokai_no_mori.m.Plateau;
import edu.yokai_no_mori.v.Fenetre;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by bcontrer on 04/10/17.
 */
public class ControlClick  extends Control implements MouseListener {


    public ControlClick(Plateau plateau, Fenetre fenetre){
        super(plateau, fenetre);
        fenetre.setControlClick(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
