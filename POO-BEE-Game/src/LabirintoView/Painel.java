package LabirintoView;

import javax.swing.*;
import java.awt.*;

public class Painel extends JFrame implements ILabirintoView {
    
	private static final long serialVersionUID = -8073756609683577951L;

	//public String DIRETORIO = Painel.class.getResource(".").getPath();

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
        viewPontos.add(new JLabel("Pontuação: "));
        viewPontos.add(pontuacao);
        pontuacao.setText("0");

        setSize(1024, 1024);
        matrizPainel = new JLabel[tabuleiro.length][tabuleiro[0].length];


        abelhaazul = new ImageIcon("/C:/Users/Cícero/Desktop/Github/poo-bee-game/POO-BEE-Game/bin/LabirintoView/" + "Imagens/"+ "abelhaazul.png");
        abelhapreta = new ImageIcon("/C:/Users/Cícero/Desktop/Github/poo-bee-game/POO-BEE-Game/bin/LabirintoView/" + "Imagens/"+ "abelhapreta.png");
        abelharosa = new ImageIcon("/C:/Users/Cícero/Desktop/Github/poo-bee-game/POO-BEE-Game/bin/LabirintoView/" + "Imagens/"+ "abelharosa.png");
        abelhavermelha = new ImageIcon("/C:/Users/Cícero/Desktop/Github/poo-bee-game/POO-BEE-Game/bin/LabirintoView/" + "Imagens/"+ "abelhavermelha.png");
        flor = new ImageIcon("/C:/Users/Cícero/Desktop/Github/poo-bee-game/POO-BEE-Game/bin/LabirintoView/" + "Imagens/"+ "flor.png");
        mel = new ImageIcon("/C:/Users/Cícero/Desktop/Github/poo-bee-game/POO-BEE-Game/bin/LabirintoView/" + "Imagens/"+ "mel.png");
        muro = new ImageIcon("/C:/Users/Cícero/Desktop/Github/poo-bee-game/POO-BEE-Game/bin/LabirintoView/" + "Imagens/"+ "grama.jpg");
        raquete = new ImageIcon("/C:/Users/Cícero/Desktop/Github/poo-bee-game/POO-BEE-Game/bin/LabirintoView/" + "Imagens/"+ "rede.png");
        urso = new ImageIcon("/C:/Users/Cícero/Desktop/Github/poo-bee-game/POO-BEE-Game/bin/LabirintoView/" + "Imagens/"+ "urso.png");
        imgVerde = new ImageIcon("/C:/Users/Cícero/Desktop/Github/poo-bee-game/POO-BEE-Game/bin/LabirintoView/" + "Imagens/"+ "fundoverde.png");
        ursoBolado = new ImageIcon("/C:/Users/Cícero/Desktop/Github/poo-bee-game/POO-BEE-Game/bin/LabirintoView/" + "Imagens/"+ "ursobolado.png");

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
