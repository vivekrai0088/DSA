public class PalindromicLinkedList {
  class ListNode {
    int val;
    ListNode next;
  }

  // https://leetcode.com/problems/palindrome-linked-list/description/
  private ListNode reverse(ListNode head) {
    ListNode prev = null;

    while(head != null) {
      ListNode next = head.next;
      head.next = prev;
      prev = head;
      head = next;
    }
    return prev;
  }

  public boolean isPalindrome(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;

    while(fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }

    ListNode head2 = slow;
    if(fast != null) { // odd nodes
      slow = slow.next;
    }

    slow = reverse(slow);
    fast = head;

    while(slow != null) {
      if(fast.val != slow.val) return false;
      fast = fast.next;
      slow = slow.next;
    }
    return true;

  }
}
