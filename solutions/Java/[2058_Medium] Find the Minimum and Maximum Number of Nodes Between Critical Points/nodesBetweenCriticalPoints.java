class Solution {
  public int[] nodesBetweenCriticalPoints(ListNode head) {
    int index = 1;
    int firstCriticalPoint = -1;
    int previousCriticalPoint = -1;
    int minDistance = Integer.MAX_VALUE;
    int maxDistance = -1;
    ListNode previousNode = null;
    ListNode currentNode = head;

    while (currentNode != null) {
      if (previousNode != null && currentNode.next != null) {
        boolean isLocalMinima = (
          currentNode.val < previousNode.val
          && currentNode.val < currentNode.next.val
        );
        boolean isLocalMaxima = (
          currentNode.val > previousNode.val
          && currentNode.val > currentNode.next.val
        );

        if (isLocalMinima || isLocalMaxima) {
          if (previousCriticalPoint == -1) {
            firstCriticalPoint = index;
          } else {
            minDistance = Math.min(minDistance, index - previousCriticalPoint);
          }

          previousCriticalPoint = index;
        }
      }

      previousNode = currentNode;
      currentNode = currentNode.next;
      index++;
    }

    if (minDistance == Integer.MAX_VALUE) {
      minDistance = -1;
    } else {
      maxDistance = previousCriticalPoint - firstCriticalPoint;
    }

    return new int[]{minDistance, maxDistance};
  }
}
