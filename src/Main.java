import twitter.Twitter;
import twitter.dataHendler.UserHandler;

import java.util.*;





public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserHandler userHandler = new UserHandler();

        Twitter twitter = new Twitter(scanner, userHandler);
        twitter.run();
    }
}
