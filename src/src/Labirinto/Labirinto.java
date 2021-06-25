package Labirinto;

import Ator.*;

public class Labirinto implements ILabirinto{
    protected Sala[][] labirinto;
    private int linhas;
    private int colunas;
    private int qtdPastilhas;

    public void montaLabirinto(int linhas, int colunas){
        labirinto = new Sala[linhas][colunas];
        for (int i = 0; i < linhas; i++){
            for (int j = 0; j < colunas; j++){
                labirinto[i][j] = new Sala();
            }
        }
        this.linhas = linhas;
        this.colunas = colunas;
    }

    //conecta os atores que não podem se movem à sala ij do labirinto, de acordo com a posição lida no CSV
    public void connect(IAtorEstatico ator, int i, int j){
        char caractere = ator.getChar();
        if (caractere == 'W')
            labirinto[i][j].setMuro(ator);
        else if (caractere == 'O')
            labirinto[i][j].setOuro(ator);
        else if (caractere == 'C')
            labirinto[i][j].setCereja(ator);
    }

    //conecta o Pacman à sala ij do labirinto, de acordo com a posição lida no CSV
    public void connect(IPacman ator, int i, int j){
        labirinto[i][j].setPacman(ator);
    }

    //conecta o Fantasma de índice idx à sala ij do labirinto, de acordo com a posição lida no CSV
    public void connect(IFantasma ator, int i, int j, int idx){
        labirinto[i][j].setFantasma(idx, ator);
    }

    //atualiza a condição da pastilha na sala[i][j] do labirinto.
    public void atualizaPastilha(int i, int j, boolean condicao){
        this.labirinto[i][j].setPastilha(condicao);
    }

    //retorna se há pastilha na sala[i][j] do labirinto.
    public boolean haPastilha(int i, int j){
        return labirinto[i][j].getPastilha();
    }

    /*
    Retorna uma matriz de String, onde cada String representa o que aparecerá na interface gráfica, de acordo
    com o que há na sala labirinto[i][j].
    OBS.: essa aparição segue a seguinte propriedade: Parede > Pacman > Fantasma > Cereja = Ouro > Pastilha
   */
    public String[][] labirintoToString(){
        String[][] matrizRetorno = new String[linhas][colunas];

        for (int i = 0; i < linhas; i++){
            for (int j = 0; j < colunas; j++){
                if (labirinto[i][j].getMuro() != null){
                    matrizRetorno[i][j] = "W";
                    continue;
                }
                else if (labirinto[i][j].getPacman() != null) {
                    if (labirinto[i][j].getPacman().estaBolado()){
                        matrizRetorno[i][j] = "B";
                        continue;
                    }
                    else {
                        matrizRetorno[i][j] = "P";
                        continue;
                    }
                }
                else if (labirinto[i][j].getFantasma(0) != null){
                    matrizRetorno[i][j] = "V";
                    continue;
                }
                else if (labirinto[i][j].getFantasma(1) != null){
                    matrizRetorno[i][j] = "A";
                    continue;
                }
                else if (labirinto[i][j].getFantasma(2) != null){
                    matrizRetorno[i][j] = "R";
                    continue;
                }
                else if (labirinto[i][j].getFantasma(3) != null){
                    matrizRetorno[i][j] = "L";
                    continue;
                }
                else if (labirinto[i][j].getCereja() != null){
                    matrizRetorno[i][j] = "C";
                    continue;
                }
                else if (labirinto[i][j].getOuro() != null){
                    matrizRetorno[i][j] = "O";
                    continue;
                }
                else if (labirinto[i][j].getPastilha()){
                    matrizRetorno[i][j] = "p";
                    continue;
                }
                else{
                    matrizRetorno[i][j] = "-";
                    continue;
                }
            }
        }
        return matrizRetorno;
    }

    public boolean ehMovimentoValido(int iFim, int jFim){
        if ((iFim < this.linhas) && (iFim >= 0) && (jFim >= 0) && (jFim < this.colunas)) {
            if (labirinto[iFim][jFim].getMuro() == null) {
                return true;
            }
            return false;
        }
        else{
            return true;
        }
    }

    public void setQtdPastilhas(int qtd_pastilhas){
        this.qtdPastilhas = qtd_pastilhas;
    }

    public int getQtdPastilhas(){
        return this.qtdPastilhas;
    }

    public void removerPacman(int i, int j){
        labirinto[i][j].setPacman(null);
    }

    public void removerPastilha(int i, int j){
        this.labirinto[i][j].setPastilha(false);
        this.qtdPastilhas--;
    }

    public void removerFantasma(int i, int j, int idx){
        labirinto[i][j].setFantasma(idx,null);
    }

    public void removerOuro(int i, int j){
        labirinto[i][j].setOuro(null);
    }

    public void removerCereja(int i, int j){
        labirinto[i][j].setCereja(null);
    }

    public boolean haCereja(int i, int j){
        if (labirinto[i][j].getCereja() == null){
            return false;
        }
        return true;
    }

    public boolean haOuro(int i, int j){
        if (labirinto[i][j].getOuro() == null){
            return false;
        }
        return true;
    }

    public boolean haMuro(int i, int j){
        if (labirinto[i][j].getMuro() == null){
            return false;
        }
        return true;
    }
}