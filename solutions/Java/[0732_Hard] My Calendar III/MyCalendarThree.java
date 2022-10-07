class MyCalendarThree {
  private TreeMap<Integer, Integer> map;

  public MyCalendarThree() {
    map = new TreeMap<>();
  }

  public int book(int start, int end) {
    int maxBookings = 0;
    int currentBookings = 0;

    map.put(start, map.getOrDefault(start, 0) + 1);
    map.put(end, map.getOrDefault(end, 0) - 1);

    for (int bookingsChange: map.values()) {
      currentBookings += bookingsChange;
      maxBookings = Math.max(maxBookings, currentBookings);
    }

    return maxBookings;
  }
}
