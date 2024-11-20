package exceptions;


/**
 * Exception thrown when attempting to access or remove elements from an empty queue
 * 
 * @author Nathan
 * @version 1.0
 */
public class EmptyQueueException extends Exception {
    /**
     * Constructs a new EmptyQueueException, specifying the message to be "Queue is empty".
     */
    public EmptyQueueException() {
        super("Queue is empty.");
    }
}