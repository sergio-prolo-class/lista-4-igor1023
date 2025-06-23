// Classe abstrata
// SE necessario

package ifsc.poo;
import java.awt.Color;

import edu.princeton.cs.algs4.Draw;

public abstract class ObjetoDeDesenho{

    static final double TAMANHO_MINIMO, TAMANHO_MAXIMO;
    static final double ALTERAR;

    static{
        
        TAMANHO_MINIMO = 0.5;
        TAMANHO_MAXIMO = 5.5;
        ALTERAR = 0.25;

    }

    protected Color corDeLinha;
    protected double tamanho, area;
    protected boolean temPreenchimento;

    abstract void desenhar(Draw tela, Coordenada coord, Color cor);
    abstract void aumentarTamanho();
    abstract void diminuirTamanho();
    abstract void definirCorLinha(Color cor);
    abstract double getTamanho();
    abstract double getArea();
    abstract void setPreenchimento(boolean p);

}