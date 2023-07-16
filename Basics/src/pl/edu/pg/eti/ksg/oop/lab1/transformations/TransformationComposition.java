package pl.edu.pg.eti.ksg.oop.lab1.transformations;

public class TransformationComposition implements Transformation{
    private final Transformation[] dArray;

    public TransformationComposition(Transformation[] arr) {//
        this.dArray = arr;
    }

    @Override
    public Point transform(Point p) {
        for (Transformation a : dArray) {
            p = a.transform(p);
        }
        return p;
    }
    @Override
    public Transformation getReverseTransformation() throws
            NoReverseTransformationException {
        Transformation[] reverseTransformation = new Transformation[dArray.length];
        for(int i =0; i < dArray.length; i++){
            reverseTransformation[i] = dArray[dArray.length - i - 1].getReverseTransformation();
        }
        return new TransformationComposition(reverseTransformation);
    }

    @Override
    public String toString() {
        return "TransformationComposition ("+dArray+")";
    }

}
