package ifsc.poo;
import java.awt.Color;

import edu.princeton.cs.algs4.Draw;

public class Circulo extends ObjetoDeDesenho{

    public Circulo(){

        this.tamanho = Constantes.TAMANHO_DEFAULT_CIRCULO;

    }

    private void desenharSemPreenchimento(Draw tela, Coordenada coord, Color cor){

        tela.setPenColor(cor);
        tela.circle(coord.getCX(), coord.getCY(), getTamanho());

    }

    private void desenharComPreenchimento(Draw tela, Coordenada coord, Color cor){

        tela.setPenColor(cor);
        tela.filledCircle(coord.getCX(), coord.getCY(), getTamanho());

        // Para desenhar a borda em preto
        desenharSemPreenchimento(tela, coord, Color.BLACK);
    }

    @Override
    public void desenhar(Draw tela){

        if(this.temPreenchimento)
            desenharComPreenchimento(tela, this.coordenada, this.cor);
        else desenharSemPreenchimento(tela, this.coordenada, this.cor);

        tela.show();

    }

    @Override
    public double getTamanho(){

        return this.tamanho;

    }

    @Override
    public void setTamanho(double i){

        this.tamanho = i;

    }

    @Override
    public void aumentarTamanho(){

        if(this.tamanho < Constantes.TAMANHO_MAXIMO)
            this.tamanho += Constantes.VALOR_ALTERAR;

    }

    @Override
    public void diminuirTamanho(){
        
        if(this.tamanho > Constantes.TAMANHO_MINIMO)
            this.tamanho -= Constantes.VALOR_ALTERAR;
        
    }

    @Override
    public void definirCorLinha(Color cor){

        this.cor = cor;

    }

    @Override
    public double getArea(){

        // Pierri²
        return Math.PI * Math.pow(getTamanho(), 2.0);

    }

    @Override
    public double getPerimetro(){

        // 2 Pierri
        return 2.0 * Math.PI * getTamanho();

    }

    @Override
    public void setPreenchimento(boolean p){

        this.temPreenchimento = p;

    }

    @Override
    public void setCoordenada(double x, double y){

        this.coordenada = new Coordenada(x, y);

    }

    @Override
    public Coordenada getCoordenada(){

        return this.coordenada;

    }

    @Override
    public Color getCor(){

        return this.cor;

    }

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