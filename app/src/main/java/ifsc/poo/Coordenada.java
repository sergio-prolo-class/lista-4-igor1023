package ifsc.poo;

public class Coordenada{

    private double x, y;

    public Coordenada(){

        this.x = this.y = 0.0;

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