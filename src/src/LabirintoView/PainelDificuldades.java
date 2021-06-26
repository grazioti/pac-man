package LabirintoView;

import Controle.*;
import Montador.Montador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PainelDificuldades extends JFrame {
	private static final long serialVersionUID = 3753156031840387598L;
	IControle controle;

    public PainelDificuldades(){
        super();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(300, 500);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
    }

    // Gera um painel inicial com três botões, que fará com que passe para o objeto Controle tal dificuldade, para que o
    // jogo seja construido com a dificuldade desejada.
    public void gerarJogo(){
    	
        controle = new Controle();

        JPanel painelFundo = new JPanel();
        painelFundo.setLayout(new GridLayout(5,1));
        getContentPane().add(painelFundo);


        JLabel nomeJogo = new JLabel("POO-BEE Game");
        nomeJogo.setHorizontalAlignment(JLabel.CENTER);
        nomeJogo.setFont(new Font("Cambria Math", Font.BOLD, 40));

        Font fonteBotoes = new Font("Cambria Math", Font.BOLD, 20);

        JButton facil = new JButton("Fácil");
        facil.setFont(fonteBotoes);
        JButton medio = new JButton("Médio");
        medio.setFont(fonteBotoes);
        JButton dificil = new JButton("Difícil");
        dificil.setFont(fonteBotoes);

        JLabel strDificuldades = new JLabel("Selecione uma dificuldade:");
        strDificuldades.setFont(new Font("Cambria Math", Font.BOLD, 20));
        strDificuldades.setHorizontalAlignment(JLabel.CENTER);

        painelFundo.add(nomeJogo);
        painelFundo.add(strDificuldades);
        painelFundo.add(facil);
        painelFundo.add(medio);
        painelFundo.add(dificil);

        facil.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event){
                controle.executaJogo("facil");
                dispose();
            }
        });

        medio.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controle.executaJogo("media");
                dispose();
            }
        });

        dificil.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controle.executaJogo("dificil");
                dispose();
            }
        });

        setVisible(true);
    }
}
