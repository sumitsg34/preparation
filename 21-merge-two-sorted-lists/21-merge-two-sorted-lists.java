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
        
        if(list1 == null)
            return list2;
        
        if(list2 == null)
            return list1;
        
        ListNode smaller;
        ListNode other;
        
        if(list1.val < list2.val) {
            smaller = list1;
            other = list2;
        } else {
            
            smaller = list2;
            other = list1;
        }
        
        ListNode head = smaller;
        
        while(smaller != null && other != null) {
            
            if(smaller.next != null) {
                
                if(other.val < smaller.next.val ) {
                    ListNode temp = smaller.next;
                    
                    smaller.next = other;
                    other = other.next;
                    smaller.next.next = temp;                   
                    
                } 
                smaller = smaller.next;
                
            } else {
                smaller.next = other;
                break;
            }
            
        }
            
        return head;      
        
        
    }
    
    private void display(ListNode head) {
        while(head!=null) {
            System.out.println(head.val + "-->");
            head=head.next;
        }
    }
}