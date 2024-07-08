public class ListNode {
  int val;
  ListNode next;

  ListNode(int val) {
    this.val = val;
  }
}

class Solution {
  public int findTheWinner(int n, int k) {
    ListNode head = new ListNode(1);
    ListNode previousNode = head;

    for (int i = 2; i <= n; i++) {
      ListNode currentNode = new ListNode(i);
      previousNode.next = currentNode;
      previousNode = currentNode;
    }

    previousNode.next = head;
    ListNode currentNode = head;

    while (currentNode.next != currentNode) {
      for (int i = 0; i < k - 1; i++) {
        previousNode = currentNode;
        currentNode = currentNode.next;
      }

      previousNode.next = currentNode.next;
      currentNode = previousNode.next;
    }

    return currentNode.val;
  }
}
