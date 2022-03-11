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
  public ListNode middleNode(ListNode head) {
    if (head == null) {
      return null;
    }

    ListNode pointer = head;
    int count = 0;

    while (pointer != null) {
      count++;
      pointer = pointer.next;
    }

    int middleIndex = (count + 2 - (count % 2)) / 2;

    for (int i = 1; i <= middleIndex; i++) {
      if (i == middleIndex) {
        return head;
      }
      head = head.next;
    }

    return null;
  }
}
