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

  public ListNode reverseBetween(ListNode head, int left, int right) {
    ListNode dummyNode = new ListNode(0, head);
    ListNode nodeBeforeStart = dummyNode;
    ListNode endNode = dummyNode;

    for (int i = 0; i < right; i++) {
      if (i < left - 1) {
        nodeBeforeStart = nodeBeforeStart.next;
      }

      endNode = endNode.next;
    }

    ListNode startNode = nodeBeforeStart.next;
    ListNode nodeAfterEnd = endNode.next;


    nodeBeforeStart.next = null;
    endNode.next = null;

    reverseList(startNode);

    startNode.next = nodeAfterEnd;
    nodeBeforeStart.next = endNode;

    return dummyNode.next;
  }
}
