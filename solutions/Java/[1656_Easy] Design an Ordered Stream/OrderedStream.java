class OrderedStream {
  private String[] stream;
  private int pointer;

  public OrderedStream(int n) {
    stream = new String[n + 1];
    pointer = 1;
  }

  public List<String> insert(int idKey, String value) {
    stream[idKey] = value;
    List<String> chunk = new ArrayList<String>();

    while (pointer < stream.length && stream[pointer] != null) {
      chunk.add(stream[pointer]);
      pointer++;
    }

    return chunk;
  }
}
