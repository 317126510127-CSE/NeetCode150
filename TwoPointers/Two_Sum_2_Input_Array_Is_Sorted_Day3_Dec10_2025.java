//Approach1 : Nested Loops(Bruteforce)
// Time & Space Complexity
// Time complexity: O(n*2)
// Space complexity: O(1)
public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == target) {
                    return new int[] { i + 1, j + 1 };
                }
            }
        }
        return new int[0];
    }
}



//Approach2:
// Time & Space Complexity
// Time complexity: O(n*logn)
// Space complexity: O(1)
public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            int l = i + 1, r = numbers.length - 1;
            int tmp = target - numbers[i];
            while (l <= r) {
                int mid = l + (r - l) / 2;
                if (numbers[mid] == tmp) {
                    return new int[] { i + 1, mid + 1 };
                } else if (numbers[mid] < tmp) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return new int[0];
    }
}


//Approach3: Using HashMap
// Time & Space Complexity
// Time complexity: O(n)
// Space complexity: O(n)
public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            int tmp = target - numbers[i];
            if (mp.containsKey(tmp)) {
                return new int[] { mp.get(tmp), i + 1 };
            }
            mp.put(numbers[i], i + 1);
        }
        return new int[0];
    }
}






// Approach4: Two Pointers (Optimal)
// Time & Space Complexity
// Time complexity: O(n)
// Space complexity: O(1)
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        int[] res = new int[2];
        while (left < right) {
            if ((numbers[left] + numbers[right]) == target) {
                res[0] = left + 1;
                res[1] = right + 1;
                return res;
                //return new int[] { l + 1, r + 1 };
            } else if (numbers[left] + numbers[right] > target) {
                right--;
            } else {
                left++;
            }
        }
        return new int[0];
    }
}