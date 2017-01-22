package info.alternative;

import info.cdi.Shift;
import javax.enterprise.context.Dependent;

/**
 * Shift implementation only displays the values of the arguments.
 */
@Dependent
public class AltShiftImpl implements Shift {

    public AltShiftImpl(String foo) {
        System.out.println("AltShiftImpl: ...");
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
