package Ator;

import java.awt.event.ActionListener;

public interface IFantasma extends IAtorPropriedades, IMontadorFantasma, IConnectLabirinto{
    public void moverAtor(int pacI, int pacJ);
    public void gerarMovimento(int pacI, int pacJ);
}
