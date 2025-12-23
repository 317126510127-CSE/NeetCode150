//Approach : Recursive Solution 
// Time & Space Complexity
// Time complexity: O(logn)
// Space complexity: O(1)

class Solution {
    public int search(int[] nums, int target) {
        int left=0,right=nums.length-1;
        while(left<=right)
        {
            int mid=left+(right-left)/2;
            if(nums[mid]==target)
            {
                return mid;
            }
            else if(nums[mid]>=nums[left])
            {
                //left space is strictly increasing
                if(target>=nums[left] && target<=nums[mid])
                {
                    right=mid-1;
                }
                else
                {
                    left=mid+1;
                }
            }
            else 
            {
                 //right space is strictly increasing
                 if(target>=nums[mid] && target<=nums[right])
                {
                    left=mid+1;
                }
                else
                {
                    right=mid-1;
                }
            }
        }
        return -1;
    }
}






// Intuition
// When an array is rotated and sorted, one part of the array is always sorted, and the other part contains the pivot (the rotated part).
// Using this observation, we can decide which side to eliminate using binary search.

// At any index mid:

// Either the left half is sorted
// Or the right half is sorted
// If the target lies inside the sorted half, we move towards that half.
// Otherwise, we move towards the unsorted half.

// This allows us to search in O(log n) time.

// Approach
// Use two pointers: start and end.

// Calculate mid.

// If nums[mid] == target, return the index directly.

// Determine which half is sorted:

// If nums[mid] > nums[end], left half is sorted.
// Else, right half is sorted.
// Check if the target lies inside the sorted half:

// If yes → move towards that side.
// Else → move towards the other side.
// Continue until start > end.

// If not found, return -1.

// Complexity
// Time Complexity:
// O(log n) — because we use binary search.

// Space Complexity:
// O(1) — no extra data structures used.

// Code:
// class Solution {
//     public int search(int[] nums, int target) {
//         int start = 0, end = nums.length - 1;

//         while (start <= end) {
//             int mid = start + (end - start) / 2;

//             if (nums[mid] == target) return mid;

//             // Check if left part is sorted
//             if (nums[mid] >= nums[start]) {
//                 if (target >= nums[start] && target < nums[mid]) {
//                     end = mid - 1; // move left
//                 } else {
//                     start = mid + 1; // move right
//                 }
//             } 
//             // Right part is sorted
//             else {
//                 if (target > nums[mid] && target <= nums[end]) {
//                     start = mid + 1; // move right
//                 } else {
//                     end = mid - 1; // move left
//                 }
//             }
//         }

//         return -1;
//     }
// }