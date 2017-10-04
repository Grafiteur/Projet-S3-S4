package edu.yokai_no_mori.c;

import edu.yokai_no_mori.m.Plateau;
import edu.yokai_no_mori.v.Fenetre;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlMenu extends Control implements ActionListener {

    public ControlMenu(Plateau p, Fenetre f){
        super(p,f);
        this.fenetre.setControlMenu(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
