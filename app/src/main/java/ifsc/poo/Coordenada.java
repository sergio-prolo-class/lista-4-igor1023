package ifsc.poo;

public class Coordenada{

    public double x, y;

    public Coordenada(){

        this(0.0, 0.0);

    }

    public Coordenada(double x, double y){

        this.x = x;
        this.y = y;

    }

    public void setCX(double x0){

        this.x = x0;

    }

    public void setCY(double y0){

        this.y = y0;

    }

    public double getCX(){

        return this.x;

    }

    public double getCY(){

        return this.y;

    }

}