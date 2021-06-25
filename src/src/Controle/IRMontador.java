package Controle;

import Labirinto.*;
import Ator.*;

public interface IRMontador {
    public void connect(ILabirinto labirinto);
    public void connect(IPacman pacman);
    public void connect(IFantasma[] fantasmas);
}
