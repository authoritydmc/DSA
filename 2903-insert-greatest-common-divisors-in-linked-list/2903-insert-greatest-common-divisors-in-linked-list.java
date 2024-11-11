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

    private int GCD(int a, int b) {
        if (b == 0) {
            return a;
        }
        // Recursive call with b and the remainder of a divided by b
        return GCD(b, a % b);
    }

    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode slow = head;
        if (head.next == null)
            return head;
        ListNode fast = head.next;
        // we have two pointers now ..
        // now find the GCD of fast and slow insert after slow and then move fast to
        // fast next and slow becoms fast ...repeat the same until fast is null

        while (fast != null) {

            int gcd = GCD(fast.val, slow.val);
            ListNode temp = new ListNode(gcd, fast);
            slow.next = temp;
            slow = fast;
            fast = fast.next;
        }

        return head;
    }
}