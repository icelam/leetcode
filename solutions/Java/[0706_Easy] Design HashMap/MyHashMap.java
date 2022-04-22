class MyHashMap {
  private int[] hashMap;
  public MyHashMap() {
    hashMap = new int[1000001];
    Arrays.fill(hashMap, -1);
  }

  public void put(int key, int value) {
    hashMap[key] = value;
  }

  public int get(int key) {
    return hashMap[key];
  }

  public void remove(int key) {
    hashMap[key] = -1;
  }
}
