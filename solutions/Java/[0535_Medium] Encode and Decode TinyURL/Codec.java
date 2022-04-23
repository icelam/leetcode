public class Codec {
  // Hashmap that mocks a database
  private HashMap<String, String> table;
  // Using long to enable storing of more URLs
  private long id;
  // Domain of tiny url service
  private String tinyUrlDomain;

  public Codec() {
    table = new HashMap<String, String>();
    id = 0;
    tinyUrlDomain = "http://tinyurl.com/";
  }

  // Generates hash from auto increment id
  public String generateHash(long value) {
    String hashChars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    int hashCharsLength = hashChars.length();
    StringBuilder result = new StringBuilder();

    while (value > 0) {
      if (value % hashCharsLength == 0) {
        result.append(hashChars.charAt(hashCharsLength - 1));
        value = value / hashCharsLength - 1;
      } else {
        int position = (int) ((value % hashCharsLength) - 1);
        result.append(hashChars.charAt(position));
        value = value / hashCharsLength;
      }
    }

    return result.reverse().toString();
  }

  // Encodes a URL to a shortened URL.
  public String encode(String longUrl) {
    String key = generateHash(++id);
    table.put(key, longUrl);
    return tinyUrlDomain + key;
  }

  // Decodes a shortened URL to its original URL.
  public String decode(String shortUrl) {
    String key = shortUrl.replace(tinyUrlDomain, "");
    return table.get(key);
  }
}
