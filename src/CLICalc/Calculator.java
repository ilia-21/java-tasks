package CLICalc;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    boolean exit = false;
    static void calculator() {
        System.out.print(">");
        Scanner scan = new Scanner(System.in);
        String equation = scan.nextLine();
        if(equation.equals("q")) System.exit(0);
        String regex = "(log|sin|ln|cos)?\\s*(\\d*\\.?\\d*)\\s*([+\\-*/])?\\s*(\\d*\\.?\\d*)?";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(equation);
        double result = 0;
        if (matcher.matches()) {
            String function = matcher.group(1);
            double num1 = matcher.group(2).isEmpty() ? 0 : Double.parseDouble(matcher.group(2));
            String operator = matcher.group(3);
            double num2 = matcher.group(4) == null || matcher.group(4).isEmpty() ? 0 : Double.parseDouble(matcher.group(4));

            if (function != null) {
                switch (function) {
                    case "log":
                        result = Math.log10(num1);
                        break;
                    case "sin":
                        result = Math.sin(Math.toRadians(num1));
                        break;
                    case "ln":
                        result = Math.log(num1);
                        break;
                    case "cos":
                        result = Math.cos(Math.toRadians(num1));
                        break;
                }
            } else if (operator != null) {
                if (operator.equals("/") && num2 == 0) {
                    System.out.println("You can't divide by 0");
                    return;
                }
                switch (operator) {
                    case "+":
                        result = num1 + num2;
                        break;
                    case "-":
                        result = num1 - num2;
                        break;
                    case ":":
                    case "/":
                        result = num1 / num2;
                        break;
                    case "*":
                        result = num1 * num2;
                        break;
                    default:
                        System.out.println("This operation is not supported");
                        return;
                }
            } else {
                result = num1;
            }
            System.out.print("=");
            //check if there's no decimals
            if (result % 1 == 0) {
                System.out.println((int) result);
            } else {
                System.out.println(result);
            }
        } else {
            System.out.println("This is not a math equation!");
        }
    }
    public static void main(String[] args) {
        System.out.println("Enter math equation or type q to exit");
        while (true){
            calculator();
        }
    }
}