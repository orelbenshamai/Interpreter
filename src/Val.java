import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * this class implements a value.
 * this class has the following methods:
 * constructor, evaluate with a map, evaluate without a map, returns the variable, assign an expression
 * to the variable, nandify, simplify, norify, check if the variable is equal to another expression and
 * gives a representation of the variable as a string.
 *
 * @author Orel Ben Shamay
 */
public class Val implements Expression {

    private boolean value;

    /**
     * constructor which creates a new instance of a value.
     *
     * @param newValue boolean
     */
    public Val(boolean newValue) {
        this.value = newValue;
    }

    @Override
    public Boolean evaluate(Map<String, Boolean> assignment) throws Exception {
        return this.value;
    }

    @Override
    public Boolean evaluate() throws Exception {
        return this.value;
    }

    @Override
    public List<String> getVariables() {
        return new ArrayList<>();
    }

    @Override
    public Expression assign(String var, Expression expression) {
        return this;
    }

    @Override
    public Expression nandify() {
        return this;
    }

    @Override
    public Expression norify() {
        return this;
    }

    @Override
    public Expression simplify() {
        return this;
    }

    @Override
    public boolean equals(Expression expression) {
        return this.toString().equals(expression.toString());
    }

    @Override
    public String toString() {
        if (this.value) {
            return "T";
        }
        return "F";
    }
}
