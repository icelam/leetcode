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
  public ListNode reverseList(ListNode head) {
    ListNode temp = null;
    ListNode current = head;
    ListNode previous = null;

    while (current != null) {
      temp = current.next;
      current.next = previous;
      previous = current;
      current = temp;
    }

    return previous;
  }

  public ListNode sumList(ListNode l1, ListNode l2, int carry, ListNode previous) {
    if (l1 == null && l2 == null && carry == 0) {
      return previous;
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

    ListNode newHead = new ListNode(sum % 10);
    newHead.next = previous;

    return sumList(next1, next2, sum / 10, newHead);
  }

  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode num1 = reverseList(l1);
    ListNode num2 = reverseList(l2);

    return sumList(num1, num2, 0, null);
  }
}
