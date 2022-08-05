/**
 * this class implements the "Xnor" operator which is built from two expressions.
 * this class has the following methods:
 * constructors, operator method, nandify, norify and simplify.
 *
 * @author Orel Ben Shamay 318869658
 */
public class Xnor extends BinaryExpression {

    /**
     * constructor which creates a new instance of a binary expression of type "Xnor".
     *
     * @param newExpression1 Expression
     * @param newExpression2 Expression
     */
    public Xnor(Expression newExpression1, Expression newExpression2) {
        super(newExpression1, newExpression2);
        setOperator("#");
    }

    /**
     * this method receives two boolean variables and returns the "Xnor" between them.
     *
     * @param condition1 boolean
     * @param condition2 boolean
     * @return the result of the binary operation on the two given conditions
     */
    public Boolean operator(boolean condition1, boolean condition2) {
        return !(condition1 ^ condition2);
    }

    /**
     * this method returns a new instance of an "Xnor" binary expression.
     *
     * @param newExpression1 Expression
     * @param newExpression2 Expression
     * @return Expression the new created expression
     */
    public Expression expression(Expression newExpression1, Expression newExpression2) {
        return new Xnor(newExpression1, newExpression2);
    }

    @Override
    public Expression nandify() {
        Expression newExpression1 = new Nand(getExpression1().nandify(), getExpression1().nandify());
        Expression newExpression2 = new Nand(getExpression2().nandify(), getExpression2().nandify());
        Expression newExpression3 = new Nand(getExpression1().nandify(), getExpression2().nandify());
        return new Nand(new Nand(newExpression1, newExpression2), newExpression3);
    }

    @Override
    public Expression norify() {
        Expression ex = new Nor(getExpression1().norify(), getExpression2().norify());
        Expression newExpression1 = new Nor(getExpression1().norify(), ex);
        Expression newExpression2 = new Nor(getExpression2().norify(), ex);
        return new Nor(newExpression1, newExpression2);
    }

    @Override
    public Expression simplify() {
        Expression t = new Val(true);
        Expression f = new Val(false);
        if (getExpression1().simplify().equals(getExpression2().simplify())) {
            return t;
        } else if ((getExpression1().simplify().equals(t) && getExpression2().simplify().equals(f))
                || (getExpression1().simplify().equals(f) && getExpression2().simplify().equals(t))) {
            return f;
        }
        return new Xnor(getExpression1().simplify(), getExpression2().simplify());
    }
}
