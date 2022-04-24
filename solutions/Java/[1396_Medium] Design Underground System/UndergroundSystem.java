class UndergroundSystem {
  public class CheckInInformation {
    private String stationName;
    private int time;

    public CheckInInformation(String stationName, int time) {
      this.stationName = stationName;
      this.time = time;
    }
  }

  private HashMap<Integer, CheckInInformation> traveling;
  private HashMap<String, int[]> history;

  public UndergroundSystem() {
    traveling = new HashMap<Integer, CheckInInformation>();
    history = new HashMap<String, int[]>();
  }

  public void checkIn(int id, String stationName, int t) {
    if (!traveling.containsKey(id)) {
      traveling.put(id, new CheckInInformation(stationName, t));
    }
  }

  public void checkOut(int id, String stationName, int t) {
    if (traveling.containsKey(id)) {
      CheckInInformation record = traveling.get(id);
      String key = record.stationName + "->" + stationName;
      int timeNeeded = t - record.time;

      if (history.containsKey(key)) {
        int[] historicalTime = history.get(key);
        historicalTime[0] += timeNeeded;
        historicalTime[1]++;
      } else {
        int[] historicalTime = new int[2];
        historicalTime[0] += timeNeeded;
        historicalTime[1]++;
        history.put(key, historicalTime);
      }

      traveling.remove(id);
    }
  }

  public double getAverageTime(String startStation, String endStation) {
    String key = startStation + "->" + endStation;

    if (history.containsKey(key)) {
      int[] historicalTime = history.get(key);

      return (double) historicalTime[0] / historicalTime[1];
    } else {
      return -1;
    }
  }
}
