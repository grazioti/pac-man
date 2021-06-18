package Ator;

import Labirinto.ILabirinto;

public class Fantasma implements IFantasma {
    int i;
    int j;
    char caractere;
    int idx;
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
    public int getIdx(){
        return idx;
    }
    public void setIdx(int idx){
        this.idx = idx;
    }

    public void moverAtor(){}

    public void montaAtor(int i, int j, char caractere, int idx){
        this.setI(i);
        this.setJ(j);
        this.setChar(caractere);
        this.setIdx(idx);
    }

    public void connect(ILabirinto labirinto){
        this.labirinto = labirinto;
    }
}
