package utils;
import java.util.Stack;

public class Transfer {
    /**
     * 
     * @param c
     * @return the priority of character c
     */
    private static int getPriority(char c) {
        switch (c) {

            case '*':
            case '/':
                return 2;

            case '+':
            case '-':
                return 1;
        }
        return -1;
    }

    /**
     * 
     * @param infix
     * @return the postfix format of the infix string
     */
    public String transfer(String infix) throws Exception {

        String res = new String("");
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < infix.length(); i++) {

            char c = infix.charAt(i);

            if (Character.isLetter(c)) {

                res += c;

            } else if (c == '(') {

                stack.push('(');

            } else if (c == ')') {

                while (!stack.isEmpty() && stack.peek() != '(') {
                    res += stack.pop();
                }

                // pop '(' after all operators are popped out.
                stack.pop();

            } else {

                // Because the popping priority of * and / is higher then + and -, as a result *
                // and / should be popped first
                while (!stack.isEmpty() && getPriority(c) <= getPriority(stack.peek())) {
                    res += stack.pop();
                }
                stack.push(c);

            }
        }
        // if something hasn't popped, pop it all out
        while (!stack.isEmpty()) {

            // check if the format is wrong
            if (stack.peek() == '(') {
                throw new Exception("Invalid infix string format");
            }
            res += stack.pop();

        }
        return res;
    }
}
