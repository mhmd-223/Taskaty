import utilities.QueryBuilder;

/**
 * The entry point of the class
 */
public class App {
    public static void main(String[] args) {

        String query =
                new QueryBuilder()
                        .select("*")
                        .from("user")
                        .where("username=" + "'ali raed'")
                        .build();
        System.out.println(query);

    }
}

