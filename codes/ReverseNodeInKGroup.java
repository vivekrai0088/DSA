// https://leetcode.com/problems/reverse-nodes-in-k-group/description/
public class ReverseNodeInKGroup {
  class ListNode {
    int data;
    ListNode next;
  }

  public ListNode reverseKGroup(ListNode head, int k) {
    ListNode curr = head;
    int count = 0;
    while(curr != null && count != k) {
      curr = curr.next;
      count++;
    }
    if(count == k) {
      curr = reverseKGroup(curr, k);

      while(count-- > 0) {
        ListNode temp = head.next;
        head.next = curr;
        curr = head;
        head = temp;
      }
      head = curr;
    }
    return head;
  }
}
