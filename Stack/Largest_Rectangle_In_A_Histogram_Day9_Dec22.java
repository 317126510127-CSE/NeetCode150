//Approach :Using Stack
// Time & Space Complexity
// Time complexity: O(n)
// Space complexity: O(n)
class Solution {
    public int largestRectangleArea(int[] heights) {

        //Note1: Atleast 1 bar will be included in a rectangle
        //So ,firstly 
        //1)we will include each bar to find a rectangle
        //2)we will find the nearest left element< current height
        //3)we will find the nearest right element<current heigght
        //4)now we will find the area of the rectangle of the included bar using left and right
        //5)we will find out all areas and return the heighest

        Stack<Integer> stack = new Stack<>();

        int maxRectangleArea = 0;
        int n = heights.length;
        int[] leftMinIndex = new int[n];
        //find nearest left minimum for each Element else 0
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                leftMinIndex[i] = 0;
            } else {
                leftMinIndex[i] = stack.peek() + 1;
            }
            stack.push(i);
        }

        int[] rightMinIndex = new int[n];
        //find nearest left minimum for each Element else n-1
        stack.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                rightMinIndex[i] = n - 1;
            } else {
                rightMinIndex[i] = stack.peek() - 1;
            }
            stack.push(i);
        }

        //calculate area for including each ele using leftMin and rightMin Indexes
        for (int i = 0; i < n; i++) {
            //calculate area of rectangle- (width)*(height)
            //width - (right-left+1)
            //height - (height[i])
            int area = (rightMinIndex[i] - leftMinIndex[i] + 1) * heights[i];
            //System.out.println("i " + i + " left " + leftMinIndex[i] + " right " + rightMinIndex[i]);
            maxRectangleArea = Math.max(maxRectangleArea, area);
        }
        return maxRectangleArea;

    }
}