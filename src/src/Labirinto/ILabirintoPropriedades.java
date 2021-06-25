package Labirinto;

public interface ILabirintoPropriedades {
    public void atualizaPastilha(int i, int j, boolean condicao);
    public boolean haPastilha(int i, int j);
    public boolean haCereja(int i, int j);
    public boolean haOuro(int i, int j);
    public boolean haMuro(int i, int j);
    public String[][] labirintoToString();
    public int getQtdPastilhas();
    public void setQtdPastilhas(int qtd_pastilhas);
    public void removerPastilha(int i, int j);
}
