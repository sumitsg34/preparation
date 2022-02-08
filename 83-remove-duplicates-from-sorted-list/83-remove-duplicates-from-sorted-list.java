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
    public ListNode deleteDuplicates(ListNode head) {
        
        if(head == null)
            return head;
        
        ListNode temp = head;
        
        // 1 1 2 3 3
        ListNode prev = head; 
        head = head.next;       
        while(head != null) {
            if(head.val == prev.val) {
                prev.next = head.next;
            } else prev = prev.next;
            head = head.next;
        } 
        
        return temp;
        
    }
}