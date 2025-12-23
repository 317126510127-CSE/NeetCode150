//Approach : Binary Search
// Time & Space Complexity
// Time complexity: O(logn)
// Space complexity: O(1)
class Solution {
    public int findMin(int[] nums) {

        //Note : 
        //Because the array is sorted and rotated, at least one half of the array is always sorted.
        // The minimum element lies in the unsorted half.
        // By comparing the middle element with the rightmost element, we can decide which half contains the minimum and discard the other half.

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            //If nums[mid] > nums[right], then the minimum is in the right half, so move left = mid + 1
            //Otherwise, the minimum is in the left half (including mid), so move right = mid

            if (nums[mid] > nums[right]) { 
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left];

    }
}




//OR



class Solution {
    public int findMin(int[] nums) {

        //Note : 
        //Because the array is sorted and rotated, at least one half of the array is always sorted.
        // The minimum element lies in the unsorted half.
        // By comparing the middle element with the rightmost element, we can decide which half contains the minimum and discard the other half.

         int n = nums.length;
        int l = 0, r = n - 1;
        int Min = Integer.MAX_VALUE;

        while (l <= r) {
            int mid = (l + r) / 2;

            if (nums[mid] < nums[r]) {
                Min = Math.min(Min, nums[mid]);
                r = mid - 1;
            } else {
                Min = Math.min(Min, nums[mid]);
                l = mid + 1;
            }
        }
        return Min;

    }
}






// Intuition:
// The array is sorted but rotated.
// At any point, one half is always sorted.
// The minimum element lies at the boundary of the sorted half or inside the unsorted half.


// Strategy:
// Find the sorted half
// Store its minimum
// Move to the unsorted side


// 🚀 Approach
// Use Binary Search.
// Maintain two pointers l and r.

// While l <= r:
// Compute mid.
// If nums[mid] < nums[r]:
// Right half is sorted
// Store nums[mid]
// Move to left (unsorted) half

// Else:
// Left half is sorted
// Store nums[mid]
// Move to right (unsorted) half
// Return the stored minimum.

// ⏱️ Complexity
// Time Complexity: O(log n)
// Space Complexity: O(1)