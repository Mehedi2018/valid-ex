
package validexpression;
import java.util.Scanner;
import java.util.Stack;

public class ValidExpression{
    
    public static void main(String[] args) {
     
     Scanner in = new Scanner(System.in);
     String str = in.nextLine();
 
     boolean b = isValidExpression(str);
        if (b) {
            System.out.println("valid");
        } else {
            System.out.println("invalid");
        }
     
    }
    
    
  public static boolean isAnOperator(char c){
        return (c == '*' || c == '/' || c == '+' || c == '-' || c == '%');
    }
    
    private static boolean isValidExpression(String expression){
      
        expression = expression.replaceAll("\\s+", "");
       
        if (isAnOperator(expression.charAt(0)) || isAnOperator(expression.charAt(expression.length()-1)))
            return false;
        
        int unclosedParenthesis = 0;
        

        for (int i = 0; i < expression.length(); i++){
            
            if (expression.charAt(i) == '('){
                
                unclosedParenthesis++; 

             
                if (i == expression.length()-1) return false;
            }
            if (expression.charAt(i) == ')'){
                unclosedParenthesis--;
               
                if (i == 0) return false;

            }
            if (isAnOperator(expression.charAt(i))){

                if (expression.charAt(i-1) == '(' || expression.charAt(i+1) == ')' || isAnOperator(expression.charAt(i+1))){
                    
                    return false; 
                }

            }

        }
        return (unclosedParenthesis == 0);
    }
}

