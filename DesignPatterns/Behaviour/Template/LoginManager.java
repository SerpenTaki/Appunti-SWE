package Behaviour.Template;

/**
 * Defines the algorithm skeleton for log in process.*/

public abstract class LoginManager {
    /**
     * This is the template method. It defines the abstract algorithm and leaves to abstract
     * primitive operation to define the actual behaviour of each single algorithm step.
     * @param username A username
     * @param password Username password
     * @return Something that stores user information
     */
    public User login(String username, String password) {
        validateInput(username, password);
        // A hook is a method that gives a default behaviour inside the algorithm, which can be
        // override by abstract class extensions
        postValidationOpHook(username, password);
        authenticate(username, password);
        return authorizeHook(username);
    }

    /**
     * This hook gives an empty behaviour. So, it is a convenient way to
     * leave some extension point for future implementation (do not abuse it!)
     * @param username
     * @param password
     */
    private void postValidationOpHook(String username, String password) {

    }

    protected User authorizeHook(String username) {
        // Retrieves roles from database
        return null;
    }

    /**
     * This is call a primitive operation. The actual behaviour is defined in
     * actual classes that extends from LoginManager
     * @param username
     * @param password
     */
    protected abstract void authenticate(String username, String password);

    protected abstract void validateInput(String username, String password);
}
