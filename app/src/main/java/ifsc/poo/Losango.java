package ifsc.poo;

import java.awt.Color;

import edu.princeton.cs.algs4.Draw;

public class Losango extends ObjetoDeDesenho{

    public Losango(){

        this.tamanho = Constantes.TAMANHO_DEFAULT_LOSANGO;

    }

    private void desenharSemPreenchimento(Draw tela, double[] x, double[] y){

        
        tela.setPenColor(Color.BLACK);
        tela.polygon(x, y);

    }

    private void desenharComPreenchimento(Draw tela, double[] x, double[] y, Color cor){

        tela.setPenColor(cor);
        tela.filledPolygon(x, y);

        // Para desenhar a borda em preto
        tela.setPenColor(Color.BLACK);
        desenharSemPreenchimento(tela, x, y);
    }

    private double[] coordenadasX(double cx){

        double[] x = new double[4];

        x[0] = cx + getTamanho() * Math.sin(Math.toRadians(26.565));
        x[1] = cx;
        x[2] = cx - getTamanho() * Math.sin(Math.toRadians(26.565));
        x[3] = cx;

        return x;

    }

    private double[] coordenadasY(double cy){

        double[] y = new double[4];

        y[0] = cy;
        y[1] = cy + getTamanho() * Math.sin(Math.toRadians(63.435));;
        y[2] = cy;
        y[3] = cy - getTamanho() * Math.sin(Math.toRadians(63.435));

        return y;

    }

    private double diagonal1(){

        return 2.0 * getTamanho() * Math.sin(Math.toRadians(26.565));

    }

    private double diagonal2(){
        
        return 2.0 * getTamanho() * Math.sin(Math.toRadians(63.435));

    }

    @Override
    public void desenhar(Draw tela){

        // A coord será o ponto central do Hexagono
        double[] x = coordenadasX(this.coordenada.getCX());
        double[] y = coordenadasY(this.coordenada.getCY());


        if(this.temPreenchimento)
            desenharComPreenchimento(tela, x, y, this.corDeLinha);
        else desenharSemPreenchimento(tela, x, y);

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
            tamanho += Constantes.VALOR_ALTERAR;

    }

    @Override
    public void diminuirTamanho(){
        
        if(this.tamanho > Constantes.TAMANHO_MINIMO)
            tamanho -= Constantes.VALOR_ALTERAR;

    }

    @Override
    public void definirCorLinha(Color cor){

        this.corDeLinha = cor;

    }

    @Override
    public double getArea(){

        // A = (D1 + D2) / 2
        return (diagonal1() * diagonal2()) / 2.0;

    }

    @Override
    public double getPerimetro(){

        return 6.0 * getTamanho();

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

        return this.corDeLinha;

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