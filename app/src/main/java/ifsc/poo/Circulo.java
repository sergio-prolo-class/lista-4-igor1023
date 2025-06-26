package ifsc.poo;

import java.awt.Color;

import edu.princeton.cs.algs4.Draw;

public class Circulo extends ObjetoDeDesenho{

    public Circulo(){

        this.tamanho = Constantes.TAMANHO_DEFAULT_CIRCULO;

    }

    private void desenharSemPreenchimento(Draw tela, Coordenada coord){

        tela.setPenColor(Color.BLACK);
        tela.circle(coord.getCX(), coord.getCY(), tamanho);

    }

    private void desenharComPreenchimento(Draw tela, Coordenada coord, Color cor){

        tela.setPenColor(cor);
        tela.filledCircle(coord.getCX(), coord.getCY(), this.tamanho);

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

        return this.corDeLinha;

    }
}