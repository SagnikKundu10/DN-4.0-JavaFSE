import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ParameterizedLoggingExample {

    private static final Logger logger = LoggerFactory.getLogger(ParameterizedLoggingExample.class);

    public static void main(String[] args) {
        String username = "Sagnik";
        int loginAttempts = 3;

        logger.info("User {} has logged in successfully.", username);
        logger.warn("User {} has attempted to log in {} times unsuccessfully.", username, loginAttempts);
        logger.error("Login failed for user {} after {} attempts.", username, loginAttempts);
    }
}
