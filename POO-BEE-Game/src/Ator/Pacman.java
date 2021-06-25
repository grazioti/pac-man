package Ator;

import Labirinto.*;

public class Pacman implements IPacman {
    int i;
    int j;
    char caractere;
    ILabirinto labirinto;
    int score;

    boolean bolado;
    int qtdMovBolado;

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

    public int getScore(){
        return this.score;
    }

    public void montaAtor(int i, int j, char caractere){
        this.setI(i);
        this.setJ(j);
        this.setChar(caractere);
        this.bolado = false;
        this.qtdMovBolado = 0;
    }

    public void connect(ILabirinto labirinto){
        this.labirinto = labirinto;
    }

    public void moverAtor(int shiftI, int shiftJ){
        labirinto.removerPacman(i, j);

        score -= 2;

        this.i += shiftI;
        this.j += shiftJ;
        if (this.j > 27){
            this.j = 0;
        }
        if (this.j < 0){
            this.j = 27;
        }

        if (bolado) {
            qtdMovBolado--;
            if (qtdMovBolado == 0)
                bolado = false;
        }

        labirinto.connect(this, i, j);
    }

    //Verifica a sala que o pacman está, vendo se há uma pastilha, um ouro ou uma cereja. Para caso haja
    //um ouro, retornará true. Caso contrário, retorna false. Este retorno é dado para que o Timer do
    //objeto Controle diminua o tempo de movimentação dos fantasmas.
    public boolean verificarSala(){
        if(labirinto.haPastilha(i, j)){
            labirinto.removerPastilha(i, j);
            score += 10;
        }
        if(labirinto.haCereja(i, j)){
            labirinto.removerCereja(i, j);
            this.bolado = true;
            this.qtdMovBolado = 25;
        }
        if (labirinto.haOuro(i, j)){
            labirinto.removerOuro(i, j);
            this.score += 300;
            return true;
        }
        return false;
    }

    public boolean estaBolado(){
        return bolado;
    }

}
