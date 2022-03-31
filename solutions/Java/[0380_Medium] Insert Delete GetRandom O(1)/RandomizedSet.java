class RandomizedSet {
  private HashMap<Integer, Integer> positions;
  private List<Integer> values;
  private Random random;

  public RandomizedSet() {
    positions = new HashMap<Integer, Integer>();
    values  = new ArrayList<Integer>();
    random = new Random();
  }

  public boolean insert(int val) {
    if (positions.containsKey(val)) {
      return false;
    }

    positions.put(val, values.size());
    values.add(val);
    return true;
  }

  public boolean remove(int val) {
    if (!positions.containsKey(val)) {
      return false;
    }

    int lastElement = values.get(values.size() - 1);
    int index = positions.get(val);
    values.set(index, lastElement);
    positions.put(lastElement, index);
    values.remove(values.size() - 1);
    positions.remove(val);
    return true;
  }

  public int getRandom() {
    int index = random.nextInt(values.size());
    return values.get(index);
  }
}
