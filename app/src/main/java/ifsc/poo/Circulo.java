package ifsc.poo;

import java.awt.Color;

import edu.princeton.cs.algs4.Draw;

public class Circulo extends ObjetoDeDesenho{

    static double areaSoma;

    static{

        areaSoma = 0.0;

    }

    public Circulo(){

        this.tamanho = Constantes.TAMANHO_DEFAULT_HEXAGONO;

    }

    private void desenharSemPreenchimento(Draw tela, Coordenada coord){

        tela.setPenColor(Color.BLACK);
        tela.circle(coord.getCX(), coord.getCY(), tamanho);

    }

    private void desenharComPreenchimento(Draw tela, Coordenada coord, Color cor){

        tela.setPenColor(cor);
        tela.filledCircle(coord.getCX(), coord.getCY(), tamanho);

        // Para desenhar a borda em preto
        tela.setPenColor(Color.BLACK);
        desenharSemPreenchimento(tela, coord);
    }

    @Override
    public void desenhar(Draw tela, Coordenada coord, Color cor){

        if(this.temPreenchimento)
            desenharComPreenchimento(tela, coord, cor);
        else desenharSemPreenchimento(tela, coord);

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

        // Pierri²
        return Math.PI * Math.pow(getTamanho(), 2.0);

    }

    @Override
    public void setPreenchimento(boolean p){

        this.temPreenchimento = p;

    }
}