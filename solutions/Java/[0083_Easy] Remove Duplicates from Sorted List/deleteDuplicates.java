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
    if (head == null) {
      return head;
    }

    ListNode start = head;
    ListNode end = head.next;

    while (start != null) {
      while (end != null && start.val == end.val) {
        end = end.next;
      }

      start.next = end;
      start = end;
    }

    return head;
  }
}
