package Labirinto;

import Ator.*;

public class Sala {
    private IAtorEstatico muro;
    private IAtorEstatico ouro;
    private IAtorEstatico cereja;
    private IPacman pacman;
    private IFantasma[] fantasmas;
    private boolean pastilha;

    public Sala(){
        this.muro = null;
        this.ouro = null;
        this.cereja = null;
        this.pacman = null;
        this.fantasmas = new Fantasma[4];
        this.pastilha = false;
    }

    public IAtorEstatico getMuro(){
        return this.muro;
    }

    public IAtorEstatico getOuro(){
        return this.ouro;
    }

    public IAtorEstatico getCereja(){
        return this.cereja;
    }

    public IPacman getPacman(){
        return this.pacman;
    }

    public IFantasma getFantasma(int idx){
        return this.fantasmas[idx];
    }

    public boolean getPastilha(){
        return this.pastilha;
    }

    public void setMuro(IAtorEstatico muro){
        this.muro = muro;
    }

    public void setOuro(IAtorEstatico ouro){
        this.ouro = ouro;
    }

    public void setCereja(IAtorEstatico cereja){
        this.cereja = cereja;
    }

    public void setPacman(IPacman pacman){
        this.pacman = pacman;
    }

    public void setFantasma(int idx, IFantasma fantasma) {
        this.fantasmas[idx] = fantasma;
    }

    public void setPastilha(boolean condicao){
        this.pastilha = condicao;
    }

}
