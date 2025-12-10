//Approach:  Bruteforce
//Time & Space Complexity
//Time complexity: O(n*2)
//Space complexity: O(1)
public class Solution {
    public int maxArea(int[] heights) {
        int res = 0;
        for (int i = 0; i < heights.length; i++) {
            for (int j = i + 1; j < heights.length; j++) {
                res = Math.max(res, Math.min(heights[i], heights[j]) * (j - i));
            }
        }
        return res;
    }
}





//Approach:   Two Pointers. (Optimal)
//Time & Space Complexity
//Time complexity: O(n)
//Space complexity: O(1)
class Solution {
    public int maxArea(int[] height) {
        int maxArea=0;
        int left=0,right=height.length-1;
        while(left<right)
        {
            int leftContainerHeight=height[left], rightContainerHeight=height[right];
            int heightStored=Math.min(leftContainerHeight,rightContainerHeight);
            int width=right-left;
            int area=heightStored*width;
            maxArea=Math.max(area,maxArea);
            if(leftContainerHeight<rightContainerHeight)
            {
                left++;
            }
            else{
                right--;
            }
        }
        return maxArea;
    }
}
