//Approach1: iterate with 2 pointers with left at start and right at end ,
// use (Character.isLetterOrDigit() Method) for checking alphanumeric characters
// Time & Space Complexity
// Time complexity: O(n)
// Space complexity: O(1)
class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (!Character.isLetterOrDigit(s.charAt(left))) {
                left += 1;
                continue;
            }
            if (!Character.isLetterOrDigit(s.charAt(right))) {
                right -= 1;
                continue;
            }

            if ((s.charAt(left) != s.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}



//Approach2: iterate with 2 pointers with left at start and right at end ,
//create custom method of alphaNumeric 
// Time & Space Complexity
// Time complexity: O(n)
// Space complexity: O(1)

class Solution {
    public boolean alphaNumeric(Character ch) {
        return (ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9');
    }

    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int left = 0, right = s.length() - 1;
        while (left < right) {
            while (left < right && (!alphaNumeric(s.charAt(left)))) {
                left += 1;
            }
            while (left < right && (!alphaNumeric(s.charAt(right)))) {
                right -= 1;
            }

            if ((s.charAt(left) != s.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}