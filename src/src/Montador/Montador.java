package Montador;

import Controle.*;
import Labirinto.*;
import Ator.*;

public class Montador implements IMontador{
    String[][] tabuleiro = {{"W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W"},
                            {"W","p","p","p","p","p","p","p","p","p","p","p","p","W","W","p","p","p","p","p","p","p","p","p","p","p","p","W"},
                            {"W","O","W","W","W","W","p","W","W","W","W","W","p","W","W","p","W","W","W","W","W","p","W","W","W","W","p","W"},
                            {"W","p","W","W","W","W","p","W","W","W","W","W","p","W","W","p","W","W","W","W","W","p","W","W","W","W","O","W"},
                            {"W","p","W","W","W","W","p","p","p","p","p","p","p","p","p","p","p","p","p","p","p","p","W","W","W","W","p","W"},
                            {"W","p","p","p","p","p","p","W","W","p","W","W","W","W","W","W","W","W","p","W","W","C","p","p","p","p","p","W"},
                            {"W","p","W","W","W","W","p","W","W","p","W","W","W","W","W","W","W","W","p","W","W","p","W","W","W","W","p","W"},
                            {"W","p","W","W","W","W","p","W","W","p","p","p","p","W","W","p","p","p","p","W","W","p","W","W","W","W","p","W"},
                            {"W","p","p","p","p","p","p","W","W","W","W","W","p","W","W","p","W","W","W","W","W","p","p","p","p","p","p","W"},
                            {"W","W","W","W","W","W","p","W","W","W","W","W","p","W","W","p","W","W","W","W","W","p","W","W","W","W","W","W"},
                            {"W","W","W","W","W","W","p","W","W","p","p","p","p","W","W","p","p","p","p","W","W","p","W","W","W","W","W","W"},
                            {"W","W","W","W","W","W","p","W","W","p","p","p","p","p","p","p","p","p","p","W","W","p","W","W","W","W","W","W"},
                            {"W","W","W","W","W","W","p","W","W","p","p","p","p","p","p","p","p","p","p","W","W","p","W","W","W","W","W","W"},
                            {"W","W","W","W","W","W","p","W","W","p","p","p","F","F","F","F","p","p","p","W","W","p","W","W","W","W","W","W"},
                            {"p","p","p","p","p","p","p","p","p","p","p","p","p","p","p","p","p","p","p","p","p","p","p","p","p","p","p","p"},
                            {"W","W","W","W","W","W","p","W","W","p","p","p","p","p","p","p","p","p","p","W","W","p","W","W","W","W","W","W"},
                            {"W","W","W","W","W","W","p","W","W","p","W","W","W","W","W","W","W","W","p","W","W","p","W","W","W","W","W","W"},
                            {"W","W","W","W","W","W","p","W","W","p","W","W","W","W","W","W","W","W","p","W","W","p","W","W","W","W","W","W"},
                            {"W","W","W","W","W","W","p","W","W","p","W","W","W","W","W","W","W","W","p","W","W","p","W","W","W","W","W","W"},
                            {"W","p","p","p","p","p","p","p","p","p","p","p","p","W","W","p","p","p","p","p","p","p","p","p","p","p","O","W"},
                            {"W","p","W","W","W","W","p","W","W","W","W","W","p","W","W","p","W","W","W","W","W","p","W","W","W","W","p","W"},
                            {"W","p","W","W","W","W","p","p","p","p","p","p","p","P","p","p","p","p","p","p","p","p","W","W","W","W","p","W"},
                            {"W","p","p","p","W","W","p","W","W","p","W","W","W","W","W","W","W","W","p","W","W","p","W","W","p","p","p","W"},
                            {"W","W","W","p","W","W","p","W","W","p","W","W","W","W","W","W","W","W","p","W","W","p","W","W","p","W","W","W"},
                            {"W","W","W","p","W","W","p","W","W","p","W","W","W","W","W","W","W","W","p","W","W","p","W","W","p","W","W","W"},
                            {"W","p","p","p","p","p","p","W","W","p","p","p","p","W","W","p","p","p","p","W","W","p","p","p","p","p","p","W"},
                            {"W","p","W","W","W","W","W","W","W","W","W","W","p","W","W","p","W","W","W","W","W","W","W","W","W","W","p","W"},
                            {"W","O","p","p","p","p","p","p","p","p","p","p","p","W","W","p","p","p","p","p","p","p","p","p","p","p","p","W"},
                            {"W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W"}};



    public void criaJogo(IControle controle) {
        ILabirinto labirinto = new Labirinto();
        labirinto.montaLabirinto(tabuleiro.length, tabuleiro[0].length);

        IPacman pacman = new Pacman();
        IFantasma[] fantasmas = new Fantasma[4];

        int contador = 0;

        for (int i = 0; i < tabuleiro.length; i++){
            for (int j = 0; j < tabuleiro[0].length; j++){
                if (tabuleiro[i][j].equals("W")){
                    IAtorEstatico muro = new Muro();
                    muro.montaAtor(i, j, 'W');
                    labirinto.connect(muro, i, j);
                    continue;
                }
                else if (tabuleiro[i][j].equals("C")){
                    IAtorEstatico cereja = new Cereja();
                    cereja.montaAtor(i, j, 'C');
                    labirinto.connect(cereja, i, j);
                    continue;
                }
                else if (tabuleiro[i][j].equals("O")){
                    IAtorEstatico ouro = new Ouro();
                    ouro.montaAtor(i, j, 'O');
                    labirinto.connect(ouro, i, j);
                    continue;
                }
                else if (tabuleiro[i][j].equals("P")){
                    pacman.montaAtor(i, j, 'W');
                    labirinto.connect(pacman, i, j);
                    pacman.connect(labirinto);
                    continue;
                }
                else if (tabuleiro[i][j].equals("F")){
                    IFantasma fantasma = new Fantasma();
                    fantasma.montaAtor(i, j, 'W', contador);
                    labirinto.connect(fantasma, i, j, contador);
                    fantasma.connect(labirinto);
                    fantasmas[contador] = fantasma;
                    contador++;
                    continue;
                }
                else if (tabuleiro[i][j].equals("p")){
                    labirinto.atualizaPastilha(i, j, true);
                    continue;
                }
            }
        }
        controle.connect(labirinto);
        controle.connect(pacman);
        controle.connect(fantasmas);
    }
}
