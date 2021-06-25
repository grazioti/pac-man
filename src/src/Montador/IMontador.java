package Montador;

import Controle.*;
import Ator.*;
import Labirinto.*;

import java.io.IOException;

public interface IMontador {
    public void criaJogo(IControle controle, String dificuldade);
    public void readCSV() throws IOException;
    public void montarTabuleiro();
}
