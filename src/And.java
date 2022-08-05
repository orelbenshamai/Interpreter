/**
 * this class implements the "and" operator which is built from two expressions.
 * this class has the following methods:
 * constructors, operator method, nandify, norify and simplify.
 *
 * @author Orel Ben Shamay 318869658
 */
public class And extends BinaryExpression {

    /**
     * constructor which creates a new instance of a binary expression of type "and".
     *
     * @param newExpression1 Expression
     * @param newExpression2 Expression
     */
    public And(Expression newExpression1, Expression newExpression2) {
        super(newExpression1, newExpression2);
        setOperator("&");
    }

    /**
     * this method receives two boolean variables and returns the "and" between them.
     *
     * @param condition1 boolean
     * @param condition2 boolean
     * @return the result of the binary operation on the two given conditions
     */
    public Boolean operator(boolean condition1, boolean condition2) {
        Expression f = new Val(false);
        if (this.getExpression1().equals(f) || this.getExpression2().equals(f)) {
            return false;
        }
        return condition1 && condition2;
    }

    /**
     * this method returns a new instance of an "and" binary expression.
     *
     * @param newExpression1 Expression
     * @param newExpression2 Expression
     * @return Expression the new created expression
     */
    public Expression expression(Expression newExpression1, Expression newExpression2) {
        return new And(newExpression1, newExpression2);
    }

    @Override
    public Expression nandify() {
        Expression newExpression1 = new Nand(getExpression1().nandify(), getExpression2().nandify());
        Expression newExpression2 = new Nand(getExpression1().nandify(), getExpression2().nandify());
        return new Nand(newExpression1, newExpression2);
    }

    @Override
    public Expression norify() {
        Expression newExpression1 = new Nor(getExpression1().norify(), getExpression1().norify());
        Expression newExpression2 = new Nor(getExpression2().norify(), getExpression2().norify());
        return new Nor(newExpression1, newExpression2);
    }

    @Override
    public Expression simplify() {
        Expression f = new Val(false);
        Expression t = new Val(true);
        Expression simplified1 = getExpression1().simplify();
        Expression simplified2 = getExpression2().simplify();
        if (simplified1.equals(f) || simplified2.equals(f)) {
            return f;
        } else if (simplified1.equals(simplified2) || simplified2.equals(t)) {
            return simplified1;
        } else if (simplified1.equals(t)) {
            return simplified2;
        }
        return new And(simplified1, simplified2);
    }
}
