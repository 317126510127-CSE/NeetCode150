//Approach1 :    Bruteforce with nested loops(2)
// Time & Space Complexity
// Time complexity: O(n*2)
// Space complexity: O(n)
public class Solution {
    public int longestConsecutive(int[] nums) {
        int res = 0;
        Set<Integer> store = new HashSet<>();
        for (int num : nums) {
            store.add(num);
        }

        for (int num : nums) {
            int streak = 0, curr = num;
            while (store.contains(curr)) {
                streak++;
                curr++;
            }
            res = Math.max(res, streak);
        }
        return res;
    }
}


//Approach2: Sorting
// Time & Space Complexity
// Time complexity: O(n*logn)
// Space complexity: O(n)

public class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int res = 0, curr = nums[0], streak = 0, i = 0;

        while (i < nums.length) {
            if (curr != nums[i]) {
                curr = nums[i];
                streak = 0;
            }
            while (i < nums.length && nums[i] == curr) {
                i++;
            }
            streak++;
            curr++;
            res = Math.max(res, streak);
        }
        return res;
    }
}




//Approach3:
//Optimal Approach. - (HashSet). (Find start and find the size of sequence)
//we can do with end-start as well but *****(start to end is optimal in worst case scenarios of fragmented sequences)
// Time & Space Complexity
// Time complexity: O(n)
// Space complexity: O(n)
class Solution {
    public int longestConsecutive(int[] nums) {

        if (nums.length == 0)
            return 0;

        HashSet<Integer> numSet = new HashSet<>();
        for (int n : nums)
            numSet.add(n);

        int longest = 0;

        for (int n : numSet) { // iterating through the set is enough
            if (!numSet.contains(n - 1)) { // this means n is the start
                int currentNum = n;
                int length = 1;

                while (numSet.contains(currentNum + 1)) {
                    currentNum++;
                    length++;
                }

                longest = Math.max(longest, length);
            }
        }

        return longest;
    }
}
