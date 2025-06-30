package ifsc.poo.figuras;

import java.awt.Color;

import edu.princeton.cs.algs4.Draw;
import ifsc.poo.Constantes;
import ifsc.poo.Coordenada;

public class Quadrado extends FormaGeometrica {

    // tamanho representa a medida dos lados 
    // do Quadrado

    public Quadrado(){

        this.tamanho = Constantes.TAMANHO_DEFAULT_QUADRADO;

    }

    private void desenharSemPreenchimento(Draw tela, Coordenada coord, Color cor){

        tela.setPenColor(cor);
        tela.square(coord.getCX(), coord.getCY(), getTamanho());

    }

    private void desenharComPreenchimento(Draw tela, Coordenada coord, Color cor){

        tela.setPenColor(cor);
        tela.filledSquare(getCoordenada().getCX(), getCoordenada().getCY(), getTamanho());

        // Para desenhar a borda em preto
        desenharSemPreenchimento(tela, coord, Color.BLACK);
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

        // lado²
        return getTamanho() * getTamanho();

    }

    @Override
    public double getPerimetro(){

        return 4.0 * getTamanho();

    }

}