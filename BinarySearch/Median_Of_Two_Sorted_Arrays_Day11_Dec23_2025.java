//Approach : Bruteforce
// Time & Space Complexity
// Time complexity: O((n+m)log(n+m))
// Space complexity: O(n+m)
// Where n is the length of nums1 and m is the length of nums2.

public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length;
        int[] merged = new int[len1 + len2];
        System.arraycopy(nums1, 0, merged, 0, len1);
        System.arraycopy(nums2, 0, merged, len1, len2);
        Arrays.sort(merged);

        int totalLen = merged.length;
        if (totalLen % 2 == 0) {
            return (merged[totalLen / 2 - 1] + merged[totalLen / 2]) / 2.0;
        } else {
            return merged[totalLen / 2];
        }
    }
}



//Approach : Merging two sorted arrays and finding the median
// Time & Space Complexity
// Time complexity: O(m+n)
// Space complexity: O(m+n)
// Where n is the total number of values associated with a key and m is the total number of keys.

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] res = new int[m + n];
        int i = 0, j = 0, k = 0;
        while (i < m && j < n) {
            if (nums1[i] <= nums2[j]) {
                res[k] = nums1[i];
                i++;
            } else {
                res[k] = nums2[j];
                j++;
            }
            k++;
        }

        while (i < m) {
            // if(nums2[j]<=nums1[i])
            // {
            res[k] = nums1[i];
            i++;
            k++;
            //}
        }

        while (j < n) {
            // if(nums1[i]<=nums2[j])
            // {
            res[k] = nums2[j];
            j++;
            k++;
            //}
        }

        int size = m + n;
        double median = 0;
        if (size % 2 != 0) {
            median = res[size / 2];
        } else {
            System.out.println("even " + " median1 " + res[(size / 2) - 1] + " median2 " + res[size / 2]);
            //median = (res[(size / 2) - 1] + res[size / 2]) / 2;
            //Divide by 2.0
            median = (res[(size / 2) - 1] + res[size / 2]) / 2.0;
            //or cast one operand to double
            //median = ((double) res[(size / 2) - 1] + res[size / 2]) / 2;
            //or cast sum to double
            //median = ((double) (res[(size / 2) - 1] + res[size / 2])) / 2;

        }
        return median;
    }
}



//Approach : Two Pointers
// Time & Space Complexity
// Time complexity: O(m+n)
// Space complexity: O(1)
// Where n is the total number of values associated with a key and m is the total number of keys.

// Intuition
// Since both arrays are already sorted, we don’t need to fully merge them or sort again.
// We can simulate the merge process using two pointers—just like in merge sort—but only advance until we reach the middle of the combined array.

// Because the median depends only on the middle elements, we do not need to process the entire merged array.
// We simply track the last one or two values seen while merging, and once we reach the halfway point, we can compute the median.

// Algorithm
// Initialize two pointers i and j for each array.
// Iterate until you have processed (len1 + len2) // 2 + 1 elements:
// At each step, pick the smaller of the two current elements.
// Move the corresponding pointer forward.
// Track the last two picked values (median1 and median2).
// After the loop:
// If the total size is odd → return the last picked value (median1).
// If even → return the average of the last two values ((median1 + median2) / 2).

public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length;
        int i = 0, j = 0;
        int median1 = 0, median2 = 0;

        for (int count = 0; count < (len1 + len2) / 2 + 1; count++) {
            median2 = median1;
            if (i < len1 && j < len2) {
                if (nums1[i] > nums2[j]) {
                    median1 = nums2[j];
                    j++;
                } else {
                    median1 = nums1[i];
                    i++;
                }
            } else if (i < len1) {
                median1 = nums1[i];
                i++;
            } else {
                median1 = nums2[j];
                j++;
            }
        }

        if ((len1 + len2) % 2 == 1) {
            return (double) median1;
        } else {
            return (median1 + median2) / 2.0;
        }
    }
}


//(or)

//My solution for same


class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int i = 0, j = 0;
        double median1=0,median2=0;
        for(int count=0;count<(m+n)/2+1;count++)
        {
          median2=median1;
          if(i<m && j<n)
          {
            if(nums1[i]<=nums2[j])
            {
                median1=nums1[i];
                i++;
            }
            else
            {
                median1=nums2[j];
                j++;
            }
          }
          else if(i<m)
          {
             median1=nums1[i];
             i++;
          }
          else
          {
            median1=nums2[j];
            j++;
          }
          //System.out.println("i "+count+" median1 "+median1+" median2 "+median2);
        }
        
        if((m+n)%2!=0)
        {
            return median1;
        }
        else
        {
            return (median1+median2)/2.0;
        }
    }
}








//Approach :Binary Search using Partition (Optimal)
// Time & Space Complexity
// Time complexity: O(log(min(n,m)))
// Space complexity: O(1)Where n is the length of nums1 and m is the length of nums2.
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int size = (m + n);
        int leftPoolSize=(size+1)/2;
        // if (size % 2 == 0) {
        //     leftPoolSize = size / 2;
        // } else {
        //     leftPoolSize = size / 2 + 1;
        // }

        //we will perform binary search on min size array , we assume nums1 is smaller ,
        //if nums2 is smaller , swap it with num1;
        if (nums2.length < nums1.length) {
            int[] temp = nums2;
            nums2 = nums1;
            nums1 = temp;
        }

        int l = 0, r = nums1.length;
        while (l <= r) {
            int i = (l + r) / 2;
            int j = leftPoolSize - i;

            int aLeft = i > 0 ? nums1[i - 1] : Integer.MIN_VALUE;
            int aRight = i < nums1.length ? nums1[i] : Integer.MAX_VALUE;

            int bLeft = j > 0 ? nums2[j - 1] : Integer.MIN_VALUE;
            int bRight = j < nums2.length ? nums2[j] : Integer.MAX_VALUE;

            // we found correct partition
            if (aLeft <= bRight && bLeft <= aRight) {
                if (size % 2 != 0) {
                    //median will be in leftPool if size is odd, so take max of boundaries-
                    //max(aLeft,bLeft)
                    return Math.max(aLeft, bLeft);
                }
                //median will be in both leftPool and rightPool if size is even, so take the boundaries of left and right spaces , so max of leftPool and min of RightPool
                //max(aLeft,bLeft) +min(aRight,bRight)/2.0
                return (Math.max(aLeft, bLeft) + Math.min(aRight, bRight)) / 2.0;
            } else if (aLeft > bRight) {
                r = i - 1;
            } else// bLeft>aRight
            {
                l = i + 1;
            }
        }

        return -1;
    }
}