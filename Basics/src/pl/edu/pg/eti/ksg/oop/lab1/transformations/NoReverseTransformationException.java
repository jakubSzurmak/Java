package pl.edu.pg.eti.ksg.oop.lab1.transformations;
/*
 * This class inherits from the java.lang.Exception class
 */
public class NoReverseTransformationException extends Exception
{
    public NoReverseTransformationException() {
        super();
//Implicit call of the base class constructor
//super();
    }
    /*
     * A constructor which accepts textual description
     * of the error as its parameter
     */
    public NoReverseTransformationException(String message) {
        super(message);
    }
    /*
     * A constructor which accepts reference to another exception
     * (which caused the error) as its parameter.
     */
    public NoReverseTransformationException(Throwable cause) {
        super(cause);
    }

    /*
    * A constructor which accepts both the textual description
    * of the error and the exception reference as its parameters
    .
    */
    public NoReverseTransformationException(String message, Throwable cause) {
        super(message, cause);
    }
}