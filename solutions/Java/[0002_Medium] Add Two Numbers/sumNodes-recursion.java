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
  public ListNode sumNodes(ListNode l1, ListNode l2, int carry) {
    if (l1 == null && l2 == null && carry == 0) {
      return null;
    }

    int sum = carry;
    ListNode next1 = null;
    ListNode next2 = null;

    if (l1 != null) {
      sum += l1.val;
      next1 = l1.next;
    }

    if (l2 != null) {
      sum += l2.val;
      next2 = l2.next;
    }

    return new ListNode(sum % 10, sumNodes(next1, next2, sum / 10));
  }

  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    return sumNodes(l1, l2, 0);
  }
}
