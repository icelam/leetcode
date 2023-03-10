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
  private ListNode head;

  public Solution(ListNode head) {
    this.head = head;
  }

  public int getRandom() {
    ListNode currentNode = this.head;
    int scope = 1;
    int result = 0;

    while (currentNode != null) {
      if (Math.random() * scope < 1) {
        result = currentNode.val;
      }

      currentNode = currentNode.next;
      scope++;
    }

    return result;
  }
}
