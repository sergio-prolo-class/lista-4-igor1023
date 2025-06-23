// Aluno: Igor da Silva



package ifsc.poo;

import java.awt.Color;
import edu.princeton.cs.algs4.Draw;
import edu.princeton.cs.algs4.DrawListener;

public class App implements DrawListener{
    
    private Draw tela = new Draw();
    private final double dimensao = 10.0;
    
    public App(){

        this.tela.addListener(this);
        this.tela.setXscale(0.0, dimensao);
        this.tela.setYscale(0.0, dimensao);
        this.tela.enableDoubleBuffering();

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

        System.out.printf("(%g; %g)\n", x, y);

    }

    public void keyTyped(char c) {     
    }

    // Quando a tecla for solta
    public void keyReleased(int i) {

        // CÓDIGOS: https://learn.microsoft.com/pt-br/dotnet/api/system.windows.forms.keys?view=windowsdesktop-8.0

        switch(i){

            case 112 : // F1
                break;
            
            case 113 : // F2
                break;
            
            case 114 : // F3
                break;
        
            case 115 : // F4
                break;            
            
            case 116 : // F5
                break;
            
            case 117 : // F6
                break;
            
            case 118 : // F7
                break;

            case 119 : // F8
                break;

            case 67  : // C
                this.tela.clear();
                break;

            case 70  : // F
                break;
            
            case 80  : // P
                break;
            
            case 81  : // Q
                break;

            case 87  : // W
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
