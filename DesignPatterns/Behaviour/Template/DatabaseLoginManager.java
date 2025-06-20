package Behaviour.Template;

import java.util.Objects;

/**
 * A login manager that authenticates a user against an internal database.
 *
 */
public class DatabaseLoginManager extends LoginManager {

    @Override
    protected User authorizeHook(String username) {
        // Retrieving from database
        return null;
    }

    @Override
    protected void authenticate(String username, String password) {
        // Retrieving from database
    }

    @Override
    protected void validateInput(String username, String password) {
        if (Objects.isNull(username)) {
            throw new IllegalArgumentException("Username must not be null");
        }
    }
}
