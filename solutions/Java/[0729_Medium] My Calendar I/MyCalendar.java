class MyCalendar {
  private List<int[]> calendar;

  public MyCalendar() {
    calendar = new ArrayList();
  }

  public boolean book(int start, int end) {
    for (int[] event: calendar) {
      if (end > event[0] && start < event[1]) {
        return false;
      }
    }
    calendar.add(new int[]{start, end});
    return true;
  }
}
