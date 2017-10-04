package edu.yokai_no_mori.v;

import edu.yokai_no_mori.c.ControlClavier;
import edu.yokai_no_mori.c.ControlClick;
import edu.yokai_no_mori.c.ControlMenu;
import edu.yokai_no_mori.m.Plateau;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Created by bcontrer on 04/10/17.
 */
public class Fenetre extends JFrame {

    //* Composants graphiques
    private JPanel fenetre;
    //* Autres
    private Plateau plateau;

    public Fenetre(Plateau plateau){
        this.plateau = plateau;
        creerFenetre();
        initMenu();
        addToWindow();
        pack();
        setTitle("Yokaï no mori");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    //* Méthodes pour créer la fenêtre
    public void creerFenetre() {
        //* Création de tout les composants graphiques de la fenetre ( sauf Menu )

    }

    public void initMenu() {
        //* Création des componsants du menu

    }
    public void addToWindow() {
        //* Ajouts des composants graphique dans la fenêtre principales
        this.fenetre = new JPanel();
        //* this.fenetre.add(...);
        setContentPane(this.fenetre);
    }


    //* Méthodes pour initialiser les controleurs
    public void setControlMenu(ActionListener cm){
        //nouvellePartie.addActionListener(cm);

        //score.addActionListener(cm);
    }

    public void setControlClick(ControlClick controlClick) {
        addMouseListener(controlClick);
    }

    public void setControlClavier(ControlClavier controlClavier) {
        addKeyListener(controlClavier);
    }

    //* ...
}
