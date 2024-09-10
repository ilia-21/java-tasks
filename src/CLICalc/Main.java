package CLICalc;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        System.out.print(">");
        Scanner scan = new Scanner(System.in);
        String equation = scan.nextLine();
        String regex = "(\\d*\\.?\\d*)\\s*([+\\-*/])\\s*(\\d*\\.?\\d*)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(equation);
        float result = 0;
        if (matcher.matches()) {
            float num1 = Float.parseFloat(matcher.group(1));
            String operator = matcher.group(2);
            float num2 = Float.parseFloat(matcher.group(3));
            if(operator.equals("/") && num2==0){
                System.out.println("На ноль делить нельзя");
                System.exit(1);
            }
            switch (operator){
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case ":":
                case "/":
                    result = (float) num1 / num2;
                    break;
                case "*":
                    result = num1 * num2;
                    break;
                default:
                    System.out.println("Эта операция не поддерживается");
                    System.exit(0);
                    break;
            }
            System.out.print("=");
            //check if there's no decimals
            if(result%1==0){
                System.out.print((int)result);
            } else {
                System.out.print(result);
            }
        } else {
            System.out.println("Это не математическая операция");
        }
    }
}
