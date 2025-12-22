//Approach : Nested Loops (Bruteforce)
// Time & Space Complexity
// Time complexity: O(n*2)
// Space complexity: O(1) extra space , O(n) for output array
public class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];

        for (int i = 0; i < n; i++) {
            int count = 1;
            int j = i + 1;
            while (j < n) {
                if (temperatures[j] > temperatures[i]) {
                    break;
                }
                j++;
                count++;
            }
            count = (j == n) ? 0 : count;
            res[i] = count;
        }
        return res;
    }
}




//Approach2. :Using Stack (Optimal)(Maintain Monotonic Stack)
// Time & Space Complexity
// Time complexity: O(n)
// Space complexity: O(n)
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<int[]> stack = new Stack<>();// stack contains int[temperature,index]
        // we have created monotonic stack
        int n = temperatures.length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            int temperature = temperatures[i];
            while (!stack.isEmpty() && temperature > stack.peek()[0]) {
                int stackPeekIndex = stack.peek()[1];
                res[stackPeekIndex] = i - stackPeekIndex;
                stack.pop();
            }
            stack.push(new int[] { temperature, i });
        }
        return res;
    }
}


//(OR)



class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<int[]> stack = new Stack<>();// stack contains int[temperature,index]
        // we have created monotonic stack
        int n = temperatures.length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            int temperature = temperatures[i];
            while (!stack.isEmpty() && temperature > stack.peek()[0]) {
                // int stackPeekIndex = stack.peek()[1];
                // res[stackPeekIndex] = i - stackPeekIndex;
                // stack.pop();
                int[] pair=stack.pop();
                res[pair[1]]=i-pair[1];
            }
            stack.push(new int[] { temperature, i });
        }
        return res;
    }
}
