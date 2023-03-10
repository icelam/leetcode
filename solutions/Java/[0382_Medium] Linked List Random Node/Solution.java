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
  private Random random;
  private ListNode head;
  private int n;

  public Solution(ListNode head) {
    this.head = head;
    this.random = new Random();
    this.n = 0;

    ListNode currentNode = head;
    while (currentNode != null) {
      currentNode = currentNode.next;
      n++;
    }
  }

  public int getRandom() {
    int index = random.nextInt(0, n);
    ListNode currentNode = head;
    for (int i = index; i > 0; i--) {
      currentNode = currentNode.next;
    }

    return currentNode.val;
  }
}
