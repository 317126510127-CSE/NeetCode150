//Approach : Recursive Solution 
// Time & Space Complexity
// Time complexity: O(logn)
// Space complexity: O(logn)

public class Solution {
    public int binary_search(int l, int r, int[] nums, int target) {
        if (l > r) return -1;
        int m = l + (r - l) / 2;

        if (nums[m] == target) return m;
        return (nums[m] < target) ?
            binary_search(m + 1, r, nums, target) :
            binary_search(l, m - 1, nums, target);
    }

    public int search(int[] nums, int target) {
        return binary_search(0, nums.length - 1, nums, target);
    }
}



//Approach: Iterative Binary Search
// Time & Space Complexity
// Time complexity: O(logn)
// Space complexity: O(1)

class Solution {
    public int search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            //int mid = left + (right - left) / 2; // calculate the middle index of the array
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] <= target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}


//Approach: Using Built In Function
// Time & Space Complexity
// Time complexity: O(logn)
// Space complexity: O(1)
public class Solution {
    public int search(int[] nums, int target) {
        int index = Arrays.binarySearch(nums, target);
        return index >= 0 ? index : -1;
    }
}