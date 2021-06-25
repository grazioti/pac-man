package Controle;

import Montador.*;
import Labirinto.*;
import Ator.*;
import LabirintoView.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Controle implements IControle, ActionListener {
    private ILabirinto labirinto;
    private IFantasma[] fantasmas;
    private IPacman pacman;

    private String[][] labirintoString;

    private Painel janela;

    private boolean coletouOuro;

    private int tempo = 1000;
    private Timer temporizador;

    boolean terminou = false;

    public void executaJogo(String dificuldade){
        IMontador montador = new Montador();
        montador.criaJogo(this, dificuldade);

        labirintoString = labirinto.labirintoToString();

        janela = new Painel();
        janela.inicializarLabirinto(labirintoString);

        addKeyListener(janela);
        temporizador = new Timer(tempo, this);
        temporizador.start();
    }

    //adiciona um KeyListener no nosso JFrame, para escutar o teclado e fazer a movimentação do
    //pac-man em cima do clique de tal tecla.
    public void addKeyListener(Painel janela){
        janela.addKeyListener(new KeyListener() {
            public void keyTyped(KeyEvent e) { }
            public void keyReleased(KeyEvent e) { }

            public void keyPressed(KeyEvent e) {

                if(e.getKeyCode() == KeyEvent.VK_W || e.getKeyCode() == KeyEvent.VK_UP){
                    if (labirinto.ehMovimentoValido(pacman.getI() - 1, pacman.getJ())) {
                        pacman.moverAtor(-1, 0);
                        coletouOuro = pacman.verificarSala();
                        labirintoString = labirinto.labirintoToString();
                        janela.atualizarLabirinto(labirintoString, pacman.getScore());
                    }
                }

                else if (e.getKeyCode() == KeyEvent.VK_S || e.getKeyCode() == KeyEvent.VK_DOWN){
                    if (labirinto.ehMovimentoValido(pacman.getI() + 1, pacman.getJ())) {
                        pacman.moverAtor(1, 0);
                        coletouOuro = pacman.verificarSala();
                        labirintoString = labirinto.labirintoToString();
                        janela.atualizarLabirinto(labirintoString, pacman.getScore());
                    }
                }

                else if (e.getKeyCode() == KeyEvent.VK_A || e.getKeyCode() == KeyEvent.VK_LEFT){
                    if (labirinto.ehMovimentoValido(pacman.getI(), pacman.getJ() - 1)) {
                        pacman.moverAtor(0, -1);
                        coletouOuro = pacman.verificarSala();
                        labirintoString = labirinto.labirintoToString();
                        janela.atualizarLabirinto(labirintoString, pacman.getScore());
                    }
                }

                else if (e.getKeyCode() == KeyEvent.VK_D || e.getKeyCode() == KeyEvent.VK_RIGHT){
                    if (labirinto.ehMovimentoValido(pacman.getI(), pacman.getJ() + 1)) {
                        pacman.moverAtor(0, 1);
                        coletouOuro = pacman.verificarSala();
                        labirintoString = labirinto.labirintoToString();
                        janela.atualizarLabirinto(labirintoString, pacman.getScore());
                    }
                }

                verificacoesPosMov();
                coletouOuro = false;
            }
        });
    }

    public void verificacoesPosMov(){
        if (coletouOuro){
            tempo -= 200;
            temporizador.setDelay(tempo);
        }

        if (labirinto.getQtdPastilhas() == 0 && !terminou){
            terminou = true;
            temporizador.stop();
            janela.setVisible(false);
            new FimJogo(pacman.getScore(), true);
        }

        if (haColisao() && !pacman.estaBolado() && !terminou){
            terminou = true;
            temporizador.stop();
            janela.setVisible(false);
            new FimJogo(pacman.getScore(), false);
        }

        else if (haColisao() && pacman.estaBolado()){
            for (int k = 0; k < 4; k++){
                int iFantasma = -1;
                int jFantasma = -1;
                if (fantasmas[k] != null){
                    iFantasma = fantasmas[k].getI();
                    jFantasma = fantasmas[k].getJ();
                }
                if((iFantasma == pacman.getI()) && (jFantasma == pacman.getJ())){
                    fantasmas[k] = null;
                    labirinto.removerFantasma(iFantasma, jFantasma, k);
                }
            }
        }
    }

    //verifica se houve colisão entre o pacman e o fantasma na sala ij.
    public boolean haColisao(){
        boolean retorno = false;
        for (int k = 0; k < 4; k++){
            int iFantasma = -1;
            int jFantasma = -1;
            if (fantasmas[k] != null){
                iFantasma = fantasmas[k].getI();
                jFantasma = fantasmas[k].getJ();
            }
            if((iFantasma == pacman.getI()) && (jFantasma == pacman.getJ())){
                retorno = true;
                break;
            }
        }
        return retorno;
    }

    public void actionPerformed(ActionEvent e) {
        for (IFantasma fant: fantasmas){
            if (fant != null){
                fant.moverAtor(pacman.getI(), pacman.getJ());
                verificacoesPosMov();
                labirintoString = labirinto.labirintoToString();
                janela.atualizarLabirinto(labirintoString, pacman.getScore());
            }
        }
    }

    public void connect(ILabirinto labirinto){
        this.labirinto = labirinto;
    }
    public void connect(IPacman pacman){
        this.pacman = pacman;
    }
    public void connect(IFantasma[] fantasmas){
        this.fantasmas = fantasmas;
    }

}
