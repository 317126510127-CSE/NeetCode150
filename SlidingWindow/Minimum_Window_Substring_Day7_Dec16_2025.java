//Approach: Bruteforce (Nested Loops)
//Time & Space Complexity
//Time complexity: O(n*2)
//Space complexity: O(1)

class Solution {
    public boolean isValidMinimumWindowSubstring(int[] freq1, int[] freq2) {
        for (int i = 0; i < 128; i++) {
            if (freq2[i] > freq1[i]) {
                return false;
            }
        }
        return true;
    }

    public String minWindow(String s, String t) {

        if (t.length() > s.length()) {
            return "";
        }
        if (t.isEmpty()) {
            return "";
        }
        String res = "";
        int[] freq2 = new int[128];
        for (int i = 0; i < t.length(); i++) {
            freq2[t.charAt(i)]++;
        }

        //generate all substrings and check
        for (int i = 0; i < s.length(); i++) {
            int[] freq1 = new int[128];
            for (int j = i; j < s.length(); j++) {
                freq1[s.charAt(j)]++;
                if (isValidMinimumWindowSubstring(freq1, freq2)) {
                    if (res.isEmpty() || (j - i + 1) < res.length()) {
                        res = s.substring(i, j + 1);
                    }
                }
            }
        }
        return res;
    }
}



//Approach : My Solution (Sliding Window)
//Time & Space Complexity
//Time complexity: O(n)
//Space complexity: O(1)
class Solution {
    public boolean isValidMinimumWindowSubstring(int[] freq1, int[] freq2) {
        for (int i = 0; i < 128; i++) {
            if (freq2[i] > 0 && freq2[i] > freq1[i]) {
                return false;
            }
        }
        return true;
    }

    public String minWindow(String s, String t) {

        if (t.length() > s.length()) {
            return "";
        }
        if (t.isEmpty()) {
            return "";
        }
        int[] freq2 = new int[128];
        for (int i = 0; i < t.length(); i++) {
            freq2[t.charAt(i)]++;
        }

        int left = 0, right = 0; //left and right pointers of sliding window
        String res = "";
        int minWindow=Integer.MAX_VALUE;
        int len1 = s.length();
        int[] freq1 = new int[128];
        while (right < len1 && right>=left) {
            freq1[s.charAt(right)]++;
            // shrink window while valid
            while (isValidMinimumWindowSubstring(freq1, freq2)) {
                if (right - left + 1 < minWindow) {
                    minWindow = right - left + 1;
                    res = s.substring(left, right + 1);
                }
                freq1[s.charAt(left)]--;
                left++;
            }
            right++;
        }

        return res;
    }
}



//Approach3: Sliding Window (Optional) (Use required characters count as well)
//Time & Space Complexity
//Time complexity: O(n)
//Space complexity: O(1)


class Solution {
    public String minWindow(String s, String t) {

        if (t.length() > s.length() || t.isEmpty()) {
            return "";
        }

        int[] need = new int[128];
        for (char c : t.toCharArray()) {
            need[c]++;
        }

        int[] window = new int[128];

        int required = t.length(); // total characters needed
        int left = 0;
        int minLen = Integer.MAX_VALUE;
        int start = 0;

        for (int right = 0; right < s.length(); right++) {

            char rc = s.charAt(right);
            window[rc]++;

            // if this char was needed, we satisfied one requirement
            if (need[rc] > 0 && window[rc] <= need[rc]) {
                required--;
            }

            // try to shrink window
            while (required == 0) {

                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }

                char lc = s.charAt(left);
                window[lc]--;

                // if removing breaks requirement
                if (need[lc] > 0 && window[lc] < need[lc]) {
                    required++;
                }

                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? ""
                : s.substring(start, start + minLen);
    }
}



// (OR) using hashmap

//Approach :Sliding window using required characters and hashmap
//Time & Space Complexity
//Time complexity: O(n+m)
//Space complexity: O(m)
//Where n is the length of the string s and m is the total number of unique characters in the strings t and s.
public class Solution {
    public String minWindow(String s, String t) {
        if (t.isEmpty()) return "";

        Map<Character, Integer> countT = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (char c : t.toCharArray()) {
            countT.put(c, countT.getOrDefault(c, 0) + 1);
        }

        int have = 0, need = countT.size();
        int[] res = {-1, -1};
        int resLen = Integer.MAX_VALUE;
        int l = 0;

        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            window.put(c, window.getOrDefault(c, 0) + 1);

            if (countT.containsKey(c) && window.get(c).equals(countT.get(c))) {
                have++;
            }

            while (have == need) {
                if ((r - l + 1) < resLen) {
                    resLen = r - l + 1;
                    res[0] = l;
                    res[1] = r;
                }

                char leftChar = s.charAt(l);
                window.put(leftChar, window.get(leftChar) - 1);
                if (countT.containsKey(leftChar) && window.get(leftChar) < countT.get(leftChar)) {
                    have--;
                }
                l++;
            }
        }

        return resLen == Integer.MAX_VALUE ? "" : s.substring(res[0], res[1] + 1);
    }
}

