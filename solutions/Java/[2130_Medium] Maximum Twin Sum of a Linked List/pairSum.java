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
    ListNode previous = null;
    ListNode current = head;

    while (current != null) {
      ListNode next = current.next;
      current.next = previous;
      previous = current;
      current = next;
    }

    return previous;
  }

  public int pairSum(ListNode head) {
    ListNode fast = head.next.next;
    ListNode slow = head;

    while (fast != null) {
      fast = fast.next.next;
      slow = slow.next;
    }

    ListNode head2 = slow.next;
    slow.next = null;
    head2 = reverseList(head2);

    int maxSum = Integer.MIN_VALUE;

    while (head != null && head2 != null) {
      maxSum = Math.max(maxSum, head.val + head2.val);
      head = head.next;
      head2 = head2.next;
    }

    return maxSum;
  }
}
