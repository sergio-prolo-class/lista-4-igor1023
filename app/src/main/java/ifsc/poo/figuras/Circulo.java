package ifsc.poo.figuras;
import java.awt.Color;

import edu.princeton.cs.algs4.Draw;
import ifsc.poo.Constantes;
import ifsc.poo.Coordenada;

public class Circulo extends FormaGeometrica{

    // tamanho é o raio

    public Circulo(){

        this.tamanho = Constantes.TAMANHO_DEFAULT_CIRCULO;

    }

    private void desenharSemPreenchimento(Draw tela, Coordenada coord, Color cor){

        tela.setPenColor(cor);
        tela.circle(getCoordenada().getCX(), getCoordenada().getCY(), getTamanho());

    }

    private void desenharComPreenchimento(Draw tela, Coordenada coord, Color cor){

        tela.setPenColor(cor);
        tela.filledCircle(getCoordenada().getCX(), getCoordenada().getCY(), getTamanho());

        // Para desenhar a borda em preto
        desenharSemPreenchimento(tela, getCoordenada(), Color.BLACK);
    }

    @Override
    public void desenhar(Draw tela){

        if(this.temPreenchimento)
            desenharComPreenchimento(tela, getCoordenada(), getCor());
        else desenharSemPreenchimento(tela, getCoordenada(), getCor());

        tela.show();

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

}