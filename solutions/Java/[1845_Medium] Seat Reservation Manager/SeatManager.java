class SeatManager {
  private PriorityQueue<Integer> availableSeats;

  public SeatManager(int n) {
    availableSeats = new PriorityQueue<>();

    for (int i = 1; i <= n; i++) {
      availableSeats.add(i);
    }
  }

  public int reserve() {
    return availableSeats.remove();
  }

  public void unreserve(int seatNumber) {
    availableSeats.add(seatNumber);
  }
}
