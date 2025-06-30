// Classe abstrata

package ifsc.poo.figuras;
import java.awt.Color;

import edu.princeton.cs.algs4.Draw;
import ifsc.poo.Constantes;
import ifsc.poo.Coordenada;
import ifsc.poo.interfaces.Desenhador;
import ifsc.poo.interfaces.Movedor;

public abstract class FormaGeometrica
    implements Desenhador, Movedor{

    protected Color cor;
    protected double tamanho, area;
    protected boolean temPreenchimento;
    protected Coordenada coordenada; // ponto central da figura

    public abstract double getArea();
    public abstract double getPerimetro();
    public abstract void desenhar(Draw tela);

    // Métodos em comum das subclasses

    public double getTamanho(){

        return this.tamanho;

    }

    public void setTamanho(double i){

        this.tamanho = i;

    }

    public void aumentarTamanho(){

        if(this.tamanho < Constantes.TAMANHO_MAXIMO)
            this.tamanho += Constantes.VALOR_ALTERAR;

    }

    public void diminuirTamanho(){
        
        if(this.tamanho > Constantes.TAMANHO_MINIMO)
            this.tamanho -= Constantes.VALOR_ALTERAR;
        
    }

    public void definirCorLinha(Color cor){

        this.cor = cor;

    }

    public Color getCor(){

        return this.cor;

    }

    public Coordenada getCoordenada(){

        return this.coordenada;

    }

    public void setPreenchimento(boolean p){

        this.temPreenchimento = p;

    }

    public void setCoordenada(double x, double y){

        this.coordenada = new Coordenada(x, y);

    }


    // Métodos da Interface Movedor (em comum das subclasses)
    @Override
    public void moverCima(double a){

        // Modifico a componente Y
        this.coordenada.setCY(this.coordenada.getCY() + a);
        setCoordenada(this.coordenada.getCX(), this.coordenada.getCY());

    }

    @Override
    public void moverBaixo(double a){

        // Modifico a componente Y
        this.coordenada.setCY(this.coordenada.getCY() - a);
        setCoordenada(this.coordenada.getCX(), this.coordenada.getCY());

    }

    @Override
    public void moverEsquerda(double a){

        // Modifico a componente X
        this.coordenada.setCX(this.coordenada.getCX() - a);
        setCoordenada(this.coordenada.getCX(), this.coordenada.getCY());

    }

    @Override
    public void moverDireita(double a){

        // Modifico a componente X
        this.coordenada.setCX(this.coordenada.getCX() + a);
        setCoordenada(this.coordenada.getCX(), this.coordenada.getCY());

    }

}