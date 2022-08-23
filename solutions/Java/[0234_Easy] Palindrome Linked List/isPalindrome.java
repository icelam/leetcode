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

  public boolean isPalindrome(ListNode head) {
    ListNode fast = head;
    ListNode slow = head;

    while (fast.next != null && fast.next.next != null) {
      fast = fast.next.next;
      slow = slow.next;
    }

    boolean isOddLengthList = (fast.next == null);

    ListNode list1 = head;
    ListNode list2 = slow.next;

    slow.next = null;
    list1 = reverseList(list1);

    if (isOddLengthList) {
      list1 = list1.next;
    }

    while (list1 != null) {
      if (list1.val != list2.val) {
        return false;
      }

      list1 = list1.next;
      list2 = list2.next;
    }
    return true;
  }
}
