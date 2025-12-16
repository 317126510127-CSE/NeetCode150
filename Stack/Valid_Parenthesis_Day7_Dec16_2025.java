//Approach : Using Stack 
// Time & Space Complexity
// Time complexity: O(n)
// Space complexity: O(n)
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (Character ch : s.toCharArray()) {
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else if (ch == ')' || ch == '}' || ch == ']') {
                if (stack.isEmpty()) {
                    return false;
                }
                Character topCharacterInStack = stack.pop();
                if ((ch == ')' && topCharacterInStack != '(') || (ch == '}' && topCharacterInStack != '{')
                        || (ch == ']' && topCharacterInStack != '[')) {
                    return false;
                }
            }

        }
        return stack.isEmpty();
    }
}



//OR 

//Approach : Using Stack  and Map
// Time & Space Complexity
// Time complexity: O(n)
// Space complexity: O(n)

public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> closeToOpen = new HashMap<>();
        closeToOpen.put(')', '(');
        closeToOpen.put(']', '[');
        closeToOpen.put('}', '{');

        for (char c : s.toCharArray()) {
            if (closeToOpen.containsKey(c)) {
                if (!stack.isEmpty() && stack.peek() == closeToOpen.get(c)) {
                    stack.pop();
                } else {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}