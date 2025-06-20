package MVC;

/**
 * An ATM application. Available operation are deposit and withdraw. The MVC pattern shows how to solve this problem
 * in an elegant way that has the focus to divide the properly concerns.
 */
public class ATM {
    public static void main(String[] args) {
        // Dependency injection
        final BankAccount bankAccount = new BankAccount(1000.0D);
        final CLI cli = new CLI(bankAccount);
        final Controller controller = new Controller(cli, bankAccount);

        // Starting the application
        while (true) {
            cli.askForNextOperation();
            cli.readNextOperation();
        }
    }
}

