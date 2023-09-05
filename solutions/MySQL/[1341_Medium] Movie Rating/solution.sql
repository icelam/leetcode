SELECT name AS results FROM (
  SELECT Users.name FROM MovieRating
  JOIN Users ON Users.user_id = MovieRating.user_id
  GROUP BY MovieRating.user_id
  ORDER BY COUNT(MovieRating.user_id) DESC, Users.name ASC
  LIMIT 1
) TopRatedUser
UNION ALL
SELECT title AS results FROM (
  SELECT Movies.title FROM MovieRating
  JOIN Movies ON Movies.movie_id = MovieRating.movie_id
  WHERE MovieRating.created_at BETWEEN '2020-02-01' AND '2020-02-29'
  GROUP BY MovieRating.movie_id
  ORDER BY AVG(MovieRating.rating) DESC, Movies.title ASC
  LIMIT 1
) TopRatedMovie;
