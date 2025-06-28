package ifsc.poo;

import java.awt.Color;

import edu.princeton.cs.algs4.Draw;

public class Hexagono extends FormaGeometrica {

    public Hexagono(){

        this.tamanho = Constantes.TAMANHO_DEFAULT_CIRCULO;

    }

    private double[] coordenadasX(double cx){

        double[] x = new double[6];

        x[0] = cx + getTamanho();
        x[1] = cx + getTamanho() * Math.cos(Math.toRadians(60));
        x[2] = cx - getTamanho() * Math.cos(Math.toRadians(60));
        x[3] = cx - getTamanho();
        x[4] = cx - getTamanho() * Math.cos(Math.toRadians(60));
        x[5] = cx + getTamanho() * Math.cos(Math.toRadians(60));

        return x;

    }

    private double[] coordenadasY(double cy){

        double[] y = new double[6];

        y[0] = cy;
        y[1] = cy + getTamanho() * Math.cos(Math.toRadians(30));
        y[2] = cy + getTamanho() * Math.cos(Math.toRadians(30));
        y[3] = cy;
        y[4] = cy - getTamanho() * Math.cos(Math.toRadians(30));
        y[5] = cy - getTamanho() * Math.cos(Math.toRadians(30));

        return y;

    }

    private void desenharSemPreenchimento(Draw tela, double[] x, double[] y, Color cor){

        tela.setPenColor(cor);
        tela.polygon(x, y);

    }

    private void desenharComPreenchimento(Draw tela, double[] x, double[] y, Color cor){

        tela.setPenColor(cor);
        tela.filledPolygon(x, y);

        // Para desenhar a borda em preto
        desenharSemPreenchimento(tela, x, y, Color.BLACK);
    }

    // Método da Interface Desenhador
    @Override
    public void desenhar(Draw tela){

        // A coord será o ponto central do Hexagono
        double[] x = coordenadasX(this.coordenada.getCX());
        double[] y = coordenadasY(this.coordenada.getCY());

        if(this.temPreenchimento)
            desenharComPreenchimento(tela, x, y, getCor());
        else desenharSemPreenchimento(tela, x, y, getCor());

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

        this.cor = cor;

    }

    @Override
    public double getArea(){

        // A = (3√3 * lado²) / 2
        return (3.0 * Math.sqrt(3.0) * Math.pow(getTamanho(), 2.0)) / 2.0;

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

        return this.cor;

    }

    // Métodos da Interface Movedor
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