import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * this class implements a variable.
 * this class has the following methods:
 * constructor, evaluate with a map, evaluate without a map, returns the variable, assign an expression
 * to the variable, nandify, simplify, norify, check if the variable is equal to another expression and
 * gives a representation of the variable as a string.
 *
 * @author Orel Ben Shamay
 */
public class Var implements Expression {

    private String variable;

    /**
     * constructor which creates a new instance of a variable.
     *
     * @param newVariable String
     */
    public Var(String newVariable) {
        this.variable = newVariable;
    }

    @Override
    public Boolean evaluate(Map<String, Boolean> assignment) throws Exception {
        if (!assignment.containsKey(this.variable)) {
            throw new Exception("Did not found any value for variable " + this.variable);
        }
        return assignment.get(this.variable);
    }

    @Override
    public Boolean evaluate() throws Exception {
        throw new Exception("Did not have any values for the variables");
    }

    @Override
    public List<String> getVariables() {
        List<String> vars = new ArrayList<>();
        vars.add(this.variable);
        return vars;
    }

    @Override
    public Expression assign(String var, Expression expression) {
        if (this.variable.equals(var)) {
            return expression;
        }
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
        return this.variable;
    }
}