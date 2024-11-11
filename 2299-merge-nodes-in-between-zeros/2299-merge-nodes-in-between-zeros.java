/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeNodes(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        ListNode newHead=null;
        int sum = 0;
        while (fast != null) {
            if (fast.val == 0) {
                System.out.println("Encountered 0 with sum "+sum);
                // we encountered our 0 hence replace it with the sum
                if (sum != 0) {

                    ListNode temp = new ListNode(sum);
                    //generally we mark this as in sequence of previous valid link
                    //only execute for the first time 
                    if (newHead==null)
                    {
                        newHead = temp;
                        head=newHead;
                    }
                    else 
                    {
                        newHead.next = temp;
                        newHead=newHead.next;
                    }

                }
                // we have consumed till this 0 hence mark this new starting 0 boundary
                slow = fast;
                // reset the sum as new boundary established
                sum = 0;
            }
            sum += fast.val;
            // move forward
            fast = fast.next;

        }

        return head;

    }
}