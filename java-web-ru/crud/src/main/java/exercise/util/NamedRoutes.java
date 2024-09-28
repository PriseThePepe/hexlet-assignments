package exercise.util;

public class NamedRoutes {

    public static String rootPath() {
        return "/";
    }

    public static String postsPath() {
        return "/posts";
    }

    public static String postsPath(int page) {
        return "/posts?page=" + page;
    }


    public static String postPath(long id) {
        return "/posts/" + id;
    }
    public static String postPath(String id) {
        return "/posts/" + id;
    }
    public static String postPath(Long id) {
        return postPath(String.valueOf(id));
    }
    // END
}
