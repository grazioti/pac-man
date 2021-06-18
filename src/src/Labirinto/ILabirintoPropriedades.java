package Labirinto;

public interface ILabirintoPropriedades {
    public void atualizaPastilha(int i, int j, boolean condicao);
    public boolean haPastilha(int i, int j);
    public String[][] labirintoToString();
}
