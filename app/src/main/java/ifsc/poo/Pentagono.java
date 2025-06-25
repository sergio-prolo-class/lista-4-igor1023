package ifsc.poo;

import java.awt.Color;

import edu.princeton.cs.algs4.Draw;

public class Pentagono extends ObjetoDeDesenho{

    static double areaSoma;

    static{

        areaSoma = 0.0;

    }

    public Pentagono(){

        this.tamanho = Constantes.TAMANHO_DEFAULT_PENTAGONO;

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

    private double[] coordenadasX(double cx, double g){

        double[] x = new double[5];

        x[0] = cx + g * Math.cos(Math.toRadians(36));
        x[1] = cx;
        x[2] = cx - g * Math.cos(Math.toRadians(36));
        x[3] = cx - g * Math.sin(Math.toRadians(36));
        x[4] = cx + g * Math.sin(Math.toRadians(36));

        return x;

    }

    private double[] coordenadasY(double cy, double g){

        double[] y = new double[5];

        y[0] = cy + g * Math.sin(Math.toRadians(36));
        y[1] = cy + g;
        y[2] = cy + g * Math.sin(Math.toRadians(36));
        y[3] = cy - g * Math.cos(Math.toRadians(36));
        y[4] = cy - g * Math.cos(Math.toRadians(36));

        return y;

    }

    private double distanciaCentroVertice(){

        return getTamanho() * (Math.cos(Math.toRadians(36)) / Math.sin(Math.toRadians(36))) / 2.0;

    }

    private double apotema(){

        return getTamanho() / (2 * Math.sin(Math.toRadians(36)));

    }

    @Override
    public void desenhar(Draw tela, Coordenada coord, Color cor){

        // A coord será o ponto central do Hexagono
        double[] x = coordenadasX(coord.getCX(), distanciaCentroVertice());
        double[] y = coordenadasY(coord.getCY(), distanciaCentroVertice());


        if(this.temPreenchimento)
            desenharComPreenchimento(tela, x, y, cor);
        else desenharSemPreenchimento(tela, x, y);

        tela.show();
        areaSoma += getArea();

    }

    @Override
    public double getTamanho(){

        return this.tamanho;

    }

    @Override
    public void aumentarTamanho(){

        if(this.tamanho < TAMANHO_MAXIMO)
            tamanho += ALTERAR;

    }

    @Override
    public void diminuirTamanho(){
        
        if(this.tamanho > TAMANHO_MINIMO)
            tamanho -= ALTERAR;

    }

    @Override
    public void definirCorLinha(Color cor){

        this.corDeLinha = cor;

    }

    @Override
    public double getArea(){

        // A = 2.5 * l * a
        // a representa os lados (getTamanho)
        // l é apótema da base

        return 2.5 * apotema() * getTamanho();

    }

    @Override
    public void setPreenchimento(boolean p){

        this.temPreenchimento = p;

    }

}