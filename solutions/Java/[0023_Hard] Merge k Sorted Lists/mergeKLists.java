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
  public ListNode mergeKLists(ListNode[] lists) {
    if (lists.length == 0) {
      return null;
    }

    PriorityQueue<ListNode> heap = new PriorityQueue<>((a, b) -> a.val - b.val);
    ListNode dummyHead = new ListNode();
    ListNode currentNode = dummyHead;

    for (ListNode head: lists) {
      if (head != null) {
        heap.add(head);
      }
    }

    while (!heap.isEmpty()) {
      ListNode node = heap.remove();
      currentNode.next = node;

      if (node.next != null) {
        heap.add(node.next);
      }

      currentNode = currentNode.next;
    }

    return dummyHead.next;

  }
}
