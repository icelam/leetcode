class TimeMap {
  private HashMap<String, TreeMap<Integer, String>> map;

  public TimeMap() {
    map = new HashMap<>();
  }

  public void set(String key, String value, int timestamp) {
    if (!map.containsKey(key)) {
      map.put(key, new TreeMap<>());
    }

    map.get(key).put(timestamp, value);
  }

  public String get(String key, int timestamp) {
    if (!map.containsKey(key)) {
      return "";
    }

    TreeMap<Integer, String> keyMap = map.get(key);
    Integer floorKey = keyMap.floorKey(timestamp);
    return floorKey != null ? keyMap.get(floorKey) : "";
  }
}
