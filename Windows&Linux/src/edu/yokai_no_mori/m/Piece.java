package edu.yokai_no_mori.m;

public class Piece {
    private Etat etat;
    protected int camp;
    private int col;
    private int ligne;
    private boolean transformation;
    private Personnage personnage;
    private char c;


    public Piece(Etat etat, int col, int ligne, int camp, Personnage personnage, Plateau plateau){
        this.col = col;
        this.ligne = ligne;
        this.etat = etat;
        transformation = false;
        this.camp = camp;
        this.personnage = personnage;
        if (personnage == Personnage.KIRIN || personnage == Personnage.KOROPOKKURU) transformation = true;
        setChar();
        c = getChar();
    }

    public void setChar() {
        switch (personnage){
            case KIRIN:
                c = 'i';
                break;
            case KOROPOKKURU:
                c = 'r';
                break;
            case KODAMA:
                if (transformation) c = 'd';
                else c = 'k';
                break;
            default:
                if (transformation) c = 'd';
                else c = 'o';
                break;
        }
    }

    public char getChar(){
        return c;
    }

    public boolean checkDeplacement(int col, int ligne) {
        if (this.getEtat() == Etat.PLATEAU){

//          #On regarde si on touche pas les bords de la map
            if (col == 0 || ligne == 0) {
                return false;
            }

//          #Avant
            if ((this.col == col) &&(this.ligne+camp == ligne)) return true;

//          #On sort si on est un Kodama non transformé
            if (personnage == Personnage.KODAMA && !transformation) return false;

//          #Diagonale avant
            if (((this.col+camp == col) && (this.ligne+camp == ligne))
                    || ((this.col)-camp == col) && (this.ligne+camp == ligne)) return true;

            if (isTransformation()){
//              #Arriere
                if (((this.col == col) && (this.ligne-camp == ligne))
//                      #Coté
                        || ((this.col+camp == col) && (this.ligne == ligne))
                        || ((this.col-camp == col) && (this.ligne == ligne))
                        ) return true;
            }

//          # Si Koropokkuru ou oni transformé : on test le deplacement diagonale arriere
            if (personnage == Personnage.KOROPOKKURU || (personnage == Personnage.ONI && transformation)) {
                if (((this.col+camp == col) && (getLigne()-camp == ligne))
                        || ((this.col-camp == col) && (getLigne()-camp == ligne))) return true;
            }
        }
        return false;
    }


    public boolean isTransformation() {
        return transformation;
    }

    public void setTransformation(boolean transformation) {
        this.transformation = transformation;
    }

    public Etat getEtat() {
        return etat;
    }

    public void changeEtat() {
        if (etat == Etat.PLATEAU) etat = Etat.MAIN;
        else etat = Etat.PLATEAU;
    }

    public void setCoord(int col,int ligne) {
        this.col = col;
        this.ligne = ligne;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int getLigne() {
        return ligne;
    }

    public void setLigne(int ligne) {
        this.ligne = ligne;
    }
}
