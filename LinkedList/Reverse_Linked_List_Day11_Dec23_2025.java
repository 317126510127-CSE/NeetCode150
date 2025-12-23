//Approach : Recursive Solution 
// Time & Space Complexity
// Time complexity: O(n)
// Space complexity: O(n)

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

public class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
}


//Approach : Iterative Solution 
// Time & Space Complexity
// Time complexity: O(n)
// Space complexity: O(1)

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
    public ListNode reverseList(ListNode head) {
        ListNode root=head;
        ListNode prev=null;
        if(head==null)
        {
            return null;
        }
        ListNode next=root.next;
        while(root!=null)
        {
            ListNode temp=root.next;
            root.next=prev;
            prev=root;
            root=temp;
        }
        return prev;
    }
}
