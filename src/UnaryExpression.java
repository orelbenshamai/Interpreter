/**
 * this class implements an unary expression.
 *
 * @author Orel Ben Shamay 318869658
 */
public abstract class UnaryExpression extends BaseExpression {

    private Expression expression;

    /**
     * constructor which creates a new instance of an unary expression.
     *
     * @param newExpression Expression
     */
    public UnaryExpression(Expression newExpression) {
        this.expression = newExpression;
    }

    /**
     * returns the expression of the unary expression.
     *
     * @return Expression
     */
    public Expression getExpression() {
        return this.expression;
    }
}
