class Solution {
  public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
    int defer = (b + 1) - (a - 1);
    ListNode fast = list1;
    ListNode slow = list1;

    for (int i = 0; i <= b; i++) {
      fast = fast.next;

      if (i >= defer) {
        slow = slow.next;
      }
    }

    slow.next = list2;

    while (slow.next != null) {
      slow = slow.next;
    }

    slow.next = fast;

    return list1;
  }
}
