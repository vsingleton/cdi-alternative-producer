package info.cdi;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * Managed bean that calls a Shift implementation to perform a transformation
 * on an input string
 */
@Named
@RequestScoped
public class ShifterBean {

    private String inputString;
    private String shiftedString;
    @Max(26)
    @Min(0)
    @NotNull
    private int shiftBy;

    @Inject
    Shift shift;

    public void shiftString() {
        setShiftedString(shift.shift(inputString, shiftBy));
    }

    public void reset() {
        setInputString("");
        setShiftBy(0);
    }

    public String getInputString() {
        return inputString;
    }

    public void setInputString(String inString) {
        inputString = inString;
    }

    public String getShiftedString() {
        return shiftedString;
    }

    public void setShiftedString(String str) {
        shiftedString = str;
    }

    public int getShiftBy() {
        return shiftBy;
    }

    public void setShiftBy (int value) {
        shiftBy = value;
    }
}
