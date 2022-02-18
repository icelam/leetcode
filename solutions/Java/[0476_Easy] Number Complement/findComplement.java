class Solution {
  public int findComplement(int num) {
    String[] binaryBits = Integer.toBinaryString(num).split("");
    StringBuilder result = new StringBuilder(binaryBits.length);

    for (String bit: binaryBits) {
      result.append(bit.equals("0") ? "1" : "0");
    }
    return Integer.parseInt(result.toString(), 2);
  }
}

