/**
 * this class implements the "Xor" operator which is built from two expressions.
 * this class has the following methods:
 * constructors, operator method, nandify, norify and simplify.
 *
 * @author Orel Ben Shamay 318869658
 */
public class Xor extends BinaryExpression {

    /**
     * constructor which creates a new instance of a binary expression of type "Xor".
     *
     * @param newExpression1 Expression
     * @param newExpression2 Expression
     */
    public Xor(Expression newExpression1, Expression newExpression2) {
        super(newExpression1, newExpression2);
        setOperator("^");
    }

    /**
     * this method receives two boolean variables and returns the "Xor" between them.
     *
     * @param condition1 boolean
     * @param condition2 boolean
     * @return the result of the binary operation on the two given conditions
     */
    public Boolean operator(boolean condition1, boolean condition2) {
        return condition1 ^ condition2;
    }

    /**
     * this method returns a new instance of an "Xor" binary expression.
     *
     * @param newExpression1 Expression
     * @param newExpression2 Expression
     * @return Expression the new created expression
     */
    public Expression expression(Expression newExpression1, Expression newExpression2) {
        return new Xor(newExpression1, newExpression2);
    }

    @Override
    public Expression nandify() {
        Expression ex = new Nand(getExpression1().nandify(), getExpression2().nandify());
        Expression newExpression1 = new Nand(getExpression1().nandify(), ex);
        Expression newExpression2 = new Nand(getExpression2().nandify(), ex);
        return new Nand(newExpression1, newExpression2);
    }

    @Override
    public Expression norify() {
        Expression newExpression1 = new Nor(getExpression1().norify(), getExpression1().norify());
        Expression newExpression2 = new Nor(getExpression2().norify(), getExpression2().norify());
        Expression newExpression3 = new Nor(getExpression1().norify(), getExpression2().norify());
        return new Nor(new Nor(newExpression1, newExpression2), newExpression3);

    }

    @Override
    public Expression simplify() {
        Expression f = new Val(false);
        Expression t = new Val(true);
        Expression simplified1 = getExpression1().simplify();
        Expression simplified2 = getExpression2().simplify();
        if (simplified1.equals(simplified2)) {
            return f;
        } else if (simplified2.equals(t)) {
            return new Not(simplified1).simplify();
        } else if (simplified1.equals(t)) {
            return new Not(simplified2).simplify();
        } else if (simplified2.equals(f)) {
            return simplified1;
        } else if (simplified1.equals(f)) {
            return simplified2;
        }
        return new Xor(simplified1, simplified2);
    }
}
