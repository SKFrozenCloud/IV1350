package se.kth.iv1350.controller;

/**
 * Represents an exception that is thrown by an operation error
 */
public class OperationFailedException extends Exception {
    /**
     * Creates a new instance of exception
     * 
     * @param msg   - message for exception
     * @param cause type of exception being thrown
     */
    public OperationFailedException(String msg, Exception cause) {
        super(msg, cause);
    }
}
