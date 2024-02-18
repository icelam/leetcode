class Room implements Comparable<Room> {
  private int id;
  private int meetingCount;
  private int occupyUntil;

  public Room(int id, int meetingCount, int occupyUntil) {
    this.id = id;
    this.meetingCount = meetingCount;
    this.occupyUntil = occupyUntil;
  }

  @Override public String toString() {
    return "Room " + id + ": " + meetingCount + " count, " + occupyUntil + "t";
  }

  @Override public int compareTo(Room o) {
    if (occupyUntil == o.occupyUntil) {
      return id - o.id;
    }

    return occupyUntil - o.occupyUntil;
  }

  public int getId() {
    return id;
  }

  public int getMeetingCount() {
    return meetingCount;
  }

  public int getOccupyUntil() {
    return occupyUntil;
  }

  public void addNewMeeting(int endTime) {
    meetingCount++;
    occupyUntil = endTime;
  }
}

class Meeting implements Comparable<Meeting> {
  private int id;
  private int startTime;
  private int endTime;

  public Meeting(int id, int startTime, int endTime) {
    this.id = id;
    this.startTime = startTime;
    this.endTime = endTime;
  }

  @Override public String toString() {
    return id + ": " + startTime + " - " + endTime;
  }

  @Override public int compareTo(Meeting o) {
    if (startTime == o.startTime) {
      return id - o.id;
    }

    return startTime - o.startTime;
  }

  public int getStartTime() {
    return startTime;
  }

  public int getEndTime() {
    return endTime;
  }

  public void delay(int timeToDelay) {
    startTime += timeToDelay;
    endTime += timeToDelay;
  }
}

class Solution {
  public int mostBooked(int n, int[][] meetings) {
    PriorityQueue<Room> unusedRooms = new PriorityQueue<>((a, b) -> a.getId() - b.getId());
    PriorityQueue<Room> usedRooms = new PriorityQueue<>();
    int maxMeetingCount = 0;
    int roomIdWithMaxMeetings = 0;

    Arrays.sort(meetings, (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);

    for (int i = 0; i < n; i++) {
      unusedRooms.add(new Room(i, 0, 0));
    }

    for (int[] currentMeeting : meetings) {
      while (!usedRooms.isEmpty() && usedRooms.peek().getOccupyUntil() <= currentMeeting[0]) {
        unusedRooms.add(usedRooms.remove());
      }

      Room nextRoom = null;

      if (unusedRooms.isEmpty()) {
        nextRoom = usedRooms.remove();
        nextRoom.addNewMeeting(nextRoom.getOccupyUntil() + currentMeeting[1] - currentMeeting[0]);
        usedRooms.add(nextRoom);
      } else {
        nextRoom = unusedRooms.remove();
        nextRoom.addNewMeeting(currentMeeting[1]);
        usedRooms.add(nextRoom);
      }

      if (nextRoom.getMeetingCount() > maxMeetingCount) {
        maxMeetingCount = nextRoom.getMeetingCount();
        roomIdWithMaxMeetings = nextRoom.getId();
      } else if (nextRoom.getMeetingCount() == maxMeetingCount && nextRoom.getId() < roomIdWithMaxMeetings) {
        roomIdWithMaxMeetings = nextRoom.getId();
      }
    }

    return roomIdWithMaxMeetings;
  }
}
