package Main;

import Controle.*;

public class AppPacman {
    public static void main(String[] args){
        IControle controle = new Controle();
        controle.executaJogo();
    }
}
