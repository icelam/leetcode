class AuthenticationManager {
  private HashMap<String, Integer> tokens;
  private HashMap<Integer, Integer> tokenCount;
  private int timeToLive;

  public AuthenticationManager(int timeToLive) {
    this.timeToLive = timeToLive;
    this.tokens = new HashMap<String, Integer>();
    this.tokenCount = new HashMap<Integer, Integer>();
  }

  public void generate(String tokenId, int currentTime) {
    int expiryTime = currentTime + timeToLive;
    tokens.put(tokenId, expiryTime);
    tokenCount.put(expiryTime, tokenCount.getOrDefault(expiryTime, 0) + 1);
  }

  public void renew(String tokenId, int currentTime) {
    if (tokens.containsKey(tokenId) && tokens.get(tokenId) > currentTime) {
      int originalExpiryTime = tokens.get(tokenId);
      tokenCount.put(originalExpiryTime, tokenCount.get(originalExpiryTime) - 1);
      generate(tokenId, currentTime);
    }
  }

  public int countUnexpiredTokens(int currentTime) {
    int sum = 0;

    for (Integer time : tokenCount.keySet()) {
      if (time > currentTime) {
        sum += tokenCount.get(time);
      }
    }

    return sum;
  }
}
