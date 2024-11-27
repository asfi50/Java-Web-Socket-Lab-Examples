package intermediate.lab2;

import java.util.StringTokenizer;

public class EqnSolver {
    public static int eval(String eqn) {
        int result = 0; 
        StringTokenizer stringTokenizer = new StringTokenizer(eqn); 
        
        // Initialize result with the first number
        if (stringTokenizer.hasMoreTokens()) {
            result = Integer.parseInt(stringTokenizer.nextToken());
        }
        
        // Process the remaining tokens
        while (stringTokenizer.hasMoreTokens()) {
            String operator = stringTokenizer.nextToken(); // Operator (e.g., +, -, *, /)
            int operand = Integer.parseInt(stringTokenizer.nextToken()); // Next number
            
            // Perform the operation
            if (operator.equals("+")) {
                result += operand;
            } else if (operator.equals("-")) {
                result -= operand;
            }else if (operator.equals("*")) {
                result *= operand;
            }else if (operator.equals("/")) {
                result /= operand;
            }
            else {
                throw new IllegalArgumentException("Unsupported operator: " + operator);
            }
        }
        
        return result;
    }
}
