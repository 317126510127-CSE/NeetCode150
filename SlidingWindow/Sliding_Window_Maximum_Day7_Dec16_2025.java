//Approach: Nested Loops (Bruteforce)
//Time & Space Complexity
//Time complexity: O(n*k)
//Space complexity: 
//  .O(1) extra space.
//  .O(n−k+1) space for the output array.
//Where n is the length of the array and k is the size of the window.
public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] output = new int[n - k + 1];

        for (int i = 0; i <= n - k; i++) {
            int maxi = nums[i];
            for (int j = i; j < i + k; j++) {
                maxi = Math.max(maxi, nums[j]);
            }
            output[i] = maxi;
        }

        return output;
    }
}



//Approach: Using Priority Queue (MaxHeap)
//Time & Space Complexity
//Time complexity: O(n*logn)
//Space complexity: O(n)

public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n == 0 || k == 0) return new int[0];
        int[] output = new int[n - k + 1];
        int index=0;
        PriorityQueue<int[]> heap=new PriorityQueue<>((a,b)->b[0]-a[0]);
        for(int i=0;i<n;i++)
        {
            heap.offer(new int[]{nums[i],i});
            //check from the the first window from k elements index
            if(i>=k-1)
            {
                //if the max element index is not in the window, remove it from priorityQueue
                while(heap.peek()[1]<=(i-k))
                {
                    heap.poll();
                }
                output[index++]=heap.peek()[0];
            }
        }

        return output;
    }
}



//Approach: Using Deque(Optimal)
//Time & Space Complexity
//Time complexity: O(n)
//Space complexity: O(1)

public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n == 0 || k == 0)
            return new int[0];
        int[] output = new int[n - k + 1];
        int index = 0;
        Deque<Integer> dq = new ArrayDeque<>();//stores indices
        for (int i = 0; i < n; i++) {
            //remove indices which are out of bound of window
            while (!dq.isEmpty() && dq.peekFirst() <= (i - k)) {
                dq.pollFirst();
            }

            //maintain descending order in deque , remove smaller elements from deque
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
                dq.pollLast();
            }

            //add current index
            dq.offerLast(i);

            //store max in each window
            if (i >= k - 1) {
                output[index] = nums[dq.peekFirst()];
                index++;
            }

        }
        return output;
    }
}