class Solution {
  public boolean isPalindrome(ListNode head) {
    ListNode fast = head;
    ListNode slow = head;
    int index = 0;
    List<Integer> values = new ArrayList<>();
    values.add(slow.val);

    while (fast.next != null && fast.next.next != null) {
      fast = fast.next.next;
      slow = slow.next;
      values.add(slow.val);
      index++;
    }

    boolean isOddLengthList = fast.next == null;
    if (isOddLengthList) {
      index--;
    }
    slow = slow.next;

    while (slow != null) {
      if (slow.val != values.get(index)) {
        return false;
      }

      slow = slow.next;
      index--;
    }

    return true;
  }
}
