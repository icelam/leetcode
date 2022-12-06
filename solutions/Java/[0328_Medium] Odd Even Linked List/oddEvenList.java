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
  public ListNode oddEvenList(ListNode head) {
    if (head == null) {
      return head;
    }

    ListNode oddEnd = head;
    ListNode evenHead = head.next;

    ListNode current = head.next;

    while (current != null && current.next != null) {
      ListNode evenNode = current;
      ListNode oddNode = current.next;

      evenNode.next = oddNode.next;
      oddEnd.next = oddNode;
      oddEnd = oddNode;

      current = current.next;
    }

    oddEnd.next = evenHead;

    return head;
  }
}
