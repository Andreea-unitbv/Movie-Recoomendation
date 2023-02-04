package com.example.demo;

public class Query {
    public static String selectMovie;

    public static String getSelectMovie(String userId) {
        return "SELECT m.title, m.genre " +
                "FROM movie m " +
                "LEFT JOIN movie_likes ml ON m.id = ml.movie_id AND ml.user_id = " + userId + " " +
                "WHERE ml.movie_id IS NULL " +
                "ORDER BY " +
                "  (SELECT COUNT(*) " +
                "   FROM movie_likes " +
                "   WHERE genre = m.genre AND user_id = " + userId + ") DESC, " +
                "  m.genre, " +
                "  m.title;";
    }

}
