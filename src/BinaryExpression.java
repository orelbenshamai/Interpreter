import java.util.LinkedHashSet;
import java.util.Set;
import java.util.List;
import java.util.Map;

/**
 * this abstract class implements binary expression.
 * this class has the following methods:
 * constructors, get variables in the expression, evaluate the expression according to a given map
 * evaluate the expression without any given map, assign a variable to the expression and check if a given
 * expression is equal to our expression.
 *
 * @author Orel Ben Shamay 318869658
 */
public abstract class BinaryExpression extends BaseExpression {

    private Expression expression1;
    private Expression expression2;
    private String operator;

    /**
     * this method creates a new instance of a binary expression represented by two other expressions.
     *
     * @param newExpression1 Expression
     * @param newExpression2 Expression
     */
    public BinaryExpression(Expression newExpression1, Expression newExpression2) {
        this.expression1 = newExpression1;
        this.expression2 = newExpression2;
    }

    /**
     * this method sets the operator to the binary expression.
     *
     * @param newOperator String
     */
    public void setOperator(String newOperator) {
        this.operator = newOperator;
    }

    /**
     * this method returns all of the variables in the expression.
     *
     * @return List<string> a list of the variables
     */
    public List<String> getVariables() {
        List<String> list1 = expression1.getVariables();
        List<String> list2 = expression2.getVariables();
        list1.addAll(list2);
        Set<String> set = new LinkedHashSet<>(list1);
        list1.clear();
        list1.addAll(set);
        return list1;
    }

    /**
     * this method evaluates the value of a binary expression using a map which contains for every variable it's value
     * if a variable is in the expression but doesn't have any value mapped to him then the method throws an exception.
     *
     * @param assignment Map<string, Boolean> maps every variable to a boolean variable
     * @return boolean true or false
     * @throws Exception an exception if a variable in the expression doesn't have a value in the map
     */
    public Boolean evaluate(Map<String, Boolean> assignment) throws Exception {
        Boolean condition1 = this.expression1.evaluate(assignment);
        Boolean condition2 = this.expression2.evaluate(assignment);
        return operator(condition1, condition2);
    }

    /**
     * this method evaluates the value of a binary expression, if the expression contains any variables then the
     * method throws an exception.
     *
     * @return boolean true or false
     * @throws Exception an exception is thrown if a variable is found in the expression.
     */
    public Boolean evaluate() throws Exception {
        Boolean condition1 = this.expression1.evaluate();
        Boolean condition2 = this.expression2.evaluate();
        return operator(condition1, condition2);
    }

    /**
     * this method assigns a given expression to the desired variable.
     *
     * @param var String the variable name
     * @param expression Expression the wanted expression we want to assign
     * @return Expression the new expression after assigment
     */
    public Expression assign(String var, Expression expression) {
        Expression newExpression1 = this.expression1.assign(var, expression);
        Expression newExpression2 = this.expression2.assign(var, expression);
        return expression(newExpression1, newExpression2);
    }

    /**
     * this method checks if our expression equals to another expression by comparing the two expression's string
     * representation.
     *
     * @param expression Expression the expression we want to compare with
     * @return boolean true or false
     */
    public boolean equals(Expression expression) {
        return this.toString().equals(expression.toString());
    }

    /**
     * this method returns a representation of an expression as a string.
     *
     * @return String
     */
    public String toString() {
        String string;
        string = "(" + this.expression1.toString() + " " + this.getOperator() + " " + this.expression2.toString() + ")";
        return string;
    }

    /**
     * this method returns the value of a binary operation on two boolean variables.
     *
     * @param condition1 boolean
     * @param condition2 boolean
     * @return boolean the result of the binary operation on the two given arguments.
     */
    public abstract Boolean operator(boolean condition1, boolean condition2);

    /**
     * this method creates a new instance of a binary expression.
     *
     * @param newExpression1 Expression
     * @param newExpression2 Expression
     * @return Expression a new Expression
     */
    public abstract Expression expression(Expression newExpression1, Expression newExpression2);

    /**
     * returns the first expression of the binary expression.
     *
     * @return Expression
     */
    public Expression getExpression1() {
        return this.expression1;
    }

    /**
     * returns the second expression of the binary expression.
     *
     * @return Expression
     */
    public Expression getExpression2() {
        return this.expression2;
    }
    /**
     * this method returns the string the represents the operator of the binary expression.
     *
     * @return String
     */
    public String getOperator() {
        return this.operator;
    }
}
