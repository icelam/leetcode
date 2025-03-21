class Solution {
  public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
    Set<String> availableSupplies = new HashSet<>();
    HashMap<String, Integer> recipeIndex = new HashMap<>();
    HashMap<String, List<String>> graph = new HashMap<>();

    for (String supply : supplies) {
      availableSupplies.add(supply);
    }

    for (int i = 0; i < recipes.length; i++) {
      recipeIndex.put(recipes[i], i);
    }

    int[] inDegree = new int[recipes.length];

    for (int i = 0; i < recipes.length; i++) {
      for (String ingredient : ingredients.get(i)) {
        if (!availableSupplies.contains(ingredient)) {
          graph.putIfAbsent(ingredient, new ArrayList<String>());
          graph.get(ingredient).add(recipes[i]);
          inDegree[i]++;
        }
      }
    }

    Queue<Integer> queue = new LinkedList<>();
    List<String> result = new ArrayList<>();

    for (int i = 0; i < recipes.length; i++) {
      if (inDegree[i] == 0) {
        queue.add(i);
      }
    }

    while (!queue.isEmpty()) {
      String recipe = recipes[queue.remove()];
      result.add(recipe);

      if (!graph.containsKey(recipe)) {
        continue;
      }

      for (String dependentRecipe : graph.get(recipe)) {
        inDegree[recipeIndex.get(dependentRecipe)]--;

        if (inDegree[recipeIndex.get(dependentRecipe)] == 0) {
          queue.add(recipeIndex.get(dependentRecipe));
        }
      }
    }

    return result;
  }
}
