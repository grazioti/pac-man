package Ator;

import Labirinto.*;

public class Pacman implements IPacman {
    int i;
    int j;
    char caractere;
    ILabirinto labirinto;

    public int getI(){
        return i;
    }

    public int getJ(){
        return j;
    }

    public void setI(int i){
        this.i = i;
    }

    public void setJ(int j){
        this.j = j;
    }

    public char getChar(){
        return caractere;
    }

    public void setChar(char caractere){
        this.caractere = caractere;
    }

    public void moverAtor(){}

    public void montaAtor(int i, int j, char caractere){
        this.setI(i);
        this.setJ(j);
        this.setChar(caractere);
    }

    public void connect(ILabirinto labirinto){
        this.labirinto = labirinto;
    }
}

