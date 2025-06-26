// package ifsc.poo;

// import java.awt.Color;

// import edu.princeton.cs.algs4.Draw;

// public class Hexagono extends ObjetoDeDesenho{

//     static double areaSoma;

//     static{

//         areaSoma = 0.0;

//     }

//     public Hexagono(){

//         this.tamanho = Constantes.TAMANHO_DEFAULT_CIRCULO;

//     }

//     private void desenharSemPreenchimento(Draw tela, double[] x, double[] y){

        
//         tela.setPenColor(Color.BLACK);
//         tela.polygon(x, y);

//     }

//     private void desenharComPreenchimento(Draw tela, double[] x, double[] y, Color cor){

//         tela.setPenColor(cor);
//         tela.filledPolygon(x, y);

//         // Para desenhar a borda em preto
//         tela.setPenColor(Color.BLACK);
//         desenharSemPreenchimento(tela, x, y);
//     }

//     private double[] coordenadasX(double cx){

//         double[] x = new double[6];

//         x[0] = cx + getTamanho();
//         x[1] = cx + getTamanho() * Math.cos(Math.toRadians(60));
//         x[2] = cx - getTamanho() * Math.cos(Math.toRadians(60));
//         x[3] = cx - getTamanho();
//         x[4] = cx - getTamanho() * Math.cos(Math.toRadians(60));
//         x[5] = cx + getTamanho() * Math.cos(Math.toRadians(60));

//         return x;

//     }

//     private double[] coordenadasY(double cy){

//         double[] y = new double[6];

//         y[0] = cy;
//         y[1] = cy + getTamanho() * Math.cos(Math.toRadians(30));
//         y[2] = cy + getTamanho() * Math.cos(Math.toRadians(30));
//         y[3] = cy;
//         y[4] = cy - getTamanho() * Math.cos(Math.toRadians(30));
//         y[5] = cy - getTamanho() * Math.cos(Math.toRadians(30));

//         return y;

//     }

//     @Override
//     public void desenhar(Draw tela, Coordenada coord, Color cor){

//         // A coord será o ponto central do Hexagono
//         double[] x = coordenadasX(coord.getCX());
//         double[] y = coordenadasY(coord.getCY());


//         if(this.temPreenchimento)
//             desenharComPreenchimento(tela, x, y, cor);
//         else desenharSemPreenchimento(tela, x, y);

//         tela.show();
//         areaSoma += getArea();

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

//         // A = (3√3 * lado²) / 2
//         return (3.0 * Math.sqrt(3.0) * Math.pow(getTamanho(), 2.0)) / 2.0;

//     }

//     @Override
//     public void setPreenchimento(boolean p){

//         this.temPreenchimento = p;

//     }

// }