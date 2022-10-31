package leetcode.linkedlist;

public class Solution {

	public static void main(String[] args) {
		
		
		ListNode list1 = new ListNode(1);
		list1.next = new ListNode(2);
		list1.next.next = new ListNode(4);

		ListNode list2 = new ListNode(1);
		list2.next = new ListNode(3);
		list2.next.next = new ListNode(5);
		
		ListNode n = mergeTwoLists(list1, list2);
		System.out.println("################################");
        while(n!=null) {
        	System.out.println(n.val);
        	n = n.next;
        }

	}

	public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
      
         ListNode result1 = new ListNode();
        ListNode result = result1;
        
        while(list1 != null && list2 != null) {
            if(list1.val>list2.val) {
                result.next = list2;
                list2 = list2.next;
            }
            else {
                result.next = list1;
                list1 = list1.next;
            }
            result = result.next;
        }
        result.next = list1==null?list2:list1;
        return result1.next;
    }
}
