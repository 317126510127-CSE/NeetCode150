Approach: Bruteforce (Nested Loops)
//Time & Space Complexity
//Time complexity: O(n*2)
//Space complexity: O(1)
public class Solution {
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int n = height.length;
        int res = 0;

        for (int i = 0; i < n; i++) {
            int leftMax = height[i];
            int rightMax = height[i];

            for (int j = 0; j < i; j++) {
                leftMax = Math.max(leftMax, height[j]);
            }
            for (int j = i + 1; j < n; j++) {
                rightMax = Math.max(rightMax, height[j]);
            }

            res += Math.min(leftMax, rightMax) - height[i];
        }
        return res;
    }
}


//Approach:   Two Pointers. (calculate leftmax and rightMax arrays) (Prefix and suffix arrays)
//Time & Space Complexity
//Time complexity: O(n)
//Space complexity: O(n)

class Solution {
    public int trap(int[] height) {
        int len = height.length;
        if (len <= 2) {
            return 0;
        }
        int[] leftMax = new int[len];
        int[] rightMax = new int[len];

        leftMax[0] = 0;
        int leftMaxHeight = height[0];
        for (int i = 1; i < len; i++) {
            leftMax[i] = leftMaxHeight;
            if (height[i] > leftMaxHeight) {
                leftMaxHeight = height[i];
            }
        }

        rightMax[len - 1] = 0;
        int rightMaxHeight = height[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            rightMax[i] = rightMaxHeight;
            if (height[i] > rightMaxHeight) {
                rightMaxHeight = height[i];
            }
        }

        int totalWater = 0;
        int i = 1, j = len - 1;
        while (i <= j) {
            int minHeightOfBoundaries = Math.min(leftMax[i], rightMax[i]);
            if (minHeightOfBoundaries > height[i]) {
                totalWater += (minHeightOfBoundaries - height[i]);
            }
            i++;
        }
        return totalWater;
    }
}




//Approach:   Two Pointers
//Time & Space Complexity
//Time complexity: O(n)
//Space complexity: O(1)

class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int left = 0, right = n-1;
        int leftMax = 0, rightMax = 0;
        int res = 0;
        while (left <= right) {
            if (height[left] <= height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    res += leftMax - height[left];
                }
                left++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    res += rightMax - height[right];
                }
                right--;
            }
        }
        return res;
    }
}