package geekbrains;

public class ApplicationUncheckedException extends RuntimeException {
    public ApplicationUncheckedException() {
    }

    public ApplicationUncheckedException(String message) {
        super(message);
    }

    public ApplicationUncheckedException(String message, Throwable cause) {
        super(message, cause);
    }
}
