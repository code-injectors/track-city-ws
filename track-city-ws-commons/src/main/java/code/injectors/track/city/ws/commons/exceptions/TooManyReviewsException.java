package code.injectors.track.city.ws.commons.exceptions;

/**
 * @author Chatzakis Nikolaos
 */
public class TooManyReviewsException extends RuntimeException {

    public TooManyReviewsException() {
    }

    public TooManyReviewsException(String message) {
        super(message);
    }
}
