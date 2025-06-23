// Aluno: Igor da Silva

package ifsc.poo;

import java.awt.Color;

import edu.princeton.cs.algs4.Draw;
import edu.princeton.cs.algs4.DrawListener;

public class App implements DrawListener{
    
    private Draw tela = new Draw();
    private final double dimensao = 10.0;
    private ObjetoDeDesenho figura;
    private Coordenada coordenada;
    private boolean selecionouFigura;
    private boolean selecionouCor;
    private boolean preenchido, selecionouPreenchimento;
    private Color cor;
    
    public App(){

        this.tela.addListener(this);
        this.tela.setXscale(0.0, dimensao);
        this.tela.setYscale(0.0, dimensao);
        this.tela.enableDoubleBuffering();
        
        this.preenchido = selecionouPreenchimento = false;
        this.cor = Color.RED;
        coordenada = new Coordenada();

    }

    public void desenharTela(){

        this.tela.clear();
        this.tela.setTitle("Clique em qualquer região para desenhar sua Figura");
        this.tela.show();

    }

    public static void main(String[] args) {

        System.out.println("OLÁ\n");
        App lista4 = new App();
        lista4.desenharTela();
        
    }

    
    // Implementar métodos das interfaces


    public void mousePressed(double x, double y) {

        //System.out.printf("(%g; %g)\n", x, y);
        this.coordenada.setCX(x);
        this.coordenada.setCY(y);
        
        if(selecionouFigura && selecionouCor && selecionouPreenchimento)
            figura.desenhar(tela, coordenada, cor);

    }

    public void keyTyped(char c) {     
    }

    // Quando a tecla for solta
    public void keyReleased(int i) {

        // CÓDIGOS: https://learn.microsoft.com/pt-br/dotnet/api/system.windows.forms.keys?view=windowsdesktop-8.0

        switch(i){

            // TECLAS F
            case 112 : // F1

                this.figura = new Circulo();
                this.selecionouFigura = true;
                System.out.println(figura.getClass().getName());
                break;
            
            case 113 : // F2
                break;
            
            case 114 : // F3
                break;
        
            case 115 : // F4
                break;            
            
            // CORES
            case 116 : // F5
               
                if(selecionouFigura){

                    this.cor = Color.RED;
                    figura.definirCorLinha(cor);
                    selecionouCor = true;
                    System.out.println(cor);

                }

                break;
            
            case 117 : // F6

                if(selecionouFigura){

                    this.cor = Color.BLUE;
                    figura.definirCorLinha(cor);
                    selecionouCor = true;
                    System.out.println(cor);

                }    

                break;
            
            case 118 : // F7
                
                if(selecionouFigura){

                    this.cor = Color.GREEN;
                    figura.definirCorLinha(cor);
                    selecionouCor = true;
                    System.out.println(cor);

                }

                break;

            case 119 : // F8
                
                if(selecionouFigura){

                    this.cor = Color.YELLOW;
                    figura.definirCorLinha(cor);
                    selecionouCor = true;
                    System.out.println(cor);

                }

                break;

            // COMANDOS 
            case 67  : // C

                this.tela.clear();
                this.tela.show();
                break;

            case 70  : // F
                
                if(selecionouFigura){

                    this.preenchido = ! this.preenchido;
                    figura.setPreenchimento(preenchido);

                    System.out.println("Tem preenchimento: " + this.preenchido);
                    this.selecionouPreenchimento = true;

                }

                break;
            
            case 80  : // P
                break;
            
            case 81  : // Q
                
                if(selecionouFigura){
                
                    figura.diminuirTamanho();
                    System.out.println(figura.getTamanho());
                
                }

                break;

            case 87  : // W

                if(selecionouFigura){
                
                    figura.aumentarTamanho();    
                    System.out.println(figura.getTamanho());
                
                }
        }

    }

    public void mouseDragged(double v, double v1) {
    }

    public void mouseReleased(double v, double v1) {
    }

    // Não utilizei este método pois não funciona:
    // - varios cliques em diversos locais da tela
    // em um curto intervalo de tempo apresenta problema
    public void mouseClicked(double v, double v1) {

        //System.out.printf("(%g; %g)\n", v, v1);

    }

    public void keyPressed(int i) {
    }

}
