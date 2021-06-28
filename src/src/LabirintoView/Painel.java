package LabirintoView;

import javax.swing.*;

import Montador.*;

import java.awt.*;
import java.net.URISyntaxException;
import java.util.Objects;

public class Painel extends JFrame implements ILabirintoView {
    
	private static final long serialVersionUID = -8073756609683577951L;

	public String DIRETORIO;

    JLabel[][] matrizPainel;
    JLabel pontuacao;

    ImageIcon abelhaazul;
    ImageIcon abelhavermelha;
    ImageIcon abelharosa;
    ImageIcon abelhapreta;
    ImageIcon flor;
    ImageIcon mel;
    ImageIcon muro;
    ImageIcon raquete;
    ImageIcon urso;
    ImageIcon imgVerde;
    ImageIcon ursoBolado;

    public Painel(){
        super();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    
    // Inicializa o labirinto na interface gr�fica, gerando os paineis e os JLabel que ser�o modificados a cada movimenta��o;
    // Guarda na matriz matrizPainel uma matriz de JLabel para que o m�todo atualizarLabirinto possa acessar os locais corretos
    // na interface gr�fica e possa atualizar a visualiza��o. Tamb�m pega as imagens de �cones de cada um dos personagens do jogo.
    public void inicializarLabirinto(String[][] tabuleiro){
    	
        JPanel painelPrincipal = new JPanel();
        JPanel viewTabuleiro = new JPanel();
        JPanel viewPontos = new JPanel();

        getContentPane().add(painelPrincipal);
        painelPrincipal.setLayout(new BorderLayout());
        painelPrincipal.add(viewTabuleiro, BorderLayout.CENTER);

        viewTabuleiro.setLayout(new GridLayout(tabuleiro.length, tabuleiro[0].length));
        viewTabuleiro.setBackground(new java.awt.Color(219, 253, 156));

        viewPontos.setLayout(new FlowLayout());
        painelPrincipal.add(viewPontos, BorderLayout.PAGE_START);

        pontuacao = new JLabel();
        viewPontos.add(new JLabel("Pontua��o: "));
        viewPontos.add(pontuacao);
        pontuacao.setText("0");

        setSize(1024, 1024);
        matrizPainel = new JLabel[tabuleiro.length][tabuleiro[0].length];


        abelhaazul = new ImageIcon(Objects.requireNonNull(FimJogo.class.getResource("/LabirintoView/Imagens/abelhaazul.png")));
        abelhapreta = new ImageIcon(Objects.requireNonNull(FimJogo.class.getResource("/LabirintoView/Imagens/abelhapreta.png")));
        abelharosa = new ImageIcon(Objects.requireNonNull(FimJogo.class.getResource("/LabirintoView/Imagens/abelharosa.png")));
        abelhavermelha = new ImageIcon(Objects.requireNonNull(FimJogo.class.getResource("/LabirintoView/Imagens/abelhavermelha.png")));
        flor = new ImageIcon(Objects.requireNonNull(FimJogo.class.getResource("/LabirintoView/Imagens/flor.png")));
        mel = new ImageIcon(Objects.requireNonNull(FimJogo.class.getResource("/LabirintoView/Imagens/mel.png")));
        muro = new ImageIcon(Objects.requireNonNull(FimJogo.class.getResource("/LabirintoView/Imagens/grama.jpg")));
        raquete = new ImageIcon(Objects.requireNonNull(FimJogo.class.getResource("/LabirintoView/Imagens/rede.png")));
        urso = new ImageIcon(Objects.requireNonNull(FimJogo.class.getResource("/LabirintoView/Imagens/urso.png")));
        imgVerde = new ImageIcon(Objects.requireNonNull(FimJogo.class.getResource("/LabirintoView/Imagens/fundoverde.png")));
        ursoBolado = new ImageIcon(Objects.requireNonNull(FimJogo.class.getResource("/LabirintoView/Imagens/ursobolado.png")));

        for (int i = 0; i < tabuleiro.length; i++){
            for (int j = 0; j < tabuleiro[i].length; j++){
                switch (tabuleiro[i][j]) {
                    case "A" -> {
                        JLabel painel = new JLabel();
                        painel.setIcon(abelhaazul);
                        viewTabuleiro.add(painel);
                        matrizPainel[i][j] = painel;
                        break;
                    }
                    case "V" -> {
                        JLabel painel = new JLabel();
                        painel.setIcon(abelhavermelha);
                        viewTabuleiro.add(painel);
                        matrizPainel[i][j] = painel;
                        break;
                    }
                    case "L" -> {
                        JLabel painel = new JLabel();
                        painel.setIcon(abelhapreta);
                        viewTabuleiro.add(painel);
                        matrizPainel[i][j] = painel;
                        break;
                    }
                    case "R" -> {
                        JLabel painel = new JLabel();
                        painel.setIcon(abelharosa);
                        viewTabuleiro.add(painel);
                        matrizPainel[i][j] = painel;
                        break;
                    }
                    case "O" -> {
                        JLabel painel = new JLabel();
                        painel.setIcon(flor);
                        viewTabuleiro.add(painel);
                        matrizPainel[i][j] = painel;
                        break;
                    }
                    case "p" -> {
                        JLabel painel = new JLabel();
                        painel.setIcon(mel);
                        viewTabuleiro.add(painel);
                        matrizPainel[i][j] = painel;
                        break;
                    }
                    case "W" -> {
                        JLabel painel = new JLabel();
                        painel.setIcon(muro);
                        viewTabuleiro.add(painel);
                        matrizPainel[i][j] = painel;
                        break;
                    }
                    case "C" -> {
                        JLabel painel = new JLabel();
                        painel.setIcon(raquete);
                        viewTabuleiro.add(painel);
                        matrizPainel[i][j] = painel;
                        break;
                    }
                    case "P" -> {
                        JLabel painel = new JLabel();
                        painel.setIcon(urso);
                        viewTabuleiro.add(painel);
                        matrizPainel[i][j] = painel;
                        break;
                    }
                    case "-" -> {
                        JLabel painel = new JLabel();
                        painel.setIcon(imgVerde);
                        viewTabuleiro.add(painel);
                        matrizPainel[i][j] = painel;
                        break;
                    }
                }
            }
        }
        setVisible(true);
    }

    // Atualiza o labirinto a partir de uma matriz de strings, assim, esse m�todo verificar� o que h� em cada
    // posi��o da matriz de strings e atualizar� na interface gr�fica a situa��o atual do jogo.
    public void atualizarLabirinto(String[][] tabuleiro, int pontos){
        for (int i = 0; i < tabuleiro.length; i++){
            for (int j = 0; j < tabuleiro[i].length; j++){
                switch (tabuleiro[i][j]) {
                    case "V" -> matrizPainel[i][j].setIcon(abelhavermelha);
                    case "A" -> matrizPainel[i][j].setIcon(abelhaazul);
                    case "R" -> matrizPainel[i][j].setIcon(abelharosa);
                    case "L" -> matrizPainel[i][j].setIcon(abelhapreta);
                    case "O" -> matrizPainel[i][j].setIcon(flor);
                    case "p" -> matrizPainel[i][j].setIcon(mel);
                    case "W" -> matrizPainel[i][j].setIcon(muro);
                    case "C" -> matrizPainel[i][j].setIcon(raquete);
                    case "P" -> matrizPainel[i][j].setIcon(urso);
                    case "-" -> matrizPainel[i][j].setIcon(imgVerde);
                    case "B" -> matrizPainel[i][j].setIcon(ursoBolado);
                }
            }
        }
        pontuacao.setText(Integer.toString(pontos));
    }
}
