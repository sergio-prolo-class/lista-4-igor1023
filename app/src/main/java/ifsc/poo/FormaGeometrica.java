// Classe abstrata

package ifsc.poo;
import java.awt.Color;

public abstract class FormaGeometrica
    implements Desenhador, Movedor{

    protected Color cor;
    protected double tamanho, area;
    protected boolean temPreenchimento;
    protected Coordenada coordenada;

    abstract void aumentarTamanho();
    abstract void diminuirTamanho();
    abstract void definirCorLinha(Color cor);
    abstract double getTamanho();
    abstract void setTamanho(double i);
    abstract double getArea();
    abstract double getPerimetro();
    abstract void setPreenchimento(boolean p);
    abstract void setCoordenada(double x, double y);
    abstract Coordenada getCoordenada();
    abstract Color getCor();
    // abstract void moverCima(double a);
    // abstract void moverBaixo(double a);
    // abstract void moverEsquerda(double a);
    // abstract void moverDireita(double a);

}