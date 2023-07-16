package pl.edu.pg.eti.ksg.oop.lab1.transformations;
public class Point {
    private final double x,y;
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Point tmp){
            return (this.x == tmp.x)&&(this.y == tmp.y);
        }
        return false;
    }
    @Override
    public int hashCode() {
       return 13 * Double.hashCode(this.x) + 7;
    }
    @Override
    public String toString() {
        return "Point with cords: (" + this.x + ", " + this.y + ")";
    }
    public static final Point O = new Point(0, 0);
    /**
     * Point (1,0) in the coordinates system
     */
    public static final Point E_X = new Point(1, 0);
    /**
     * Point (0,1) in the coordinates system
     */
    public static final Point E_Y = new Point(0, 1);
}