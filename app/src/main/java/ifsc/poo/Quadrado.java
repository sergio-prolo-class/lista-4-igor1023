// package ifsc.poo;
// import java.awt.Color;

// import edu.princeton.cs.algs4.Draw;

// public class Quadrado extends ObjetoDeDesenho{

//     static double somaArea;

//     static{

//         somaArea = 0;

//     }

//     public Quadrado(){

//         this.tamanho = Constantes.TAMANHO_DEFAULT_QUADRADO;

//     }

//     private void desenharSemPreenchimento(Draw tela, Coordenada coord){

//         tela.setPenColor(Color.BLACK);
//         tela.square(coord.getCX(), coord.getCY(), getTamanho());

//     }

//     private void desenharComPreenchimento(Draw tela, Coordenada coord, Color cor){

//         tela.setPenColor(cor);
//         tela.filledSquare(coord.getCX(), coord.getCY(), getTamanho());

//         // Para desenhar a borda em preto
//         tela.setPenColor(Color.BLACK);
//         desenharSemPreenchimento(tela, coord);
//     }

//     @Override
//     public void desenhar(Draw tela, Coordenada coord, Color cor){

//         if(this.temPreenchimento)
//             desenharComPreenchimento(tela, coord, cor);
//         else desenharSemPreenchimento(tela, coord);

//         tela.show();
//         somaArea += getArea();

//     }

//     @Override
//     public double getTamanho(){

//         return this.tamanho;

//     }

//     @Override
//     public void aumentarTamanho(){

//         if(this.tamanho < TAMANHO_MAXIMO)
//             tamanho += ALTERAR;

//     }

//     @Override
//     public void diminuirTamanho(){
        
//         if(this.tamanho > TAMANHO_MINIMO)
//             tamanho -= ALTERAR;

//     }

//     @Override
//     public void definirCorLinha(Color cor){

//         this.corDeLinha = cor;

//     }

//     @Override
//     public double getArea(){

//         // lado²
//         return getTamanho() * getTamanho();

//     }

//     @Override
//     public void setPreenchimento(boolean p){

//         this.temPreenchimento = p;

//     }

// }