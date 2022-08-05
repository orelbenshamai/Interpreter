/**
 * this class implements the "Nor" operator which is built from two expressions.
 * this class has the following methods:
 * constructors, operator method, nandify, norify and simplify.
 *
 * @author Orel Ben Shamay 318869658
 */
public class Nor extends BinaryExpression {

    /**
     * constructor which creates a new instance of a binary expression of type "Nor".
     *
     * @param newExpression1 Expression
     * @param newExpression2 Expression
     */
    public Nor(Expression newExpression1, Expression newExpression2) {
        super(newExpression1, newExpression2);
        setOperator("V");
    }

    /**
     * this method receives two boolean variables and returns the "Nor" between them.
     *
     * @param condition1 boolean
     * @param condition2 boolean
     * @return the result of the binary operation on the two given conditions
     */
    public Boolean operator(boolean condition1, boolean condition2) {
        return !(condition1 || condition2);
    }

    /**
     * this method returns a new instance of an "Nor" binary expression.
     *
     * @param newExpression1 Expression
     * @param newExpression2 Expression
     * @return Expression the new created expression
     */
    public Expression expression(Expression newExpression1, Expression newExpression2) {
        return new Nor(newExpression1, newExpression2);
    }

    @Override
    public Expression nandify() {
        Expression newExpression1 = new Nand(getExpression1().nandify(), getExpression1().nandify());
        Expression newExpression2 = new Nand(getExpression2().nandify(), getExpression2().nandify());
        return new Nand(new Nand(newExpression1, newExpression2), new Nand(newExpression1, newExpression2));
    }

    @Override
    public Expression norify() {
        return new Nor(getExpression1().norify(), getExpression2().norify());
    }

    @Override
    public Expression simplify() {
        Expression f = new Val(false);
        Expression t = new Val(true);
        Expression simplified1 = getExpression1().simplify();
        Expression simplified2 = getExpression2().simplify();
        if (simplified1.equals(simplified2)) {
            return new Not(simplified1).simplify();
        } else if (simplified2.equals(f)) {
            return new Not(simplified1).simplify();
        } else if (simplified1.equals(f)) {
            return new Not(simplified2).simplify();
        } else if (simplified1.equals(t) || simplified2.equals(t)) {
            return f;
        }
        return new Nor(simplified1, simplified2);
    }
}
