class LFUCache {
  private Map<Integer, int[]> cache;
  private Map<Integer, LinkedHashSet<Integer>> frequencyTable;
  private int minFrequency;
  private int cacheSize;

  public LFUCache(int capacity) {
    cache = new HashMap<>();
    frequencyTable = new HashMap<>();
    minFrequency = 0;
    cacheSize = capacity;
  }

  public int get(int key) {
    if (!cache.containsKey(key)) {
      return -1;
    }

    int[] cachedInformation = cache.get(key);
    int value = cachedInformation[0];
    int frequency = cachedInformation[1];

    // Whenever new item is accessed, frequency table needs to be updated
    Set<Integer> keysWithFrequency = frequencyTable.get(frequency);
    keysWithFrequency.remove(key);

    if (minFrequency == frequency && keysWithFrequency.isEmpty()) {
      minFrequency++;
    }

    int newFrequency = frequency + 1;
    cache.put(key, new int[]{value, newFrequency});
    frequencyTable.putIfAbsent(newFrequency, new LinkedHashSet<>());
    frequencyTable.get(newFrequency).add(key);

    return value;
  }

  public void put(int key, int value) {
    // Constraints: 0 <= capacity <= 10^4
    if (cacheSize <= 0) {
      return;
    }

    // Update current cache if exists
    if (cache.containsKey(key)) {
      cache.put(key, new int[]{value, cache.get(key)[1]});
      int currentFrequency = cache.get(key)[1];
      int newFrequency = currentFrequency + 1;
      cache.put(key, new int[]{value, newFrequency});
      Set<Integer> keysWithCurrentFrequency = frequencyTable.get(currentFrequency);
      keysWithCurrentFrequency.remove(key);
      if (minFrequency == currentFrequency && keysWithCurrentFrequency.isEmpty()) {
        minFrequency++;
      }
      frequencyTable.putIfAbsent(newFrequency, new LinkedHashSet<>());
      frequencyTable.get(newFrequency).add(key);
    } else {
      // Remove old cache
      if (cacheSize == cache.size()) {
        Set<Integer> keysWithMinFrequency = frequencyTable.get(minFrequency);
        int keyToDelete = keysWithMinFrequency.iterator().next();
        cache.remove(keyToDelete);
        keysWithMinFrequency.remove(keyToDelete);
      }

      // Create new cache key
      int newFrequency = 1;
      minFrequency = newFrequency;
      cache.put(key, new int[]{value, newFrequency});
      frequencyTable.putIfAbsent(newFrequency, new LinkedHashSet<>());
      frequencyTable.get(newFrequency).add(key);
    }
  }
}
