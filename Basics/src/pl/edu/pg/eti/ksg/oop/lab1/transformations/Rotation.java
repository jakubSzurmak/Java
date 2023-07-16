package pl.edu.pg.eti.ksg.oop.lab1.transformations;

public class Rotation implements Transformation{
    private final double alfa;

    public Rotation(double alfa){

        this.alfa = alfa;
    }

    @Override
    public Point transform(Point p) {
        return new Point((p.getX()*java.lang.Math.cos(java.lang.Math.toRadians(alfa)) - p.getY()*java.lang.Math.sin(java.lang.Math.toRadians(alfa))),(p.getX()*java.lang.Math.sin(java.lang.Math.toRadians(alfa)) + p.getY()*java.lang.Math.cos(java.lang.Math.toRadians(alfa))));
    }
    @Override
    public Transformation getReverseTransformation() {
        return new Rotation(alfa*-1);
    }

    @Override
    public String toString() {
        return "Rotation by angle " + alfa;
    }

}
