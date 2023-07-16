package pl.edu.pg.eti.ksg.oop.lab1;
import pl.edu.pg.eti.ksg.oop.lab1.transformations.*;


public class JavaLab1 {
    public static void main(String[] args) {
        /*
* The try {} and catch (...){} clauses are used for
* handling exceptions. The try block is monitored for
* exceptions declared
at the beginning of the catch block(s).
* If an exception occurs in the try block, the program will
* immediately fall to the corresponding catch block, which
* should be programmed to handle this exception.
* It can be done in many ways, such as: printing the
* stack trace of the error,
logging the exception or even
* throwing another exception
which can properly describe
* the situation (
the initial exception can be attached,
* see the java.lang.Exception constructor for details)
*/
        try {
            Point p1 = Point.E_X;
            System.out.println(p1);
            Transformation tr = new Translation(5, 6);
            System.out.println(tr);

            Point p2 = tr.transform(p1);
            System.out.println(p2);
            Transformation trr = tr.getReverseTransformation();
            System.out.println(trr);

            Point p3 = trr.transform(p2);
            System.out.println(p3);
            System.out.println("-----");

        } catch (NoReverseTransformationException ex)
        {
            ex.printStackTrace();
        }
        System.out.println();

        try
        {
            Point p1 = new Point(2, 2);
            System.out.println(p1);
            Transformation tr2 = new Scaling(5, 4);
            System.out.println(tr2);

            Point p2 = tr2.transform(p1);
            System.out.println(p2);
            Transformation trr2 = tr2. getReverseTransformation();
            System.out.println(trr2);

            Point p3 = trr2.transform(p2);
            System.out.println(p3);
            System.out.println("-----");

        }
        catch(NoReverseTransformationException ex)
        {
            ex.printStackTrace();
        }
        System.out.println();

        try
        {
            Point p1 = new Point(2, 2);
            Transformation tr2 = new Scaling(5, 1);
            System.out.println(tr2);
            System.out.println(p1);

            Point p2 = tr2.transform(p1);
            System.out.println(p2);
            Transformation trr2 = tr2.getReverseTransformation();
            System.out.println(trr2);

            Point p3 = trr2.transform(p2);
            System.out.println(p3);
            System.out.println("-----");

        }
        catch(NoReverseTransformationException ex)
        {
            ex.printStackTrace();
        }
        System.out.println();

        try
        {
            Point p1 = Point.E_X;
            System.out.println(p1);
            Transformation ro = new Rotation(360);
            System.out.println(ro);

            Point p2 = ro.transform(p1);
            System.out.println(p2);
            Transformation rro = ro.getReverseTransformation();
            System.out.println(rro);

            Point p3 = rro.transform(p2);
            System.out.println(p3);
            System.out.println("-----");


        }catch(NoReverseTransformationException ex){
            ex.printStackTrace();
        }
        System.out.println();

        try{
            Point p2 = Point.E_X;
            System.out.println(p2);
            TransformationComposition seq = new TransformationComposition(new Transformation[]{new Rotation(360), new Translation(5, 6), new Scaling(5, 1)});
            System.out.println(seq);
            Point p3 = seq.transform(p2);

            System.out.println(p3);
            Transformation seq2 = seq.getReverseTransformation();
            p2 = seq2.transform(p3);
            System.out.println(p2);

            System.out.println("-----");

        }catch(NoReverseTransformationException ex){
            ex.printStackTrace();
        }
    }
}
