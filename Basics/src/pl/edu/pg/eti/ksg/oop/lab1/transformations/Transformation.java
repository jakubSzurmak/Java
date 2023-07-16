package pl.edu.pg.eti.ksg.oop.lab1.transformations;

public interface Transformation {
    Point transform(Point p);
    Transformation getReverseTransformation()
            throws NoReverseTransformationException;
}
