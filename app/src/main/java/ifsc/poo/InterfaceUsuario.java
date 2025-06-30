// Classe da interface com o usuario
package ifsc.poo;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import edu.princeton.cs.algs4.Draw;
import edu.princeton.cs.algs4.DrawListener;
import ifsc.poo.figuras.Circulo;
import ifsc.poo.figuras.FormaGeometrica;
import ifsc.poo.figuras.Hexagono;
import ifsc.poo.figuras.Losango;
import ifsc.poo.figuras.Quadrado;

public class InterfaceUsuario implements DrawListener {

    // Tela
    private final Draw tela;

    // Parametros para criar uma figura
    private FormaGeometrica figura; // Figura a ser desenhada
    private Coordenada coordenada;
    private boolean ehPreenchido;
    private Color cor;
    private double tamanho;

    // Parâmetros de operação obtidos do teclado
    private String tipoObjetoSelecionado;
    private boolean selecionouFigura;
    private boolean selecionouCor;
    private boolean selecionouPreenchimento;

    private double somatorioArea;
    private double somatorioPerimetro;
    private final List<FormaGeometrica> figurasDesenhadas;

    public InterfaceUsuario() {

        this.tela = new Draw();
        this.tela.setXscale(0.0, Constantes.DIMENSAO);
        this.tela.setYscale(0.0, Constantes.DIMENSAO);
        this.tela.enableDoubleBuffering();

        this.selecionouFigura = false;
        this.selecionouCor = false;
        this.selecionouPreenchimento = false;
        this.ehPreenchido = false;
        this.cor = null;

        this.somatorioArea = 0.0;
        this.somatorioPerimetro = 0.0;
        this.tamanho = 0.0;
        this.figurasDesenhadas = new ArrayList<>();
        this.coordenada = new Coordenada();
        this.tipoObjetoSelecionado = null;

    }

    private void iniciarTela() {

        // Compilador informou de vazamento no construtor:
        // estou passando o proprio objeto antes de finalizar 
        // as tarefas do construtor, entao criei este método
        // para chamar depois de criar um objeto de App
        this.tela.addListener(this);

    }

    private void desenharTela(String titulo) {

        this.tela.clear();
        this.tela.setTitle(titulo);
        this.tela.show();

    }

    public void iniciar(String titulo){

        iniciarTela();
        desenharTela(titulo);

    }

    private void configuracaoDeCor(String nomeCor) {

        this.cor = switch (nomeCor) {

            case "Vermelho" ->
                Color.RED;
            case "Azul" ->
                Color.BLUE;
            case "Verde" ->
                Color.GREEN;
            case "Amarelo" ->
                Color.YELLOW;
            default ->
                null; // Nunca vai ocorrer
        };

        this.selecionouCor = true;
        System.out.println("Cor: " + nomeCor);

    }

    private void configuracaoDePreenchimento() {

        this.ehPreenchido = !this.ehPreenchido; // para intercalar

        System.out.println("Tem preenchimento: " + this.ehPreenchido);
        this.selecionouPreenchimento = true;

    }

    private void configuracaoDeFigura(String nomeFigura) {

        this.tipoObjetoSelecionado = nomeFigura;
        this.selecionouFigura = true;

        this.selecionouCor = false;
        this.selecionouPreenchimento = false;

        this.tamanho = switch (nomeFigura) {

            case "Circulo" ->
                this.tamanho = Constantes.TAMANHO_DEFAULT_CIRCULO;
            case "Quadrado" ->
                this.tamanho = Constantes.TAMANHO_DEFAULT_QUADRADO;
            case "Hexagono" ->
                this.tamanho = Constantes.TAMANHO_DEFAULT_HEXAGONO;
            case "Losango" ->
                this.tamanho = Constantes.TAMANHO_DEFAULT_LOSANGO;
            default ->
                0.0;

        };

        System.out.println("Figura: " + nomeFigura);

    }

    private void configuracaoDeLimpeza() {

        this.tela.clear();
        this.tela.show();
        this.figurasDesenhadas.clear();

        this.somatorioArea = 0.0;
        this.somatorioPerimetro = 0.0;

        System.out.println("A tela foi limpa.");

    }

    private void configuracaoDeTamanho(int i) {

        if (i < 0) {

            if (this.tamanho > Constantes.TAMANHO_MINIMO) {
                this.tamanho -= Constantes.VALOR_ALTERAR;
            }

        } else if (i > 0) {

            if (this.tamanho < Constantes.TAMANHO_MAXIMO) {
                this.tamanho += Constantes.VALOR_ALTERAR;
            }

        }

        System.out.println("Tamanho: " + this.tamanho);

    }

    private void processar() {

        System.out.printf("Total de figuras desenhadas: %d\n", this.figurasDesenhadas.size());
        System.out.printf("Somatório de área das figuras: %.2f\n", this.somatorioArea);
        System.out.printf("Somatório de perímetro das figuras: %.2f\n", this.somatorioPerimetro);

    }

    // Para mover:
    // > Limpo a tela;
    // > Altero as coordenadas conforme a direção;
    // > Redesenho as figuras
    private void moverEsquerda(double a) {

        for (FormaGeometrica fig : this.figurasDesenhadas) {
            fig.moverEsquerda(a);
        }

        desenharFiguras();

    }

    private void moverBaixo(double a) {

        for (FormaGeometrica fig : this.figurasDesenhadas) {
            fig.moverBaixo(a);
        }

        desenharFiguras();

    }

    private void moverDireita(double a) {

        for (FormaGeometrica fig : this.figurasDesenhadas) {
            fig.moverDireita(a);
        }

        desenharFiguras();

    }

    private void moverCima(double a) {

        for (FormaGeometrica fig : this.figurasDesenhadas) {
            fig.moverCima(a);
        }

        desenharFiguras();

    }

    private void desenharFiguras() {

        // limpo e redesenho
        this.tela.clear();

        for (FormaGeometrica fig : this.figurasDesenhadas) {
            fig.desenhar(this.tela);
        }

    }

    private FormaGeometrica criarFigura() {

        // Uso de Polimorfismo
        FormaGeometrica fig = switch (this.tipoObjetoSelecionado) {

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

        // nunca será NULL
        fig.setTamanho(this.tamanho);
        fig.setCoordenada(this.coordenada.getCX(), this.coordenada.getCY());
        fig.definirCorLinha(this.cor);
        fig.setPreenchimento(this.ehPreenchido);

        return fig;

    }

    // Implementar métodos das interfaces
    @Override
    public void mousePressed(double x, double y) {

        this.coordenada = new Coordenada(x, y);

        if (this.selecionouFigura && this.selecionouCor && this.selecionouPreenchimento
                && this.tipoObjetoSelecionado != null) {

            // Uso de Polimorfismo
            this.figura = criarFigura();
            this.figura.desenhar(this.tela);

            // Só contabilizo uma figura criada quando ela é desenhada
            this.figurasDesenhadas.add(this.figura);

            somatorioArea += this.figura.getArea();
            somatorioPerimetro += this.figura.getPerimetro();

        } else {
            System.out.println("Defina as características: FIGURA, COR e POSSUI PREENCHIMENTO");
        }

    }

    // Quando a tecla for solta
    @Override
    public void keyReleased(int i) {

        // CÓDIGOS: https://learn.microsoft.com/pt-br/dotnet/api/system.windows.forms.keys?view=windowsdesktop-8.0
        // Compilador sugeriu aplicar "rule switch"
        switch (i) {

            // TECLAS F
            case 112 ->
                configuracaoDeFigura("Circulo"); // F1
            case 113 ->
                configuracaoDeFigura("Quadrado"); // F2
            case 114 ->
                configuracaoDeFigura("Hexagono"); // F3
            case 115 ->
                configuracaoDeFigura("Losango"); // F4

            // CORES
            case 116 -> { //F5

                if (selecionouFigura) {
                    configuracaoDeCor("Vermelho");
                }

            }

            case 117 -> { // F6

                if (selecionouFigura) {
                    configuracaoDeCor("Azul");
                }

            }

            case 118 -> { // F7

                if (selecionouFigura) {
                    configuracaoDeCor("Verde");
                }

            }

            case 119 -> { // F8

                if (selecionouFigura) {
                    configuracaoDeCor("Amarelo");
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
                }else {
                    System.out.println("Selecione uma figura");
                }

            }

            case 87 -> { // W

                if (selecionouFigura) {
                    configuracaoDeTamanho(1); 
                }else {
                    System.out.println("Selecione uma figura");
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

    // Não utilizados
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