class FoodRatings {
  private HashMap<String, PriorityQueue<Pair<String, Integer>>> highestRatingByCuisine;
  private HashMap<String, Integer> foodRatings;
  private HashMap<String, String> foodCategory;

  public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
    highestRatingByCuisine = new HashMap<>();
    foodCategory = new HashMap<>();
    foodRatings = new HashMap<>();
    int n = foods.length;

    Comparator<Pair<String, Integer>> comparator = new Comparator<Pair<String, Integer>>() {
      @Override
      public int compare(final Pair<String, Integer> a, final Pair<String, Integer> b) {
        String nameA = a.getKey();
        String nameB = b.getKey();
        int ratingA = a.getValue();
        int ratingB = b.getValue();

        if (ratingA == ratingB) {
          return nameA.compareTo(nameB);
        }

        return ratingB - ratingA;
      }
    };

    for (int i = 0; i < n; i++) {
      highestRatingByCuisine
        .computeIfAbsent(cuisines[i], k -> new PriorityQueue<Pair<String, Integer>>(comparator))
        .add(new Pair<>(foods[i], ratings[i]));
      foodCategory.put(foods[i], cuisines[i]);
      foodRatings.put(foods[i], ratings[i]);
    }
  }

  public void changeRating(String food, int newRating) {
    foodRatings.put(food, newRating);
    highestRatingByCuisine.get(foodCategory.get(food)).add(new Pair<>(food, newRating));
  }

  public String highestRated(String cuisine) {
    PriorityQueue<Pair<String, Integer>> cuisineRatings = highestRatingByCuisine.get(cuisine);

    int currentRating = cuisineRatings.peek().getValue();
    int validRating = foodRatings.get(cuisineRatings.peek().getKey());

    while (currentRating != validRating) {
      cuisineRatings.remove();
      currentRating = cuisineRatings.peek().getValue();
      validRating = foodRatings.get(cuisineRatings.peek().getKey());
    }

    return cuisineRatings.peek().getKey();
  }
}
