package utilities;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordHashing {

    public static String hash(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    public static boolean isMatch(String password, String encrypted) {
        return BCrypt.checkpw(password, encrypted);
    }
}
