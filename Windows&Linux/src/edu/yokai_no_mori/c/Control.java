package edu.yokai_no_mori.c;

import edu.yokai_no_mori.m.Plateau;
import edu.yokai_no_mori.v.Fenetre;

public class Control {

    Plateau plateau;
    Fenetre fenetre;

    public Control(Plateau plateau, Fenetre fenetre) {
        this.fenetre = fenetre;
        this.plateau = plateau;
    }
}
