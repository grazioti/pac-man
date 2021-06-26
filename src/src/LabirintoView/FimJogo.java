package LabirintoView;

import javax.swing.*;
import java.awt.*;
import java.net.URISyntaxException;
import java.util.Objects;

public class FimJogo extends JFrame {
	private static final long serialVersionUID = 4615875135091864599L;
	int score;
    boolean ganhou;
    String DIRETORIO;

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

        ImageIcon ursoGanhou = new ImageIcon(Objects.requireNonNull(FimJogo.class.getResource("/LabirintoView/Imagens/ursoganhou.png")));
        ImageIcon ursoPerdeu = new ImageIcon(Objects.requireNonNull(FimJogo.class.getResource("/LabirintoView/Imagens/ursoperdeu.png")));
        
        
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
