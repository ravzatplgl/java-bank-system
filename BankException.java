public class BankException extends Exception {

    public BankException(String source, String message) {
        super(source + ": " + message);
    }
}