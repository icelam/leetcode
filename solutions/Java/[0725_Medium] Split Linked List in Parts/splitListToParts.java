class Solution {
  public ListNode[] splitListToParts(ListNode head, int k) {
    ListNode[] result = new ListNode[k];

    if (head == null) {
      return result;
    }

    int n = 0;
    ListNode fast = head;
    ListNode slow = head;

    while (fast.next != null && fast.next.next != null) {
      fast = fast.next.next;
      slow = slow.next;
      n += 2;
    }

    boolean isOddLengthList = fast.next == null;
    n += isOddLengthList ? 1 : 2;

    int itemsPerChunk = n / k;
    int remainder = n % k;
    ListNode currentNode = head;

    for (int i = 0; i < k; i++) {
      ListNode chunkHead = currentNode;

      int neededItemsCount = itemsPerChunk;
      if (i < remainder) {
        neededItemsCount++;
      }

      for (int j = 0; j < neededItemsCount - 1; j++) {
        if (currentNode != null) {
          currentNode = currentNode.next;
        }
      }

      if (currentNode != null) {
        ListNode previousNode = currentNode;
        currentNode = currentNode.next;
        previousNode.next = null;
      }

      result[i] = chunkHead;
    }

    return result;
  }
}
