//Approach : Nested Loops (Bruteforce)
// Time & Space Complexity
// Time complexity: O(n*2)
// Space complexity: O(n)
public class Solution {
    public int evalRPN(String[] tokens) {
        List<String> tokenList = new ArrayList<>(Arrays.asList(tokens));

        while (tokenList.size() > 1) {
            for (int i = 0; i < tokenList.size(); i++) {
                String token = tokenList.get(i);

                if ("+-*/".contains(token)) {
                    int a = Integer.parseInt(tokenList.get(i - 2));
                    int b = Integer.parseInt(tokenList.get(i - 1));
                    int result = 0;

                    if (token.equals("+")) {
                        result = a + b;
                    } else if (token.equals("-")) {
                        result = a - b;
                    } else if (token.equals("*")) {
                        result = a * b;
                    } else if (token.equals("/")) {
                        result = a / b;
                    }

                    tokenList.set(i - 2, String.valueOf(result));
                    tokenList.remove(i);
                    tokenList.remove(i - 1);
                    break;
                }
            }
        }
        return Integer.parseInt(tokenList.get(0));
    }
}




//Approach:Using Stack (Optimal)
// Time & Space Complexity
// Time complexity: O(n)
// Space complexity: O(n)

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String c : tokens) {
            //if token is an arithmetic operator
            if (c.equals("+")) {
                stack.push(stack.pop() + stack.pop());
            } else if (c.equals("-")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b - a);
            } else if (c.equals("*")) {
                stack.push(stack.pop() * stack.pop());
            } else if (c.equals("/")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b / a);
            } else {
                 //if token is a number
                stack.push(Integer.parseInt(c));
            }
        }
        return stack.pop();
    }
}

  

  //OR





class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            //if token is an arithmetic operator
            if ("+-*/".contains(token)) {
                int topSecond = stack.pop();
                int top = stack.pop();
                switch (token) {
                    case "+":
                        stack.push(top + topSecond);
                        break;
                    case "-":
                        stack.push(top - topSecond);
                        break;
                    case "*":
                        stack.push(top * topSecond);
                        break;
                    case "/":
                        stack.push(top / topSecond);
                        break;
                }
            } else {
                //if token is a number
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
}





