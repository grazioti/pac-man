package LabirintoView;

import javax.swing.*;
import java.awt.*;

public class FimJogo extends JFrame {
    int score;
    boolean ganhou;
    public String DIRETORIO = FimJogo.class.getResource(".").getPath();

    ImageIcon ursoGanhou = new ImageIcon(DIRETORIO + "Imagens/"+ "ursoganhou.png");
    ImageIcon ursoPerdeu = new ImageIcon(DIRETORIO + "Imagens/"+ "ursoperdeu.png");

    public FimJogo(int score, boolean ganhou){
        super();
        this.score = score;
        this.ganhou = ganhou;
        getContentPane().setLayout(new BorderLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setAlwaysOnTop(false);
        setVisible(true);
        terminarJogo();
    }

    public void terminarJogo(){
        JPanel painel = new JPanel();
        JPanel painelTexto = new JPanel();
        JLabel fundo = new JLabel();

        painel.add(fundo);

        if (ganhou){
            fundo.setIcon(ursoGanhou);
            this.setSize(640,1024);
            painelTexto.add(new JLabel("Você ganhou. Sua pontuação final foi: " + score));
        }
        else{
            fundo.setIcon(ursoPerdeu);
            this.setSize(612,1024);
            painelTexto.add(new JLabel("Você perdeu. Sua pontuação final foi: " + score));
        }

        getContentPane().add(painel, BorderLayout.CENTER);
        getContentPane().add(painelTexto, BorderLayout.PAGE_START);
    }
}
