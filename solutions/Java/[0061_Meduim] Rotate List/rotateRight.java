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
  public ListNode rotateRight(ListNode head, int k) {
    if (head == null || head.next == null) {
      return head;
    }

    ListNode current = head;
    int listLength = 0;

    while (current != null) {
      listLength++;
      current = current.next;
    }

    ListNode fast = head;
    ListNode slow = head;

    while (fast.next != null) {
      if (k % listLength > 0) {
        k--;
      } else {
        slow = slow.next;
      }

      fast = fast.next;
    }

    fast.next = head;
    head = slow.next;
    slow.next = null;

    return head;
  }
}
