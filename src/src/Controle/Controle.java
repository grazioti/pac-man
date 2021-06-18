package Controle;

import Montador.*;
import Labirinto.*;
import Ator.*;

public class Controle implements IControle{
    private ILabirinto labirinto;
    private IFantasma[] fantasmas;
    private IPacman pacman;
    private String[][] labirintoString;

    public void executaJogo(){
        IMontador montador = new Montador();
        montador.criaJogo(this);

        labirintoString = labirinto.labirintoToString();

        for (int i = 0; i < labirintoString.length; i++){
            for (int j = 0; j < labirintoString[0].length; j++){
                System.out.print(labirintoString[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public void connect(ILabirinto labirinto){
        this.labirinto = labirinto;
    }
    public void connect(IPacman pacman){
        this.pacman = pacman;
    }
    public void connect(IFantasma[] fantasmas){
        this.fantasmas = fantasmas;
    }
}
