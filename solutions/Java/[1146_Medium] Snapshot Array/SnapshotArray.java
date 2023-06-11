class SnapshotArray {
  private int size;
  private int snapshotId;
  private List<Map<Integer, Integer>> changes;

  public SnapshotArray(int length) {
    size = length;
    snapshotId = 0;
    changes = new ArrayList<>();
    for (int i = 0; i < length; i++) {
      changes.add(new HashMap<Integer, Integer>());
    }
  }

  public void set(int index, int val) {
    changes.get(index).put(this.snapshotId, val);
  }

  public int snap() {
    int currentId = snapshotId;
    snapshotId++;
    return currentId;
  }

  public int get(int index, int snap_id) {
    for (int i = snap_id; i >= 0; i--, snap_id--) {
      if (changes.get(index).containsKey(snap_id)) {
        return changes.get(index).get(snap_id);
      }
    }

    return 0;
  }
}
