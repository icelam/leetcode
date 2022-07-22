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
  public ListNode partition(ListNode head, int x) {
    ListNode dummyHead = new ListNode(Integer.MIN_VALUE, head);
    ListNode leftPartitionEnd = dummyHead;

    // Find the node where it's next node has value >= x
    // those should move to end of list, while preserving their orders
    while (leftPartitionEnd.next != null && leftPartitionEnd.next.val < x) {
      leftPartitionEnd = leftPartitionEnd.next;
    }

    ListNode currentNode = leftPartitionEnd.next;

    while (currentNode != null) {
      // Find the end of continuous node having values >= x
      while (currentNode.next != null && currentNode.next.val >= x) {
        currentNode = currentNode.next;
      }

      // While the next node of the continuous node has a smaller node value as next node
      // move the smaller node to front of continuois node
      while (currentNode.next != null && currentNode.next.val < x) {
        ListNode rightPartitionStart = leftPartitionEnd.next;
        leftPartitionEnd.next = currentNode.next;

        ListNode newNext = leftPartitionEnd.next.next;
        leftPartitionEnd.next.next = rightPartitionStart;
        currentNode.next = newNext;
        leftPartitionEnd = leftPartitionEnd.next;
      }

      // update the end of end of continuous node having values >= x
      currentNode = currentNode.next;
    }

    return dummyHead.next;
  }
}
