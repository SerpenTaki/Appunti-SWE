package Behaviour.Template;

import java.util.Objects;

/**
 * A login manager that authenticates a user against Facebook. The skeleton of the
 * authentication algorithm is given in the abstract super class, whereas the
 * primitive operations are implemented here.
 */
public class FacebookLoginManager extends LoginManager {

    @Override
    protected User authorizeHook(String username) {
        // Retrieves Facebook profile information and extracts roles from it
        return null;
    }

    @Override
    protected void authenticate(String username, String password) {
        // Calls some awesome Facebook auth service
    }

    @Override
    protected void validateInput(String username, String password) {
        if (Objects.isNull(username)) {
            throw new IllegalArgumentException("Username must not be null during Facebook authentication");
        }
    }
}