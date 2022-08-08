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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        
        ListNode root=new ListNode();
        
        int acc=0;
        ListNode curr=root;
        int sum=0;
        
        
        while(l1!=null && l2!=null)
        {
            
            sum=l1.val+l2.val+acc;
                  acc=sum/10;
            sum%=10;
            ListNode temp=new ListNode(sum);
            curr.next=temp;
             curr=temp;
            l1=l1.next;
            l2=l2.next;
            
        }
        
        while(l1!=null)
        {
            sum=l1.val+acc;
            acc=sum/10;
            sum%=10;
            ListNode temp=new ListNode(sum);
            curr.next=temp;
            curr=temp;
            l1=l1.next;
            
        }
        
                while(l2!=null)
        {
            sum=l2.val+acc;
                     acc=sum/10;
            sum%=10;
            ListNode temp=new ListNode(sum);
            curr.next=temp;
            curr=temp;
            l2=l2.next;
            
        }
        if (acc==1)
        {
            curr.next=new ListNode(1);
        }
        return root.next;
    }
}