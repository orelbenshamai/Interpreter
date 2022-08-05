import java.util.Map;
import java.util.List;

/**
 * interface of an expression, which contains the following methods:
 * evaluate an expression with a given map, evaluate an expression without a map, get all of the variables
 * in the expression, get a representation of an expression as a string, assign a given expression to a
 * variable in the expression, norify an expression, nandify an expression, simplify an expression and check
 * if two expressions are equal.
 *
 * @author Orel Ben Shamay
 */
public interface Expression {
    /**
     * Evaluate the expression using the variable values provided in the assignment and return the result.
     * If the expression contains a variable which is not in the assignment, an exception is thrown.
     *
     * @param assignment Map<String, Boolean>
     * @return boolean true or false
     * @throws Exception an exception if a variable in the expression doesn't have a value in the map.
     */
    Boolean evaluate(Map<String, Boolean> assignment) throws Exception;
    /**
     * a convenience method. Like the `evaluate(assignment)` method above, but uses an empty assignment.
     *
     * @return boolean true or false
     * @throws Exception an exception if a variable in the expression doesn't have a value in the map.
     */
    Boolean evaluate() throws Exception;

    /**
     * Returns a list of the variables in the expression.
     *
     * @return List<string>
     */
    List<String> getVariables();

    /**
     * Returns a nice string representation of the expression.
     *
     * @return String
     */
    String toString();

    /**
     * Returns a new expression in which all occurrences of the variable var are replaced with the provided expression
     * (Does not modify the current expression).
     *
     * @param var String the variable we want to be replaced
     * @param expression Expression the expression we want to assign
     * @return Expression the new modified expression
     */
    Expression assign(String var, Expression expression);

    /**
     * Returns the expression tree resulting from converting all the operations to the logical nand operation.
     *
     * @return Expression the new modified expression
     */
    Expression nandify();

    /**
     * Returns the expression tree resulting from converting all the operations to the logical nor operation.
     *
     * @return Expression the new modified expression
     */
    Expression norify();

    /**
     * Returned a simplified version of the current expression.
     *
     * @return Expression the new modified expression
     */
    Expression simplify();

    /**
     * this method checks if two expressions are equal.
     *
     * @param expression the second expression to be compared with.
     * @return boolean true or false
     */
    boolean equals(Expression expression);

}
