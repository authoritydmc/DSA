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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode lN = head;

        Stack<Integer> stck = new Stack<>();
        for (int i = 1; i < left; i++) {

            lN = lN.next;
        }

        stck.push(lN.val);
        ListNode rN = lN;
        for (int i = 1; i <= right - left; i++) {

            rN = rN.next;
            stck.push(rN.val);

        }

        while (!stck.isEmpty()) {
          
                      lN.val = stck.pop();

            lN = lN.next;
        }

        return head;
    }
}