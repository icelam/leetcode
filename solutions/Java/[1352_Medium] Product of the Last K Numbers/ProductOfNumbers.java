class ProductOfNumbers {
  private int size = 0;
  private ArrayList<Integer> prefixProduct = new ArrayList<>();

  public ProductOfNumbers() {
    this.size = 0;
    this.prefixProduct.add(1);
  }

  public void add(int num) {
    if (num == 0) {
      this.size = 0;
      this.prefixProduct.removeAll(this.prefixProduct);
      this.prefixProduct.add(1);
      return;
    }

    this.prefixProduct.add(this.prefixProduct.get(size) * num);
    this.size++;
  }

  public int getProduct(int k) {
    return k > this.size
      ? 0
      : this.prefixProduct.get(this.size) / this.prefixProduct.get(this.size - k);
  }
}
