package Ator;

public class Muro implements IAtorEstatico {
    int i;
    int j;
    char caractere;

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

    public void montaAtor(int i, int j, char caractere){
        this.setI(i);
        this.setJ(j);
        this.setChar(caractere);
    }
}