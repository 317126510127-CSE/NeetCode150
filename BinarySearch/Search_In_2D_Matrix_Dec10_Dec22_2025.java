//Approach : Bruteforce
// Time & Space Complexity
// Time complexity: O(m*n)
// Space complexity: O(1)
//Where m is the number of rows and n is the number of columns of matrix.

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                if (matrix[r][c] == target) {
                    return true;
                }
            }
        }
        return false;
    }
}

//Approach : Staircase Search
// Time & Space Complexity
// Time complexity: O(m+n)
// Space complexity: O(1)
//Where m is the number of rows and n is the number of columns of matrix.

//Approach:

// Since each row is sorted left-to-right and each column is sorted top-to-bottom, we can search smartly instead of checking every cell.

// Start at the top-right corner:

// If the current value is greater than the target → move left (values decrease).
// If it is smaller than the target → move down (values increase).
// This works like walking down a staircase—each step eliminates an entire row or column.
// We keep moving until we either find the target or move out of bounds.


// Algorithm
// Let r = 0 (first row) and c = n - 1 (last column).
// While r is within bounds and c is within bounds:
// If matrix[r][c] == target, return True.
// If the value is greater than the target, move left (c -= 1).
// If the value is smaller, move down (r += 1).
// If we exit the matrix, the target is not found → return False.


public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int r = 0, c = n - 1;

        while (r < m && c >= 0) {
            if (matrix[r][c] > target) {
                c--;
            } else if (matrix[r][c] < target) {
                r++;
            } else {
                return true;
            }
        }
        return false;
    }
}




//Approach : Binary Search (Optimal). (MY SOLUTION)
// Time & Space Complexity
// Time complexity: O(log(m*n))
// Space complexity: O(1)
//Where m is the number of rows and n is the number of columns of matrix.


class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows=matrix.length, cols=matrix[0].length;
        int low=0, high=rows*cols-1;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            int row=mid/cols;
            int col=mid%cols;
            if(matrix[row][col]==target)
            {
                return true;
            }
            else if(matrix[row][col]<target)
            {
                low=mid+1;
            }
            else
            {
              high=mid-1;
            }
        }
        return false;
    }
}





//(OR)



public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int ROWS = matrix.length, COLS = matrix[0].length;

        int l = 0, r = ROWS * COLS - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            int row = m / COLS, col = m % COLS;
            if (target > matrix[row][col]) {
                l = m + 1;
            } else if (target < matrix[row][col]) {
                r = m - 1;
            } else {
                return true;
            }
        }
        return false;
    }
}






// Problem Understanding
// The task is to find a target integer in a 2D matrix with the following properties:

// Each row is sorted in non-decreasing order.
// The first integer of each row is greater than the last integer of the previous row.
// The challenge is to determine if the target integer exists within the matrix.

// Approach
// Given the problem, it may be tempting to perform a linear search through the entire matrix, but this would result in a time complexity of O(m×n), 
// which is not acceptable given the problem's constraint of O(log(m×n)).

// Instead, we can leverage the fact that the matrix is sorted both row-wise and column-wise, and apply a binary search to find the target.

// Live Coding & Explenation


// Treating the Matrix as a 1-Dimensional Array
// To apply binary search, we need a one-dimensional array. We can treat our 2-D matrix as a one-dimensional array because of the matrix's sorted property.
//  The first integer of each row is greater than the last integer of the previous row, so we can think of the rows as being appended one after the other to form a single sorted array.

// Binary Search
// Binary search is a search algorithm that finds the position of a target value within a sorted array. It compares the target value to the middle element of the array.
//  If they are not equal, the half in which the target cannot lie is eliminated, and the search continues on the remaining half until it is successful or the remaining half is empty.

// Initialization
// Before we start the binary search, we need to initialize two pointers:

// left - This represents the start of the array. We set this to 0 (the index of the first element).
// right - This represents the end of the array. We set this to m * n - 1 (the index of the last element), where m and n are the number of rows and columns in the matrix, respectively.
// Iterative Binary Search
// We perform a binary search iteratively within a while loop until left exceeds right. In each iteration, we calculate the midpoint between left and right.

// To get the row and column of the midpoint in the matrix, we use the divmod function with mid and n. 
// The divmod function takes two numbers and returns a pair of numbers (a tuple) consisting of their quotient and remainder.

// We then compare the value at the midpoint with the target:

// If the midpoint value is equal to the target, we have found the target in the matrix, and we return True.
// If the midpoint value is less than the target, this means the target must be in the right half of the array. So, we adjust left to be mid + 1.
// If the midpoint value is greater than the target, this means the target must be in the left half of the array. So, we adjust right to be mid - 1.
// If we exit the while loop, that means we did not find the target in the matrix, so we return False.

// Complexity
// Time Complexity
// The time complexity is O(log(m×n)), since we're effectively performing a binary search over the m×n elements of the matrix.

// Space Complexity
// The space complexity is O(1) because we only use a constant amount of space to store our variables (left, right, mid, mid_value), regardless of the size of the input matrix.

