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
  public void swapByValue(ListNode node1, ListNode node2) {
    int temp = node1.val;
    node1.val = node2.val;
    node2.val = temp;
  }

  public int getListLength(ListNode head) {
    if (head == null) {
      return 0;
    }

    int count = 1;

    // Odd length list: head.next == null
    // Even length list: head.next.next != null
    while (head.next != null && head.next.next != null) {
      count++;
      head = head.next.next;
    }

    return (count * 2) - (head.next == null ? 1 : 0);
  }

  public int[] calculateSwapIndices(int listLength, int position) {
    int p1 = position;
    int p2 = listLength + 1 - position;

    if (position > listLength / 2) {
      return new int[]{p2, p1};
    }

    return new int[]{p1, p2};
  }

  public ListNode swapNodes(ListNode head, int k) {
    ListNode fast = head;
    int length = getListLength(head);
    int[] swapIndices = calculateSwapIndices(length, k);

    if (length == 1 || swapIndices[0] == swapIndices[1]) {
      return head;
    }

    ListNode target = null;
    ListNode current = head;

    for (int i = 1; i <= swapIndices[1]; i++) {
      if (i == swapIndices[0]) {
        target = current;
      }

      if (i == swapIndices[1]) {
        swapByValue(target, current);
      }

      current = current.next;
    }

    return head;
  }
}
