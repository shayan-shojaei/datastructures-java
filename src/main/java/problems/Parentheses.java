package problems;

import java.util.Stack;

public class Parentheses {
    public static void main(String[] args) {
        String balancedTest = "([]{})";
        String unbalancedTest = "[{}()}]";
        System.out.println(validate(balancedTest));
        System.out.println(validate(unbalancedTest));
    }

    public static boolean validate(String expression) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < expression.length(); i++) {
            char x = expression.charAt(i);

            if (x == '(' || x == '[' || x == '{') {
                stack.push(x);
                continue;
            }

            if (stack.isEmpty())
                return false;

            char check;
            switch (x) {
                case ')' -> {
                    check = stack.pop();
                    if (check == '{' || check == '[')
                        return false;
                }
                case '}' -> {
                    check = stack.pop();
                    if (check == '(' || check == '[')
                        return false;
                }
                case ']' -> {
                    check = stack.pop();
                    if (check == '(' || check == '{')
                        return false;
                }
            }

        }
        return stack.isEmpty();
    }
}
