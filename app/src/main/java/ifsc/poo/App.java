// Aluno: Igor da Silva

package ifsc.poo;

import java.awt.Color;

import edu.princeton.cs.algs4.Draw;
import edu.princeton.cs.algs4.DrawListener;

public class App implements DrawListener{
    
    private final Draw tela = new Draw();
    private final double dimensao = 10.0;
    private ObjetoDeDesenho figura;
    private final Coordenada coordenada;
    private boolean selecionouFigura;
    private boolean selecionouCor;
    private boolean preenchido, selecionouPreenchimento;
    private Color cor;
    private double somatorioArea;
    private int numeroFiguras;
    
    public App(){

        this.tela.setXscale(0.0, dimensao);
        this.tela.setYscale(0.0, dimensao);
        this.tela.enableDoubleBuffering();
        
        this.preenchido = false;
        this.selecionouPreenchimento = false;
        this.cor = Color.RED;
        this.somatorioArea = 0.0;
        this.numeroFiguras = 0;
        this.coordenada = new Coordenada();

    }

    public void iniciar(){

        // Compilador informou de vazamento no construtor:
        // estou passando o proprio objeto antes de finalizar 
        // as tarefas do construtor, entao criei este método
        // para chamar depois de criar um objeto de App

        this.tela.addListener(this);        

    }

    public void desenharTela(){

        this.tela.clear();
        this.tela.setTitle("Clique em qualquer região para desenhar sua Figura");
        this.tela.show();

    }

    public void configuracaoDeCor(Color color){

        this.cor = color;
        this.figura.definirCorLinha(this.cor);
        this.selecionouCor = true;
        System.out.println(this.cor);

    }

    public void configuracaoDePreenchimento(){

        this.preenchido = ! this.preenchido; // para intercalar
        this.figura.setPreenchimento(preenchido);

        System.out.println("Tem preenchimento: " + this.preenchido);
        this.selecionouPreenchimento = true;

    }

    public void configuracaoDeFigura(ObjetoDeDesenho figura){

        this.figura = figura;
        this.selecionouFigura = true;
        this.somatorioArea += figura.getArea();
        System.out.println(figura.getClass().getName());

    }

    public void mostrarTamanho(){

        System.out.println("Tamanho: " + this.figura.getTamanho());

    }

    public void processar(){

        

    }

    public static void main(String[] args) {

        App lista4 = new App();
        lista4.iniciar();
        lista4.desenharTela();
        
    }

    
    // Implementar métodos das interfaces

    @Override
    public void mousePressed(double x, double y) {

        //System.out.printf("(%g; %g)\n", x, y);
        this.coordenada.setCX(x);
        this.coordenada.setCY(y);
        
        if(this.selecionouFigura && this.selecionouCor && this.selecionouPreenchimento){
            
            figura.desenhar(this.tela, this.coordenada, this.cor);
            
            // Só contabilizo uma figura criada quando ela é desenhada
            this.numeroFiguras++; 
        }
        else System.out.println("Defina as características: FIGURA, COR e POSSUI PREENCHIMENTO");

    }

    // Quando a tecla for solta
    @Override
    public void keyReleased(int i) {

        // CÓDIGOS: https://learn.microsoft.com/pt-br/dotnet/api/system.windows.forms.keys?view=windowsdesktop-8.0

        // Compilador sugeriu aplicar "rule switch"
        switch(i){

            // TECLAS F
            case 112 -> configuracaoDeFigura(new Circulo()); // F1
            
            case 113 -> configuracaoDeFigura(new Quadrado()); // F2
            
            case 114 -> configuracaoDeFigura(new Hexagono()); // F3
        
            case 115 -> configuracaoDeFigura(new Pentagono()); // F4
            
            // CORES
            case 116 -> { //F5
               
                if(selecionouFigura)
                    configuracaoDeCor(Color.RED);        

            }
            
            case 117 -> { // F6

                if(selecionouFigura)
                    configuracaoDeCor(Color.BLUE); 

            }
            
            case 118 -> { // F7
                
                if(selecionouFigura)
                    configuracaoDeCor(Color.GREEN); 

            }

            case 119 -> { // F8
                
                if(selecionouFigura)
                    configuracaoDeCor(Color.YELLOW); 

            }

            // COMANDOS 
            case 67 -> { // C

                this.tela.clear();
                this.tela.show();

            }

            case 70 -> { // F
                
                if(selecionouFigura)
                    configuracaoDePreenchimento();

            }
            
            case 80 -> processar(); // P
            
            case 81 -> { // Q
                
                if(selecionouFigura){
                
                    this.figura.diminuirTamanho();
                    mostrarTamanho();

                }

            }

            case 87 -> { // W

                if(selecionouFigura){
                
                    this.figura.aumentarTamanho();    
                    mostrarTamanho();
                
                }

            }
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
