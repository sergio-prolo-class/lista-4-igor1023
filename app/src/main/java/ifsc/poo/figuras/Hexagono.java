package ifsc.poo.figuras;

import java.awt.Color;

import edu.princeton.cs.algs4.Draw;
import ifsc.poo.Constantes;

public class Hexagono extends FormaGeometrica {

    // tamanho representa a medida dos lados 
    // do Hexagono

    public Hexagono(){

        this.tamanho = Constantes.TAMANHO_DEFAULT_CIRCULO;

    }

    private double[] coordenadasX(double cx){

        double[] x = new double[6]; // seis pontos

        x[0] = cx + getTamanho();
        x[1] = cx + getTamanho() * Math.cos(Math.toRadians(60));
        x[2] = cx - getTamanho() * Math.cos(Math.toRadians(60));
        x[3] = cx - getTamanho();
        x[4] = cx - getTamanho() * Math.cos(Math.toRadians(60));
        x[5] = cx + getTamanho() * Math.cos(Math.toRadians(60));

        return x;

    }

    private double[] coordenadasY(double cy){

        double[] y = new double[6]; // seis pontos

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
        double[] x = coordenadasX(getCoordenada().getCX());
        double[] y = coordenadasY(getCoordenada().getCY());

        if(this.temPreenchimento)
            desenharComPreenchimento(tela, x, y, getCor());
        else desenharSemPreenchimento(tela, x, y, getCor());

        tela.show();

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

}