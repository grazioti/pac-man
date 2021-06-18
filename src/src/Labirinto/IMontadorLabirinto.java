package Labirinto;

import Ator.*;

public interface IMontadorLabirinto {
    public void montaLabirinto(int linhas, int colunas);
    public void connect(IAtorEstatico ator, int i, int j);
    public void connect(IPacman ator, int i, int j);
    public void connect(IFantasma ator, int i ,int j, int idx);
}
