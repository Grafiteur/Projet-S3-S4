package edu.yokai_no_mori.c;

import edu.yokai_no_mori.m.Plateau;
import edu.yokai_no_mori.v.Fenetre;

public class ControlGroup {

    public ControlGroup(Plateau plateau) {
        Fenetre fenetre = new Fenetre(plateau);
        new ControlClick(plateau,fenetre);
        new ControlMenu(plateau,fenetre);
        fenetre.setVisible(true);
    }
}
