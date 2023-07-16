package pl.edu.pg.eti.ksg.oop.lab1.transformations;
/*
 * The Translation class implements the Transformation interface
 */
public class Translation implements Transformation{
    private final double dX,dY;
    public Translation(double dX, double dY) {
        this.dX = dX;
        this.dY = dY;
    }
    @Override
    public Point transform(Point p) {
        return new Point(p.getX() + dX, p.getY() + dY);
    }

    @Override
    public Transformation getReverseTransformation() {
        return new Translation(-dX, -dY);
    }

    public double getdX() {
        return dX;
    }
    public double getdY() {
        return dY;
    }
    @Override
    public String toString() {
        return "Translation by vector ("+dX+","+dY+")";
    }
}