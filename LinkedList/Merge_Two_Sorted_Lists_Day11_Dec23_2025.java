

//Approach : Iterative Solution 
// Time & Space Complexity
//Time complexity: O(n+m)
//Space complexity: O(n+m) Where n is the length of list1 and m is the length of list2.


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
          if(list1==null)
          {
            return list2;
          }
           if(list2==null)
          {
            return list1;
          }

          if(list1.val<=list2.val)
          {
             list1.next=mergeTwoLists(list1.next,list2);
             return list1;
          }
          else
          {
             list2.next=mergeTwoLists(list1,list2.next);
             return list2;
          }
    }
}





//Approach : Iterative Solution 
// Time & Space Complexity
//Time complexity: O(n+m)
//Space complexity: O(1) Where n is the length of list1 and m is the length of list2.

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode node = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                node.next = list1;
                list1 = list1.next;
            } else {
                node.next = list2;
                list2 = list2.next;
            }
            node = node.next;
        }

        if (list1 != null) {
            node.next = list1;
        }

        if (list2 != null) {
            node.next = list2;
        }

        return dummy.next;
    }
}





// **** Important in O(1) space



public class ListNode {
    int val;
    ListNode next;
    ListNode() {};
    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
     ListNode(int val, ListNode next) 
     {
         this.val = val; 
         this.next = next;
          }
}

public class MergeLists {
    public static ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        // Ensure l1 starts with smaller value
        if (l1.val > l2.val) {
            ListNode temp = l1;
            l1 = l2;
            l2 = temp;
        }

        ListNode result = l1;

        while (l1 != null && l2 != null) {
            ListNode prev = null;

            while (l1 != null && l1.val <= l2.val) {
                prev = l1;
                l1 = l1.next;
            }

            prev.next = l2;

            // swap l1 and l2
            ListNode temp = l1;
            l1 = l2;
            l2 = temp;
        }

        return result;
    }
}




//Using ARRAYS



public class MergeArrays {
    public static void merge(int[] A, int n, int[] B, int m) {
        int i = n - 1;      // last element in A
        int j = m - 1;      // last element in B
        int k = n + m - 1;  // last position in A

        while (i >= 0 && j >= 0) {
            if (A[i] > B[j]) {
                A[k--] = A[i--];
            } else {
                A[k--] = B[j--];
            }
        }

        while (j >= 0) {
            A[k--] = B[j--];
        }
    }
}
