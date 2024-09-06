class Solution {
  public ListNode modifiedList(int[] nums, ListNode head) {
    HashSet<Integer> nodesToRemove = new HashSet<>();

    for (int value: nums) {
      nodesToRemove.add(value);
    }

    ListNode dummyHead = new ListNode(-1, head);
    ListNode currentNode = dummyHead;

    while (currentNode.next != null) {
      if (nodesToRemove.contains(currentNode.next.val)) {
        currentNode.next = currentNode.next.next;
      } else {
        currentNode = currentNode.next;
      }
    }

    return dummyHead.next;
  }
}
