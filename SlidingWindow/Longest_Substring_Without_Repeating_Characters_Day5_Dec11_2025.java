

//Approach:Bruteforce
//Time & Space Complexity
//Time complexity: O(n*m)
//Space complexity: O(n)
//Where n is the length of the string and m is the total number of unique characters in the string.
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            Set<Character> charSet = new HashSet<>();
            for (int j = i; j < s.length(); j++) {
                if (charSet.contains(s.charAt(j))) {
                    break;
                }
                charSet.add(s.charAt(j));
            }
            res = Math.max(res, charSet.size());
        }
        return res;
    }
}

//Approach : My Solution using HashSet (Sliding Window)
//Time & Space Complexity
//Time complexity: O(n)
//Space complexity: O(m)
//Where n is the length of the string and m is the total number of unique characters in the string.
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int longestNonRepeatingSubstringLength = 0;
        int l = 0, r = 0, n = s.length();
        HashSet<Character> set = new HashSet<>();
        while (r < n) {
            Character ch = s.charAt(r);
            while (set.contains(ch)) {
                set.remove(s.charAt(l));
                l++;
            }
            set.add(ch);
            longestNonRepeatingSubstringLength = Math.max(longestNonRepeatingSubstringLength, r - l + 1);
            r++;
        }
        return longestNonRepeatingSubstringLength;
    }
}



//Approach : My Solution using HashMap (Sliding Window) (Optimal)
//Time & Space Complexity
//Time complexity: O(n)
//Space complexity: O(m)
//Where n is the length of the string and m is the total number of unique characters in the string.
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int longestNonRepeatingSubstringLength = 0;
        int l = 0, r = 0, n = s.length();
        HashMap<Character, Integer> map = new HashMap<>();
        while (r < n) {
            Character ch = s.charAt(r);
            if (map.containsKey(ch)) {
                l = Math.max(map.get(ch) + 1, l);
            }
            map.put(ch, r);
            longestNonRepeatingSubstringLength = Math.max(longestNonRepeatingSubstringLength, r - l + 1);
            r++;
        }
        return longestNonRepeatingSubstringLength;
    }
}

