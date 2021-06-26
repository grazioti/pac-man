package Montador;

import Controle.*;
import Labirinto.*;
import Ator.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.util.Objects;

public class Montador implements IMontador{
    private String[][] commands;

    private InputStream DIRETORIO;

    String[][] tabuleiro;
    String dificuldade;

    public void criaJogo(IControle controle, String dificuldade) {
        this.dificuldade = dificuldade;
        
        DIRETORIO = Montador.class.getResourceAsStream("Fases/dificuldade" + dificuldade + ".csv");
        
        try{
            readCSV();
            montarTabuleiro();
        }catch(IOException e){
            System.err.println("Arquivo não encontrado");
            e.printStackTrace();
            System.exit(1);
        }

        ILabirinto labirinto = new Labirinto();
        labirinto.montaLabirinto(tabuleiro.length, tabuleiro[0].length);

        IPacman pacman = new Pacman();
        IFantasma[] fantasmas = new Fantasma[4];
        int qtdPastilhas = 0;

        int contador = 0;

        for (int i = 0; i < tabuleiro.length; i++){
            for (int j = 0; j < tabuleiro[0].length; j++){
                switch (tabuleiro[i][j]) {
                    case "W" -> {
                        IAtorEstatico muro = new Muro();
                        muro.montaAtor(i, j, 'W');
                        labirinto.connect(muro, i, j);
                    }
                    case "C" -> {
                        IAtorEstatico cereja = new Cereja();
                        cereja.montaAtor(i, j, 'C');
                        labirinto.connect(cereja, i, j);
                    }
                    case "O" -> {
                        IAtorEstatico ouro = new Ouro();
                        ouro.montaAtor(i, j, 'O');
                        labirinto.connect(ouro, i, j);
                    }
                    case "P" -> {
                        pacman.montaAtor(i, j, 'P');
                        labirinto.connect(pacman, i, j);
                        pacman.connect(labirinto);
                    }
                    case "F" -> {
                        IFantasma fantasma = new Fantasma();
                        fantasma.montaAtor(i, j, 'F', contador);
                        labirinto.connect(fantasma, i, j, contador);
                        fantasma.connect(labirinto);
                        fantasmas[contador] = fantasma;
                        contador++;
                    }
                    case "p" -> {
                        labirinto.atualizaPastilha(i, j, true);
                        qtdPastilhas++;
                    }
                }
            }
        }
        labirinto.setQtdPastilhas(qtdPastilhas);

        controle.connect(labirinto);
        controle.connect(pacman);
        controle.connect(fantasmas);
    }

    public void readCSV() throws IOException{

        BufferedReader file = new BufferedReader(new InputStreamReader(DIRETORIO));
        int qtdLinhas = 29 * 28;

        String line = file.readLine();
        int i = 0;
        commands = new String[qtdLinhas][];
        while (line != null) {
            commands[i] = line.split(",");
            line = file.readLine();
            i++;
        }
        file.close();
    }

    public void montarTabuleiro(){
        tabuleiro = new String[29][28];
        int linha;
        int coluna;
        String carac;
        for (int i = 0; i < commands.length; i++){
            linha = Integer.parseInt(commands[i][0].substring(0, 2));
            coluna = Integer.parseInt(commands[i][0].substring(3));
            carac = commands[i][1];
            tabuleiro[linha - 1][coluna -1] = carac;
        }
    }
}
