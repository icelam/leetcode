class MyCalendarTwo {
  private List<int[]> calendar;
  private List<int[]> overlappedEvents;

  private boolean isOverlapped(int start1, int end1, int start2, int end2) {
    return Math.max(start1, start2) < Math.min(end1, end2);
  }

  private int[] getOverlappedRange(int start1, int end1, int start2, int end2) {
    return new int[]{Math.max(start1, start2), Math.min(end1, end2)};
  }

  public MyCalendarTwo() {
    calendar = new ArrayList();
    overlappedEvents = new ArrayList();
  }

  public boolean book(int start, int end) {
    for (int[] event: overlappedEvents) {
      if (isOverlapped(event[0], event[1], start, end)) {
        return false;
      }
    }

    for (int[] event: calendar) {
      if (isOverlapped(event[0], event[1], start, end)) {
        overlappedEvents.add(getOverlappedRange(event[0], event[1], start, end));
      }
    }

    calendar.add(new int[]{start, end});
    return true;
  }
}
