package LabirintoView;

import javax.swing.*;
import java.awt.*;

public class Painel extends JFrame {
    public static String DIRETORIO =
            Painel.class.getResource(".").getPath();

    public Painel(){
        super();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void interfaceVisual(){
        String[][] tabuleiro = {{"W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W"},
                {"W","p","p","p","p","p","p","p","p","p","p","p","p","W","W","p","p","p","p","p","p","p","p","p","p","p","p","W"},
                {"W","O","W","W","W","W","p","W","W","W","W","W","p","W","W","p","W","W","W","W","W","p","W","W","W","W","p","W"},
                {"W","p","W","W","W","W","p","W","W","W","W","W","p","W","W","p","W","W","W","W","W","p","W","W","W","W","O","W"},
                {"W","p","W","W","W","W","p","p","p","p","p","p","p","p","p","p","p","p","p","p","p","p","W","W","W","W","p","W"},
                {"W","p","p","p","p","p","p","W","W","p","W","W","W","W","W","W","W","W","p","W","W","C","p","p","p","p","p","W"},
                {"W","p","W","W","W","W","p","W","W","p","W","W","W","W","W","W","W","W","p","W","W","p","W","W","W","W","p","W"},
                {"W","p","W","W","W","W","p","W","W","p","p","p","p","W","W","p","p","p","p","W","W","p","W","W","W","W","p","W"},
                {"W","p","p","p","p","p","p","W","W","W","W","W","p","W","W","p","W","W","W","W","W","p","p","p","p","p","p","W"},
                {"W","W","W","W","W","W","p","W","W","W","W","W","p","W","W","p","W","W","W","W","W","p","W","W","W","W","W","W"},
                {"W","W","W","W","W","W","p","W","W","p","p","p","p","W","W","p","p","p","p","W","W","p","W","W","W","W","W","W"},
                {"W","W","W","W","W","W","p","W","W","p","p","p","p","p","p","p","p","p","p","W","W","p","W","W","W","W","W","W"},
                {"W","W","W","W","W","W","p","W","W","p","p","p","p","p","p","p","p","p","p","W","W","p","W","W","W","W","W","W"},
                {"W","W","W","W","W","W","p","W","W","p","p","p","F","F","F","F","p","p","p","W","W","p","W","W","W","W","W","W"},
                {"p","p","p","p","p","p","p","p","p","p","p","p","p","p","p","p","p","p","p","p","p","p","p","p","p","p","p","p"},
                {"W","W","W","W","W","W","p","W","W","p","p","p","p","p","p","p","p","p","p","W","W","p","W","W","W","W","W","W"},
                {"W","W","W","W","W","W","p","W","W","p","W","W","W","W","W","W","W","W","p","W","W","p","W","W","W","W","W","W"},
                {"W","W","W","W","W","W","p","W","W","p","W","W","W","W","W","W","W","W","p","W","W","p","W","W","W","W","W","W"},
                {"W","W","W","W","W","W","p","W","W","p","W","W","W","W","W","W","W","W","p","W","W","p","W","W","W","W","W","W"},
                {"W","p","p","p","p","p","p","p","p","p","p","p","p","W","W","p","p","p","p","p","p","p","p","p","p","p","O","W"},
                {"W","p","W","W","W","W","p","W","W","W","W","W","p","W","W","p","W","W","W","W","W","p","W","W","W","W","p","W"},
                {"W","p","W","W","W","W","p","p","p","p","p","p","p","P","p","p","p","p","p","p","p","p","W","W","W","W","p","W"},
                {"W","p","p","p","W","W","p","W","W","p","W","W","W","W","W","W","W","W","p","W","W","p","W","W","p","p","p","W"},
                {"W","W","W","p","W","W","p","W","W","p","W","W","W","W","W","W","W","W","p","W","W","p","W","W","p","W","W","W"},
                {"W","W","W","p","W","W","p","W","W","p","W","W","W","W","W","W","W","W","p","W","W","p","W","W","p","W","W","W"},
                {"W","p","p","p","p","p","p","W","W","p","p","p","p","W","W","p","p","p","p","W","W","p","p","p","p","p","p","W"},
                {"W","p","W","W","W","W","W","W","W","W","W","W","p","W","W","p","W","W","W","W","W","W","W","W","W","W","p","W"},
                {"W","O","p","p","p","p","p","p","p","p","p","p","p","W","W","p","p","p","p","p","p","p","p","p","p","p","p","W"},
                {"W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W"}};


        JFrame janela = new Painel();
        janela.setLayout(new BorderLayout());
        janela.setLayout(new GridLayout(tabuleiro.length, tabuleiro[0].length));
        janela.setSize(1024, 1024);
        janela.getContentPane().setBackground(Color.white);


        ImageIcon abelha = new ImageIcon("/C:/Users/Cícero/Desktop/Unicamp/3º semestre/projetofinalPOO/out/production/Testando/"+ "abelhaazul.png");
        ImageIcon flor = new ImageIcon("/C:/Users/Cícero/Desktop/Unicamp/3º semestre/projetofinalPOO/out/production/Testando/"+ "flor.png");
        ImageIcon mel = new ImageIcon("/C:/Users/Cícero/Desktop/Unicamp/3º semestre/projetofinalPOO/out/production/Testando/"+ "mel.png");
        ImageIcon muro = new ImageIcon("/C:/Users/Cícero/Desktop/Unicamp/3º semestre/projetofinalPOO/out/production/Testando/"+ "grama.jpg");
        ImageIcon raquete = new ImageIcon("/C:/Users/Cícero/Desktop/Unicamp/3º semestre/projetofinalPOO/out/production/Testando/"+ "rede6.jpg");
        ImageIcon urso = new ImageIcon("/C:/Users/Cícero/Desktop/Unicamp/3º semestre/projetofinalPOO/out/production/Testando/"+ "urso.png");

        for (int i = 0; i < tabuleiro.length; i++){
            for (int j = 0; j < tabuleiro[i].length; j++){
                if(tabuleiro[i][j].equals("F")){
                    JLabel painel = new JLabel();
                    painel.setIcon(abelha);
                    janela.add(painel);
                }
                else if(tabuleiro[i][j].equals("O")){
                    JLabel painel = new JLabel();
                    painel.setIcon(flor);
                    janela.add(painel);
                }
                else if(tabuleiro[i][j].equals("p")){
                    JLabel painel = new JLabel();
                    painel.setIcon(mel);
                    janela.add(painel);
                }
                else if(tabuleiro[i][j].equals("W")){
                    JLabel painel = new JLabel();
                    painel.setIcon(muro);
                    janela.add(painel);
                }
                else if(tabuleiro[i][j].equals("C")){
                    JLabel painel = new JLabel();
                    painel.setIcon(raquete);
                    janela.add(painel);
                }
                else if(tabuleiro[i][j].equals("P")){
                    JLabel painel = new JLabel();
                    painel.setIcon(urso);
                    janela.add(painel);
                }
            }
        }

        janela.setVisible(true);
    }
}
