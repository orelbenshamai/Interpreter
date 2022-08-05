import java.util.Map;
import java.util.TreeMap;

/**
 * this class is for testing the expression interface that was built for the assigment.
 *
 * @author Orel Ben Shamay 318869658
 */
public class ExpressionsTest {
    /**
     * main method.
     *
     * @param args void
     */
    public static void main(String[] args) {
        Expression ex = new And(new Var("x"), new Xor(new Var("y"), new Var("z")));
        // print the expression
        System.out.println(ex.toString());
        Map<String, Boolean> assignment = new TreeMap<>();
        assignment.put("x", true);
        assignment.put("y", false);
        assignment.put("z", true);
        try {
            System.out.println(ex.evaluate(assignment));
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        System.out.println(ex.nandify());
        System.out.println(ex.norify());
        System.out.println(ex.simplify());
    }
}
