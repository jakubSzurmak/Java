package pl.edu.pg.eti.ksg.oop.lab1.transformations;
public class Scaling implements Transformation{
    private final double scaleX,scaleY;
    public Scaling(double scaleX, double scaleY) {
        this.scaleX = scaleX;
        this.scaleY = scaleY;
    }
    @Override
    public Point transform(Point p) {
        return new Point(scaleX * p.getX(), scaleY * p.getY());
    }
    @Override
    public Transformation getReverseTransformation()
            throws NoReverseTransformationException {
        if(scaleX == 0 || scaleY == 0)
            throw new NoReverseTransformationException("There is no reverse transformation. At least one of the scaling factors is equal to 0.");
        return new Scaling(1/scaleX,1/scaleY);
    }
    public double getScaleX() {
        return scaleX;
    }
    public double getScaleY() {
        return scaleY;
    }
    @Override
    public String toString() {
        return "Scaling "+scaleX+"x and "+scaleY+"y";
    }
}