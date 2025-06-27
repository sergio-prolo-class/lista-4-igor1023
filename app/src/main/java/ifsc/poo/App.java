// Aluno: Igor da Silva
package ifsc.poo;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import edu.princeton.cs.algs4.Draw;
import edu.princeton.cs.algs4.DrawListener;

public class App implements DrawListener {

    private final Draw tela = new Draw();
    private final double dimensao = 10.0;
    private ObjetoDeDesenho figura; // Figura a ser desenhada
    private String tipoObjetoSelecionado;
    private Coordenada coordenada;
    private boolean selecionouFigura;
    private boolean selecionouCor;
    private boolean preenchido, selecionouPreenchimento;
    private Color cor;
    private double somatorioArea;
    private double somatorioPerimetro;
    private List<ObjetoDeDesenho> figurasDesenhadas;

    public App() {

        this.tela.setXscale(0.0, dimensao);
        this.tela.setYscale(0.0, dimensao);
        this.tela.enableDoubleBuffering();

        this.preenchido = false;
        this.selecionouPreenchimento = false;
        this.cor = Color.RED;
        this.somatorioArea = 0.0;
        this.somatorioPerimetro = 0.0;
        this.figurasDesenhadas = new ArrayList<>();
        this.coordenada = new Coordenada();
        this.tipoObjetoSelecionado = null;

    }

    public void iniciar() {

        // Compilador informou de vazamento no construtor:
        // estou passando o proprio objeto antes de finalizar 
        // as tarefas do construtor, entao criei este método
        // para chamar depois de criar um objeto de App
        this.tela.addListener(this);

    }

    public void desenharTela() {

        this.tela.clear();
        this.tela.setTitle("Clique em qualquer região para desenhar sua Figura");
        this.tela.show();

    }

    public void configuracaoDeCor(Color color) {

        this.cor = color;
        this.selecionouCor = true;
        System.out.println(this.cor);

    }

    public void configuracaoDePreenchimento() {

        this.preenchido = !this.preenchido; // para intercalar

        System.out.println("Tem preenchimento: " + this.preenchido);
        this.selecionouPreenchimento = true;

    }

    public void configuracaoDeFigura(String nomeFigura) {
        
        this.tipoObjetoSelecionado = nomeFigura;
        this.selecionouFigura = true;

        this.selecionouCor = false;
        this.selecionouPreenchimento = false;

        // Para remover o "ifsc.poo.";
        System.out.println("Figura :" + nomeFigura);

    }

    public void configuracaoDeLimpeza() {

        this.tela.clear();
        this.tela.show();
        this.figurasDesenhadas.clear();
        this.somatorioArea = 0.0;
        this.somatorioPerimetro = 0.0;

    }

    public void configuracaoDeTamanho(int i) {

        if (i < 0) {
            this.figura.diminuirTamanho(); 
        }else if (i > 0) {
            this.figura.aumentarTamanho();
        }

        System.out.println("Tamanho: " + this.figura.getTamanho());

    }

    public void processar() {

        System.out.printf("Total de figuras desenhadas: %d\n", this.figurasDesenhadas.size());
        System.out.printf("Somatório de área das figuras: %.2f\n", this.somatorioArea);
        System.out.printf("Somatório de perímetro das figuras: %.2f\n", this.somatorioPerimetro);

    }

    public void moverEsquerda(double a) {

        for (ObjetoDeDesenho fig : this.figurasDesenhadas) {
            fig.moverEsquerda(a);
        }

        desenharFiguras();

    }

    public void moverBaixo(double a) {

        for (ObjetoDeDesenho fig : this.figurasDesenhadas) {
            fig.moverBaixo(a);
        }

        desenharFiguras();

    }

    public void moverDireita(double a) {

        for (ObjetoDeDesenho fig : this.figurasDesenhadas) {
            fig.moverDireita(a);
        }

        desenharFiguras();

    }

    public void moverCima(double a) {

        for (ObjetoDeDesenho fig : this.figurasDesenhadas) {
            fig.moverCima(a);
        }

        desenharFiguras();

    }

    private void desenharFiguras() {

        this.tela.clear();

        for (ObjetoDeDesenho fig : this.figurasDesenhadas) {

            fig.desenhar(this.tela);
            System.out.println(fig.getCoordenada().getCX() + "; " + fig.getCoordenada().getCY());

        }
    }

    private ObjetoDeDesenho criarFigura() {

        ObjetoDeDesenho fig = switch (this.tipoObjetoSelecionado) {

            case "Circulo" ->
                new Circulo();
            case "Quadrado" ->
                new Quadrado();
            case "Hexagono" ->
                new Hexagono();
            case "Losango" ->
                new Losango();
            default ->
                null; // nunca vai ser 

        };

        fig.definirCorLinha(this.cor);
        fig.setPreenchimento(preenchido);

        return fig;

    }

    public static void main(String[] args) {

        App lista4 = new App();
        lista4.iniciar();
        lista4.desenharTela();

    }

    // Implementar métodos das interfaces
    @Override
    public void mousePressed(double x, double y) {

        this.coordenada = new Coordenada(x, y);

        if (this.selecionouFigura && this.selecionouCor && this.selecionouPreenchimento
            && this.tipoObjetoSelecionado != null) {

            this.figura = criarFigura();
            this.figura.setCoordenada(this.coordenada.getCX(), this.coordenada.getCY());
            this.figura.desenhar(this.tela);

            // Só contabilizo uma figura criada quando ela é desenhada
            this.figurasDesenhadas.add(this.figura);

            somatorioArea += this.figura.getArea();
            somatorioPerimetro += this.figura.getPerimetro();

            // this.selecionouFigura = false;
            // this.selecionouCor = false;
            // this.selecionouPreenchimento = false;

        } else 
            System.out.println("Defina as características: FIGURA, COR e POSSUI PREENCHIMENTO");

    }

    // Quando a tecla for solta
    @Override
    public void keyReleased(int i) {

        // CÓDIGOS: https://learn.microsoft.com/pt-br/dotnet/api/system.windows.forms.keys?view=windowsdesktop-8.0
        // Compilador sugeriu aplicar "rule switch"
        switch (i) {

            // TECLAS F
            case 112 ->
                configuracaoDeFigura("Circulo");// F1

            case 113 ->
                configuracaoDeFigura("Quadrado"); // F2

            case 114 ->
                configuracaoDeFigura("Hexagono"); // F3

            case 115 ->
                configuracaoDeFigura("Losango"); // F4

            // CORES
            case 116 -> { //F5

                if (selecionouFigura) {
                    configuracaoDeCor(Color.RED);
                }

            }

            case 117 -> { // F6

                if (selecionouFigura) {
                    configuracaoDeCor(Color.BLUE);
                }

            }

            case 118 -> { // F7

                if (selecionouFigura) {
                    configuracaoDeCor(Color.GREEN);
                }

            }

            case 119 -> { // F8

                if (selecionouFigura) {
                    configuracaoDeCor(Color.YELLOW);
                }

            }

            // COMANDOS 
            case 67 ->
                configuracaoDeLimpeza(); // C

            case 70 -> { // F

                if (selecionouFigura) {
                    configuracaoDePreenchimento();
                }

            }

            case 80 ->
                processar(); // P

            case 81 -> { // Q

                if (selecionouFigura) {
                    configuracaoDeTamanho(-1);
                }

            }

            case 87 -> { // W

                if (selecionouFigura) {
                    configuracaoDeTamanho(1);
                }

            }

            // SETAS
            case 37 ->
                moverEsquerda(Constantes.VALOR_MOVER); // ESQUERDA

            case 38 ->
                moverCima(Constantes.VALOR_MOVER); // CIMA

            case 39 ->
                moverDireita(Constantes.VALOR_MOVER); // DIREITA

            case 40 ->
                moverBaixo(Constantes.VALOR_MOVER); // BAIXO

        }

    }

    @Override
    public void mouseDragged(double v, double v1) {
    }

    @Override
    public void mouseReleased(double v, double v1) {
    }

    @Override
    public void mouseClicked(double v, double v1) {
    }

    @Override
    public void keyPressed(int i) {
    }

    @Override
    public void keyTyped(char c) {
    }

}
