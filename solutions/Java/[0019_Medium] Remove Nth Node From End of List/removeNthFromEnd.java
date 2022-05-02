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
  public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode dummyHead = new ListNode(0, head);
    ListNode fast = head;

   for (int i = 0; i < n; i++) {
      fast = fast.next;
    }

    ListNode previous = dummyHead;
    ListNode slow = head;

    while (fast != null) {
      fast = fast.next;
      previous = slow;
      slow = slow.next;
    }

    previous.next = slow.next;
    return dummyHead.next;
  }
}
