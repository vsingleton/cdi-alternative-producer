package info.alternative;

// import javax.enterprise.inject.Alternative;
// import javax.interceptor.Interceptor;
// import javax.annotation.Priority;
import info.cdi.Shift;

/**
 * Shift implementation only displays the values of the arguments.
 */
// @Alternative
// @Priority(Interceptor.Priority.APPLICATION+10)
public class AltShiftImpl implements Shift {

    public AltShiftImpl(String foo) {
        System.out.println("AltShiftImpl: ...");
        // new Exception("inside constructor").printStackTrace();
    }

   /**
    * Returns a string that displays the values of the arguments.
    *
    * @param s     the input string
    * @param tval  the number of characters to shift
    * @return      string displaying argument values
    */
    @Override
    public String shift(String s, int tval) {
        return ("input string is " + s + ", shift value is " + tval);
    }
}
