// https://leetcode.com/problems/linked-list-cycle/description/
public class LinkedListCycle {
  class ListNode {
    int val;
    ListNode next;
  }
  public boolean hasCycle(ListNode head) {
    if(head == null) return false;
    ListNode slow = head;
    ListNode fast = head.next;

    while(slow != null && fast != null && fast.next != null) {
      if(slow == fast) return true;
      slow = slow.next;
      fast = fast.next.next;
    }
    return false;
  }
}
