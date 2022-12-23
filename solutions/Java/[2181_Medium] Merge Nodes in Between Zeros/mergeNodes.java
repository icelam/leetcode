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
  public ListNode mergeNodes(ListNode head) {
    ListNode dummyHead = new ListNode(-1, head);
    ListNode current = dummyHead;

    while (current != null) {
      if (current.next.val == 0) {
        current.next = current.next.next;
        current = current.next;
        continue;
      }

      current.val += current.next.val;
      current.next = current.next.next;
    }

    return dummyHead.next;
  }
}
