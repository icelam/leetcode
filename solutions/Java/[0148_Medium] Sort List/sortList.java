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
  public ListNode sortList(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }

    ListNode middle = getMiddle(head);
    ListNode nextOfMiddle = middle.next;
    middle.next = null;

    ListNode left = sortList(head);
    ListNode right = sortList(nextOfMiddle);
    ListNode sortedList = merge(left, right);

    return sortedList;
  }

  ListNode merge(ListNode left, ListNode right) {
    ListNode result = null;

    if (left == null) {
      return right;
    }

    if (right == null) {
      return left;
    }

    if (left.val <= right.val) {
      result = left;
      result.next = merge(left.next, right);
    } else {
      result = right;
      result.next = merge(left, right.next);
    }

    return result;
  }

  ListNode getMiddle(ListNode head) {
    if (head == null) {
      return head;
    }

    ListNode slow = head;
    ListNode fast = head;

    while (fast.next != null && fast.next.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }

    return slow;
  }
}
