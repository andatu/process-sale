package integration;

/**
 * This class is an Exception that is thrown anytime we cannot.
 * reach data in the database for whatever reason.
 */
public class ConnectionToDBFailedException extends RuntimeException {

    /**
     * This constructor instantiates this class with a specified message
     *
     * @param msg the message that we want logged/displayed. describes the exception
     */
    ConnectionToDBFailedException(String msg) {
        super(msg);
    }
}