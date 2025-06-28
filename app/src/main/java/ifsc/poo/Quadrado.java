package ifsc.poo;
import java.awt.Color;

import edu.princeton.cs.algs4.Draw;

public class Quadrado extends ObjetoDeDesenho{

    public Quadrado(){

        this.tamanho = Constantes.TAMANHO_DEFAULT_QUADRADO;

    }

    private void desenharSemPreenchimento(Draw tela, Coordenada coord){

        tela.setPenColor(Color.BLACK);
        tela.square(coord.getCX(), coord.getCY(), getTamanho());

    }

    private void desenharComPreenchimento(Draw tela, Coordenada coord, Color cor){

        tela.setPenColor(cor);
        tela.filledSquare(coord.getCX(), coord.getCY(), getTamanho());

        // Para desenhar a borda em preto
        tela.setPenColor(Color.BLACK);
        desenharSemPreenchimento(tela, coord);
    }

    @Override
    public void desenhar(Draw tela){

        if(this.temPreenchimento)
            desenharComPreenchimento(tela, this.coordenada, this.corDeLinha);
        else desenharSemPreenchimento(tela, this.coordenada);

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

        // lado²
        return getTamanho() * getTamanho();

    }

    @Override
    public double getPerimetro(){

        return 4.0 * getTamanho();

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