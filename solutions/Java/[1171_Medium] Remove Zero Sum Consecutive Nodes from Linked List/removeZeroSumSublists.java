class Solution {
  public ListNode removeZeroSumSublists(ListNode head) {
    Map<Integer, ListNode> map = new HashMap<>();
    ListNode dummyNode = new ListNode(0);
    dummyNode.next = head;

    int sum = 0;
    ListNode currentNode = dummyNode;

    while (currentNode != null) {
      sum += currentNode.val;
      map.put(sum, currentNode);
      currentNode = currentNode.next;
    }

    sum = 0;
    currentNode = dummyNode;

    while (currentNode != null) {
      sum += currentNode.val;
      currentNode.next = map.get(sum).next;
      currentNode = currentNode.next;
    }

    return dummyNode.next;
  }
}
