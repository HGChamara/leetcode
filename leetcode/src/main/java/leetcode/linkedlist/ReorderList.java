package leetcode.linkedlist;

public class ReorderList {

	public static void main(String[] args) {
		ListNode list1 = new ListNode(1);
		list1.next = new ListNode(2);
		list1.next.next = new ListNode(3);
		list1.next.next.next = new ListNode(4);
		list1.next.next.next.next = new ListNode(5);
		reorderList(list1);
	}
	
	public static void reorderList(ListNode head) {
        
		
		ListNode slow = head;
		ListNode fast = head.next;
		
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		
		//System.out.println(slow.val);
		
		ListNode second = slow.next;
		ListNode prev = slow.next = null;
		
		
		while(second != null) {
			ListNode temp = second.next;
			second.next = prev;
			prev = second;
			second = temp;
		}
		
		ListNode first = head;
		ListNode sec = prev;
		
		while(sec != null) {
			ListNode temp1 = first.next;
			ListNode temp2 = sec.next;
			
			first.next = sec;
			sec.next = temp1;
			first = temp1;
			sec = temp2;
		}
		
		while(head != null) {
			System.out.println(head.val);
			head = head.next;
		}
    }

}
