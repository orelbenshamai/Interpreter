import java.util.List;
import java.util.Map;

/**
 * this class implements an unary expression of type "Not".
 * this class has the following methods:
 * evaluate with a map, evaluate without a map, get all the variables in the expression, assign a given expression
 * to a variable, nandify, norify, simplify, gives a representation of the expression as a string
 * and check if the expression is equal to another given expression.
 *
 * @author Orel Ben Shamay
 */
public class Not extends UnaryExpression {

    /**
     * constructor which creates a new instance of an expression of type "Not".
     *
     * @param newExpression Expression
     */
    public Not(Expression newExpression) {
        super(newExpression);
    }

    @Override
    public Boolean evaluate(Map<String, Boolean> assignment) throws Exception {
        return !getExpression().evaluate(assignment);
    }

    @Override
    public Boolean evaluate() throws Exception {
        return !getExpression().evaluate();
    }

    @Override
    public List<String> getVariables() {
        List<String> list = getExpression().getVariables();
        return list;
    }

    @Override
    public Expression assign(String var, Expression expression) {
        return new Not(getExpression().assign(var, expression));
    }

    @Override
    public Expression nandify() {
        return new Nand(getExpression().nandify(), getExpression().nandify());
    }

    @Override
    public Expression norify() {
        return new Nor(getExpression().norify(), getExpression().norify());
    }

    @Override
    public Expression simplify() {
        Expression simplified = getExpression().simplify();
        if (simplified.toString().equals("F")) {
            return new Val(true);
        } else if (simplified.toString().equals("T")) {
            return new Val(false);
        }
        return new Not(simplified);
    }

    @Override
    public String toString() {
        String string = "~" + "(" + getExpression().toString() + ")";
        return string;
    }

    @Override
    public boolean equals(Expression expression) {
        return this.toString().equals(expression.toString());
    }
}
