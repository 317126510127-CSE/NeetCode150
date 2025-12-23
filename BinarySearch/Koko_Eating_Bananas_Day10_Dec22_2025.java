//Approach : Bruteforce
// Time & Space Complexity
// Time complexity: O(n*Max(n))
// Space complexity: O(1)
class Solution {
    public long calculateHours(int[] piles,int eatingSpeed)
    {
        long totalHours=0;
        for(int pile:piles)
        {
            //below is ceil division , we can also do (pile+eatingSpeed-1)/eatingSpeed;
            //totalHours+=(pile+eatingSpeed-1)/eatingSpeed;
            totalHours+=pile/eatingSpeed;
            if(pile%eatingSpeed!=0) totalHours++;
        }
        return totalHours;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int max=Integer.MIN_VALUE;
        for(int pile:piles)
        {
          max=Math.max(pile,max);
        }
        int ans=1;
        for(int i=1;i<=max;i++)
        {
            long hrs=calculateHours(piles,i);
            if(hrs<=h)
            {
                ans=i;
                break;
            }
        }
        return ans;
    }
}





//Approach : Binary Search (Optimal)
// Time & Space Complexity
// Time complexity: O(n*log(Max(n)))
// Space complexity: O(1)
class Solution {
    public long calculateHours(int[] piles, int eatingSpeed) {
        long totalHours = 0;
        for (int pile : piles) {
            //below is ceil division , we can also do (pile+eatingSpeed-1)/eatingSpeed;
            totalHours+=(pile+eatingSpeed-1)/eatingSpeed;
            // totalHours += pile / eatingSpeed;
            // if (pile % eatingSpeed != 0)
            //     totalHours++;
        }
        return totalHours;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int high = 0;
        for (int pile : piles) {
            high = Math.max(high, pile);
        }
        int low = 1, ans = 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            long hrs = calculateHours(piles, mid);
            if (hrs <= h) {
                ans = mid;
                //save mid and try less than it
                //eliminate right space
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
        //or return low
        //At first-> low(1) is not possible , high(maxOfN) is possible
        //while loop breaks , it becomes high>low.
        //high would be in not possible and low would be in possible , so return low
    }
}





// Intuition
// The problem requires finding the minimum eating speed where Koko can finish all bananas within h hours.
//  Since we need to find a minimum value that satisfies a condition, binary search is ideal. We can binary search on the eating speed (k), 
// where the search space ranges from 1 (minimum possible speed) to the maximum pile size (eating faster than the largest pile is unnecessary).

// Approach
// Define Search Space: Set the binary search range from start = 1 to end = max(piles)
// Binary Search on Speed: For each mid value (potential eating speed), check if Koko can finish all bananas within h hours
// Validation Function: countingHours() calculates total hours needed at speed k:
// For each pile, calculate ceil(pile/k) hours needed
// If total hours ≤ h, this speed works
// Optimize: If a speed works, try slower speeds (search left); otherwise, try faster speeds (search right)
// Result: The answer is the minimum valid eating speed found
// Complexity
// Time complexity: O(nlogm)

// Where n = number of piles, m = maximum pile size
// Binary search runs in O(logm) iterations
// Each iteration validates with countingHours() in O(n)
// Space complexity: O(1)

// Only using constant extra space for variables