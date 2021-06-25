package Ator;

public interface IPacman extends IAtorPropriedades, IMontadorPacman, IConnectLabirinto{
    public void moverAtor(int shiftI, int shiftJ);
    public int getScore();
    public boolean verificarSala();
    public boolean estaBolado();
}
