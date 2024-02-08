import java.util.Scanner;
import java.util.Stack;

/**
 *  Name: Jiri Uhlir
 *  Class Group: GD2b
 */
public class CA3_Question8 {

    /*
        Reads in an equation from the user
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter equation");
        String equation = input.nextLine().trim();
        input.close();

        try{
            double result = evaluateEquation(equation);
            System.out.println("Result: " + result);
        } catch(IllegalArgumentException e){
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static double evaluateEquation(String equation){
        Stack<Integer> numbers = new Stack<>();
        Stack<Character> operators = new Stack<>();

        for(int i = 0; i < equation.length(); i++){
            char c = equation.charAt(i);

            if(Character.isDigit(c)){
                int num = 0;

                while(i < equation.length() && Character.isDigit(equation.charAt(i))){
                    num = num * 10 + (equation.charAt(i) - '0');
                    i++;
                }

                numbers.push(num);
                i--;
            }
            else if(c == '('){
                operators.push(c);
            }
            else if(c == ')'){
                while(operators.peek() != '('){
                    calculate(numbers, operators);
                }
                operators.pop();
            }
            else if(c == '-' && (i == 0 || equation.charAt(i - 1) == '(')){
                operators.push('~'); // for negation
            }
            else if(isOperator(c)){
                while(!operators.isEmpty() && precedence(operators.peek()) >= precedence(c)){
                    calculate(numbers, operators);
                }
                operators.push(c);
            }
        }

        while(!operators.isEmpty()){
            calculate(numbers, operators);
        }

        if(numbers.size() != 1){
            throw new IllegalArgumentException("Invalid expression");
        }

        return numbers.pop();
    }

    public static boolean isOperator(char c){
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    public static int precedence(char operator){
        if(operator == '+' || operator == '-'){
            return 1;
        }
        else if(operator == '*' || operator == '/'){
            return 2;
        }
        return 0;
    }

    public static void calculate(Stack<Integer> numbers, Stack<Character> operators){
        char operator = operators.pop();
        int num1;
        int num2;
        int result;

        if(operator == '~'){
            num1 = numbers.pop();
            result = -num1;
            numbers.push(result);
            return;
        }

        num2 = numbers.pop();
        num1 = numbers.pop();

        switch(operator){
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                if(num2 == 0){
                    throw new ArithmeticException("Division by zero");
                }
                result = num1 / num2;
                break;
            default:
                throw new IllegalArgumentException("Invalid operator");
        }
        numbers.push(result);
    }
}
