package ifsc.poo.figuras;

import java.awt.Color;

import edu.princeton.cs.algs4.Draw;
import ifsc.poo.Constantes;

public class Losango extends FormaGeometrica {

    // tamanho representa a medida dos lados 
    // do Losango

    public Losango(){

        this.tamanho = Constantes.TAMANHO_DEFAULT_LOSANGO;

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
        double[] x = coordenadasX(getCoordenada().getCX());
        double[] y = coordenadasY(getCoordenada().getCY());


        if(this.temPreenchimento)
            desenharComPreenchimento(tela, x, y, getCor());
        else desenharSemPreenchimento(tela, x, y, getCor());

        tela.show();

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

}