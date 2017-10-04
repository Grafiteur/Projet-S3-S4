package edu.yokai_no_mori;

import edu.yokai_no_mori.c.ControlGroup;
import edu.yokai_no_mori.m.Plateau;

public class Appli {
    public static void main(String[] args) {
        Plateau p = new Plateau(); //* Création du model
        ControlGroup c = new ControlGroup(p); //* Création du controleur
    }
}
