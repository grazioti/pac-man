package Ator;

import Labirinto.ILabirinto;

public interface IMontadorFantasma {
    public void montaAtor(int i, int j, char caractere, int idx);
    public void connect(ILabirinto labirinto);
}
