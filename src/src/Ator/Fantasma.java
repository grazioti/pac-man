package Ator;

import Labirinto.ILabirinto;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Fantasma implements IFantasma{
    int i;
    int j;
    int shiftI;
    int shiftJ;
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

    public void montaAtor(int i, int j, char caractere, int idx){
        this.setI(i);
        this.setJ(j);
        this.setChar(caractere);
        this.setIdx(idx);
        this.shiftI = 1;
        this.shiftJ = 0;
    }

    public void connect(ILabirinto labirinto){
        this.labirinto = labirinto;
    }

    public void moverAtor(int pacI, int pacJ){
        labirinto.removerFantasma(i, j, idx);
        this.gerarMovimento(pacI, pacJ);

        this.i += shiftI;
        this.j += shiftJ;
        if (this.j > 27){
            this.j = 0;
        }
        if (this.j < 0){
            this.j = 27;
        }

        labirinto.connect(this, i, j, idx);
    }

    public void gerarMovimento(int pacI, int pacJ) {
        Random rand = new Random();
        int numAleatorio = 0;


            // Controla o movimento da abelha que segue o urso.
            if ((idx == 0) && (i < pacI) && (labirinto.ehMovimentoValido(i+1,j))) {
                shiftI = 1;
                shiftJ = 0;
            }
            else if ((idx == 0) && (i > pacI) && (labirinto.ehMovimentoValido(i-1,j))){
                shiftI = -1;
                shiftJ = 0;
            }
            else if ((idx == 0) && (j < pacJ) && (labirinto.ehMovimentoValido(i,j+1))) {
                shiftI = 0;
                shiftJ = 1;
            }
            else if ((idx == 0) && (j > pacJ) && (labirinto.ehMovimentoValido(i,j-1))) {
                shiftI = 0;
                shiftJ = -1;
            }


            // Controla o movimento da abelha que "acompanha" o pacman à frente.
            else if ((idx == 1) && (i < pacI + 2) && (labirinto.ehMovimentoValido(i+1,j))) {
                shiftI = 1;
                shiftJ = 0;
            }
            else if ((idx == 1) && (i > pacI + 2) && (labirinto.ehMovimentoValido(i-1,j))) {
                shiftI = -1;
                shiftJ = 0;
            }
            else if ((idx == 1) && (j < pacJ + 2) && (labirinto.ehMovimentoValido(i,j+1))) {
                shiftI = 0;
                shiftJ = 1;
            }
            else if ((idx == 1) && (j > pacJ + 2) && (labirinto.ehMovimentoValido(i,j-1))) {
                shiftI = 0;
                shiftJ = -1;
            }

            // Controla o movimento da abelha que acompanha o pacman atrás.
            else if ((idx == 2) && (i < pacI - 1) && (labirinto.ehMovimentoValido(i+1,j))) {
                shiftI = 1;
                shiftJ = 0;
            }
            else if ((idx == 2) && (i > pacI - 1) && (labirinto.ehMovimentoValido(i-1,j))) {
                shiftI = -1;
                shiftJ = 0;
            }
            else if ((idx == 2) && (j < pacJ - 1) && (labirinto.ehMovimentoValido(i,j+1))) {
                shiftI = 0;
                shiftJ = 1;
            }
            else if ((idx == 2) && (j > pacJ - 1) && (labirinto.ehMovimentoValido(i,j-1))) {
                shiftI = 0;
                shiftJ = -1;
            }

            // Para caso as movimentações específicas falhem, e para o caso da abelha preta, o movimento
            // é aleatório até que bata em uma parede, para definir uma nova direção de movimentação.
            else{
                if (!labirinto.ehMovimentoValido(i + shiftI, j + shiftJ)){
                    while (true){
                        // O número aleatório gerará 4 possíveis direções: 0: Baixo; 1: Cima; 2: Direita, 3: Esquerda.
                        numAleatorio = rand.nextInt(4);

                        if (numAleatorio == 0){
                            if (labirinto.ehMovimentoValido(i+1, j)){
                                shiftI = 1;
                                shiftJ = 0;
                                break;
                            }
                        }
                        else if (numAleatorio == 1){
                            if (labirinto.ehMovimentoValido(i-1, j)){
                                shiftI = -1;
                                shiftJ = 0;
                                break;
                            }
                        }
                        else if (numAleatorio == 2){
                            if (labirinto.ehMovimentoValido(i, j+1)){
                                shiftI = 0;
                                shiftJ = 1;
                                break;
                            }
                        }
                        else if (numAleatorio == 3){
                            if (labirinto.ehMovimentoValido(i, j-1)){
                                shiftI = 0;
                                shiftJ = -1;
                                break;
                            }
                        }
                    }
                }
        }
    }
}
