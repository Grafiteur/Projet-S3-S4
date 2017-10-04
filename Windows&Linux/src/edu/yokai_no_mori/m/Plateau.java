package edu.yokai_no_mori.m;

import java.util.ArrayList;
import java.util.List;

public class Plateau {

    public final int LIGNE = 8, COLONNE = 7, NB_SCORE_MAX = 10;

    private float temps;
    private boolean pause, inGame;

    private char[][] map;
    protected List<Piece> piecesJ1, piecesJ2;

    public Plateau(){
        inGame = false;
        nouvelleManche();
    }

    private void nouvelleManche(){
        map = new char[LIGNE][COLONNE];

        for(int i = 0; i < map.length; i++) {
            map[i][0] = '#';
            map[i][map[0].length-1] = '#';
            for(int j = 0; j < map[0].length; j++) {
                map[0][j] = '#';
                map[map.length-1][j] = '#';
                if(!(map[i][j]=='#')) {
                    map[i][j] = '.';
                }
            }
        }
//      Génération des deux joueurs
        piecesJ1 = new ArrayList<>();
        piecesJ2 = new ArrayList<>();
        int i;

//      #Kodama
        for (i = 2; i < 5; i++) {
            piecesJ1.add(new Piece(Etat.PLATEAU, i,3, 1, Personnage.KODAMA, this));
            piecesJ2.add(new Piece(Etat.PLATEAU, i,4, -1, Personnage.KODAMA, this));
        }

//      #Oni
        for (i = 0; i < 2; i++) {
            piecesJ1.add(new Piece(Etat.PLATEAU, i*4+1,1, 1, Personnage.ONI, this));
            piecesJ2.add(new Piece(Etat.PLATEAU, i*4+1,6, -1, Personnage.ONI, this));
        }

//      #Kirin
        for (i = 0; i < 2; i++) {
            piecesJ1.add(new Piece(Etat.PLATEAU, i*2+2,1, 1, Personnage.KIRIN, this));
            piecesJ2.add(new Piece(Etat.PLATEAU, i*2+2,6, -1, Personnage.KIRIN, this));
        }

//      #Koropokkuru
        piecesJ1.add(new Piece(Etat.PLATEAU, 3,1, 1, Personnage.KOROPOKKURU, this));
        piecesJ2.add(new Piece(Etat.PLATEAU, 3,6, -1, Personnage.KOROPOKKURU, this));

        placeCharAll();
        affiche();
    }


    public boolean checkSiEnEchec(){
        ///
        /// A REMPLIR
        ///
        return false;
    }

    public void combat() {

    }

    public void affiche(){
        for(int ligne = 0 ; ligne < map.length ; ligne ++) {
            for(int colonne = 0; colonne < map[0].length; colonne++) {
                System.out.print("["+map[ligne][colonne]+"]");
            }
            System.out.print("\n");
        }
    }

    public void mouvement(int colA, int ligneA, int colB, int ligneB) {
        Piece piece = getPieceFromCoord(colA, ligneA);
        if (!checkSiEnEchec()) {
            if (piece.checkDeplacement(colB, ligneB)) {
                ///
                /// A REMPLIR
                ///
                move(piece, colB, ligneB);
            }
        }
    }

    public void placeCharAll(){
        for(Piece p : piecesJ1){
            map[p.getLigne()][p.getCol()]= p.getChar();
        }
        for(Piece p : piecesJ2){
            map[p.getLigne()][p.getCol()]= p.getChar();
        }
    }

    public void placeChar(Piece piece){
        map[piece.getLigne()][piece.getCol()]= piece.getChar();
    }

    public Piece getPieceFromCoord(int col, int ligne){
        for(Piece p : piecesJ1){
            if (p.getCol()==col && p.getLigne()==ligne) return p;
        }
        for(Piece p : piecesJ2){
            if (p.getCol()==col && p.getLigne()==ligne) return p;
        }
        return null;
    }

    public void libereChar(int col, int ligne){
        setElement(col, ligne, '.');
    }

    public void move(Piece piece, int col, int ligne){
        libereChar(piece.getCol(), piece.getLigne());
        piece.setCoord(col, ligne);
        placeChar(piece);
    }

    public boolean isPause() {
        return pause;
    }

    public float getTemps() {
        return temps;
    }

    public void setTemps(float temps) {
        this.temps = temps;
    }

    public void setElement(int col, int ligne, char c){
        map[ligne][col] = c;
    }

    public void setPause(boolean pause){
        this.pause = pause;
    }

    public char[][] getMap() {
        return map;
    }

}
